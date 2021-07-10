package ru.durnov.ui;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import ru.durnov.building.Block;
import ru.durnov.building.Blocks;
import ru.durnov.building.Room;

import java.util.ArrayList;
import java.util.Set;

public abstract class WorkPane extends Pane {
    private final ObservableList<Block> blockList;
    private final ObservableList<Room> roomList;
    private final ChoosePane<Block> blockChoosePane;
    private final ChoosePane<Room> roomChoosePane;

    public WorkPane(Set<Block> blockSet) {
        this.blockList = FXCollections.observableList(new ArrayList<>(blockSet));
        this.roomList = FXCollections.observableList(new ArrayList<>(new Blocks(blockSet).roomElementSet()));
        this.blockChoosePane = new ChoosePane<>(blockList);
        this.roomChoosePane = new ChoosePane<>(roomList);
        this.blockList.addListener(new ListChangeListener<Block>() {
            @Override
            public void onChanged(Change<? extends Block> c) {
                roomList.clear();
                blockList.forEach(block -> {
                    roomList.addAll(block.roomSet());
                });
            }
        });
    }
}
