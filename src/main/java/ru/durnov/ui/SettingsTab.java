package ru.durnov.ui;

import javafx.scene.control.Tab;

public class SettingsTab extends Tab {
    private final SettingsPane settingsPane;
    public SettingsTab(SettingsPane settingsPane) {
        this.settingsPane = settingsPane;
    }
}
