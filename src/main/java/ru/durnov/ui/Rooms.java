package ru.durnov.ui;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import ru.durnov.building.Block;
import ru.durnov.building.Room;

import java.util.ArrayList;

public class Rooms {
    private final ObservableList<Block> blocks;
    private final ObservableList<Room> rooms;

    public Rooms(ObservableList<Block> blocks) {
        this.blocks = blocks;
        this.rooms = FXCollections.observableList(new ArrayList<>());
        this.blocks.forEach(block -> this.rooms.addAll(block.roomSet()));
        this.blocks.addListener(new ListChangeListener<Block>() {
            @Override
            public void onChanged(Change<? extends Block> c) {
                rooms.clear();
                blocks.forEach(block -> rooms.addAll(block.roomSet()));
            }
        });
    }

    public ObservableList<Room> rooms(){
        return this.rooms;
    }


}
