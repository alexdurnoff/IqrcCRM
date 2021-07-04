package ru.durnov.ui;

import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import ru.durnov.building.ChoosePaneElement;

import java.util.Set;

public class ElementsListView <T extends ChoosePaneElement> extends ListView<HBox> {
    private final Set<T> elements;
    private final ObservableList<T> chosenElements;
    private final Items<T> items;

    public ElementsListView(Set<T> elements, ObservableList<T> chosenElements) {
        this.elements = elements;
        this.chosenElements = chosenElements;
        this.items = new Items<T>(this.elements, this.getItems(), this.chosenElements);
        this.items.fill();
    }

    public void fill(){
        this.items.fill();
    }

    public void  clear(){
        this.items.clear();
    }

    public void addConsumerList(ElementsListView<T> elementsListView){
        this.chosenElements.addListener(new ListChangeListener<ChoosePaneElement>() {
            @Override
            public void onChanged(Change<? extends ChoosePaneElement> c) {
                elementsListView.items.addElements(chosenElements);
            }
        });
    }


}
