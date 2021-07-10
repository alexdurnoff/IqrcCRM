package ru.durnov.ui;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import ru.durnov.building.ChoosePaneElement;



public class ChoosePaneElementListView <T extends ChoosePaneElement> extends ListView<HBox> {
    private final ObservableList<T> list;
    private final ObservableList<T> chosenList;


    public ChoosePaneElementListView(ObservableList<T> list, ObservableList<T> chosenList) {
        this.list = list;
        this.chosenList = chosenList;
        fill();
    }

    public void clear(){
        chosenList.clear();
        this.getItems().clear();
    }

    public void fill(){
        ElementBoxes<T> elementBoxes = new ElementBoxes<>(list, chosenList);
        this.getItems().add(new SelectAllHBox(elementBoxes));
        this.getItems().addAll(elementBoxes.hBoxList());
    }
}
