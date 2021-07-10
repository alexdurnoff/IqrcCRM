package ru.durnov.ui;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import ru.durnov.building.ChoosePaneElement;

import java.util.ArrayList;

public class ChoosePane<T extends ChoosePaneElement> extends FlowPane {
    private final ObservableList<T> list;
    private final ObservableList<T> chosenList;
    private final ChoosePaneElementListView<T> listView;

    public ChoosePane(ObservableList<T> list, ObservableList<T> chosenList) {
        this.list = list;
        this.chosenList = chosenList;
        this.listView = new ChoosePaneElementListView<>(list, chosenList);
        this.getChildren().add(this.listView);
        this.list.addListener(new ListChangeListener<T>() {
            @Override
            public void onChanged(Change<? extends T> c) {
                listView.clear();
                listView.fill();
            }
        });
    }

    public ChoosePane(ObservableList<T> list){
        this(list, FXCollections.observableList(new ArrayList<>()));
    }

    public ObservableList<T> chosenList(){
        return this.chosenList;
    }

}
