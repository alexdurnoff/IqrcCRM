package ru.durnov.ui;

import javafx.scene.layout.Pane;
import ru.durnov.building.Block;
import ru.durnov.building.Room;

import java.util.HashSet;
import java.util.Set;

public abstract class WorkPane extends Pane {
    private final ChoosePane blockChoosePane;
    private final ChoosePane roomChoosePane;
    private final FileAndIntervalChoosePane fileAndIntervalChoosePane = new FileAndIntervalChoosePane();
    private final AutomatizationPane automatizationPane = new AutomatizationPane();
    private final IQRCSettingsPane iqrcSettingsPane = new IQRCSettingsPane();

    protected WorkPane(Set<Block> blockSet){
        this.blockChoosePane = new ChoosePane(blockSet);
        Set<Room> roomSet = new HashSet<>();
        blockSet.forEach(block -> roomSet.addAll(block.roomSet()));
        this.roomChoosePane = new ChoosePane(roomSet);
    }
}
