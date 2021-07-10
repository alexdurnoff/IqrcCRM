package ru.durnov.ui;

import javafx.scene.layout.GridPane;
import ru.durnov.building.Block;

import java.util.Collections;
import java.util.Set;

public abstract class WorkPane extends GridPane {
    private final UserChoosePane userChoosePane;

    protected WorkPane(Set<Block> blockSet){
        this.userChoosePane = new UserChoosePane(blockSet);
    }

    protected WorkPane(){
        this(Collections.emptySet());
    }

    public void withBlocks(Set<Block> blocks){

    }
}
