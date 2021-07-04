package ru.durnov.ui;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import ru.durnov.auth.AdminCentralBlock;
import ru.durnov.building.Block;

import java.util.HashSet;
import java.util.Set;

public class IQRCTabPane extends TabPane {
    private final Set<Block> blockSet = new HashSet<>();
    private final Tab jsonTab;
    private final Tab xlsxTab;
    private final Tab sqLiteTab;
    private final Tab settingsTab;


    public IQRCTabPane(Block block) {
        if (! (block instanceof AdminCentralBlock)) this.blockSet.add(block);
        this.jsonTab = new DataTab(new JsonPane(this.blockSet), "Выгрузка в Json");
        this.xlsxTab = new DataTab(new XlsxPane(this.blockSet), "Выгрузка в XLSX");
        this.sqLiteTab = new DataTab(new SqlitePane(this.blockSet), "Выгрузка в локальную базу");
        this.settingsTab = new SettingsTab(new SettingsPane(this.blockSet));
    }
}
