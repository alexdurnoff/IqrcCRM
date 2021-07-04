package ru.durnov.ui;

import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;

public class DataTab extends Tab {
    private final WorkPane pane;
    private final String title;


    public DataTab(WorkPane pane, String title) {
        this.pane = pane;
        this.setContent(pane);
        this.title = title;
        this.setDisable(true);
        this.setClosable(false);
    }
}
