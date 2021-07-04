package ru.durnov.ui;

import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import ru.durnov.building.ChoosePaneElement;

import java.util.Collection;
import java.util.Set;

public class Items <T extends ChoosePaneElement> {
    private final CheckBox selectAllCheckBox = new CheckBox("Выбрать все");
    private final ObservableList<HBox> hBoxList;
    private final Set<T> elements;
    private final ObservableList<T> choosePaneElements;

    public Items(Set<T> elements,
                 ObservableList<HBox> hBoxList,
                 ObservableList<T> choosePaneElements ) {
        this.elements = elements;
        this.hBoxList = hBoxList;
        this.choosePaneElements = choosePaneElements;
        this.selectAllCheckBox.setOnAction(ae -> {
            this.clear();
            this.fill();
        });
    }

    public void fill(){
        this.hBoxList.add(new HBox(selectAllCheckBox));
        this.addElements(this.elements);
    }

    public void clear(){
        this.hBoxList.clear();
    }

    public void addElements(Collection<T> elementCollection){
        this.clear();
        this.choosePaneElements.clear();
        elementCollection.forEach(choosePaneElement -> {
            this.hBoxList.add(new ElementChooseBox<T>(
                    choosePaneElement,
                    choosePaneElements
            ));
        });
        this.fill();
    }
}
