package ru.durnov.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;
import ru.durnov.building.Block;
import ru.durnov.building.Room;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Pane for user choose the rooms needed to upload
 */
public class UserChoosePane extends GridPane {
    private final ChoosePane<Block> blockChoosePane;
    private final ChoosePane<Room> roomChoosePane;
    private final ObservableList<Block> blocks;
    private final ObservableList<Block> chosenBlocks = FXCollections.observableList(new ArrayList<>());
    private final Rooms rooms;

    public UserChoosePane(Set<Block> blockSet){
        this.blocks = FXCollections.observableList(new ArrayList<>(blockSet));
        this.blockChoosePane = new ChoosePane<>(this.blocks, chosenBlocks);
        this.rooms = new Rooms(this.chosenBlocks);
        this.roomChoosePane = new ChoosePane<>(this.rooms.rooms());
        this.add(blockChoosePane, 0, 0);
        this.add(roomChoosePane, 1, 0);
    }

    public UserChoosePane(){
        this(Collections.emptySet());
    }

    public void withBlocks(Set<Block> blocks){
        this.blocks.clear();
        this.blocks.addAll(blocks);
        this.chosenBlocks.clear();
    }

    public List<Room> chosenRoomList(){
        return this.roomChoosePane.chosenList();
    }
}
