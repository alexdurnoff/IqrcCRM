package ru.durnov.ui;

import javafx.scene.layout.FlowPane;
import ru.durnov.building.Block;

import java.util.Set;

public class SettingsPane extends FlowPane {
    private final Set<Block> blockSet;

    public SettingsPane(Set<Block> blockSet) {
        this.blockSet = blockSet;
    }
}
