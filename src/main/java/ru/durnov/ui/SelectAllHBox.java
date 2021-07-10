package ru.durnov.ui;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import ru.durnov.building.ChoosePaneElement;

public class SelectAllHBox extends HBox {

    public <T extends ChoosePaneElement> SelectAllHBox(ElementBoxes<T> elementBoxes) {
        CheckBox checkBox = new CheckBox();
        TextField textField = new TextField("Выбрать все");
        this.getChildren().addAll(checkBox, textField);
        checkBox.setOnAction(ae -> elementBoxes.selectAll());
    }
}
