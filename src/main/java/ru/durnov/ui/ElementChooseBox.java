package ru.durnov.ui;

import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import ru.durnov.building.ChoosePaneElement;

public class ElementChooseBox <T extends ChoosePaneElement> extends HBox {
    private final T element;
    private final CheckBox checkBox;
    private final ObservableList<T> elements;

    public ElementChooseBox(T element, ObservableList<T> elements) {
        this.element = element;
        this.elements = elements;
        TextField textField = new TextField(element.name());
        this.checkBox = new CheckBox();
        this.checkBox.setOnAction(ae -> {
            if (checkBox.isSelected()){
                this.elements.add(this.element);
            } else {
                this.elements.remove(this.element);
            }
        });
        this.getChildren().addAll(checkBox, textField);
    }
}
