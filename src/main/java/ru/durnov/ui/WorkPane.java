package ru.durnov.ui;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import ru.durnov.building.Block;
import ru.durnov.building.Blocks;
import ru.durnov.building.Room;

import java.util.ArrayList;
import java.util.Set;

public abstract class WorkPane extends GridPane {
    private final ChoosePane<Block> blockChoosePane;
    private final ChoosePane<Room> roomChoosePane;
    private final ObservableList<Block> blocks;
    private final ObservableList<Block> chosenBlocks = FXCollections.observableList(new ArrayList<>());
    private final Rooms rooms;

    public WorkPane(Set<Block> blockSet){
        this.blocks = FXCollections.observableList(new ArrayList<>(blockSet));
        this.blockChoosePane = new ChoosePane<>(this.blocks, chosenBlocks);
        this.rooms = new Rooms(this.chosenBlocks);
        this.roomChoosePane = new ChoosePane<>(this.rooms.rooms());
        this.add(blockChoosePane, 0, 0);
        this.add(roomChoosePane, 1, 0);
    }
}
