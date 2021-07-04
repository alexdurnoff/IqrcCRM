package ru.durnov.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import ru.durnov.building.Block;
import ru.durnov.building.ChoosePaneElement;

import java.util.ArrayList;
import java.util.Set;

public class ChoosePane<T extends ChoosePaneElement> extends BorderPane {
    private final Set<T> elements;
    private final ObservableList<ChoosePaneElement> chosenElements;
    private final ElementsListView elementsListView;

    public ChoosePane(Set<T> elements) {
        this.elements = elements;
        this.chosenElements = FXCollections.observableList(new ArrayList<>());
        this.elementsListView = new ElementsListView(elements, chosenElements);
    }

    public void addConsumerPane(ChoosePane choosePane){
        this.elementsListView.addConsumerList(choosePane.elementsListView);
    }
}
