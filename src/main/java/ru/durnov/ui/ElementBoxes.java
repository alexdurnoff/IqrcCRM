package ru.durnov.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.HBox;
import ru.durnov.building.ChoosePaneElement;

import java.util.ArrayList;
import java.util.List;

public class ElementBoxes<T extends ChoosePaneElement>{
    private final ObservableList<ElementHBox<T>> elementHBoxList;


    public ElementBoxes(ObservableList<T> elements, ObservableList<T> chosenElements) {
        this.elementHBoxList = FXCollections.observableList(new ArrayList<>());
        elements.forEach(t -> {
            this.elementHBoxList.add(new ElementHBox<>(t, chosenElements));
        });
    }

    public void selectAll(){
        this.elementHBoxList.forEach(ElementHBox::select);
    }

    public List<ElementHBox<T>> hBoxList(){
        return new ArrayList<>(this.elementHBoxList);
    }
}
