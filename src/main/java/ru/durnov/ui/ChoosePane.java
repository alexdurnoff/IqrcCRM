package ru.durnov.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import ru.durnov.building.ChoosePaneElement;

import java.util.ArrayList;

public class ChoosePane<T extends ChoosePaneElement> {
    private final ObservableList<T> list;
    private final ObservableList<T> chosenList;
    private final ListView<HBox> listView = new ListView<>();

    public ChoosePane(ObservableList<T> list) {
        this.list = list;
        this.chosenList = FXCollections.observableList(new ArrayList<>());
        ElementBoxes<T> elementBoxes = new ElementBoxes<>(list, chosenList);
        this.listView.getItems().add(new SelectAllHBox(elementBoxes));
        this.listView.getItems().addAll(elementBoxes.hBoxList());
    }
}
