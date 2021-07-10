package ru.durnov.ui;

import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import ru.durnov.building.ChoosePaneElement;

public class ElementHBox<T extends ChoosePaneElement> extends HBox {
    private final CheckBox checkBox;

    public ElementHBox(T t, ObservableList<T> chosenElements){
        this.checkBox = new CheckBox();
        TextField textField = new TextField(t.name());
        this.getChildren().addAll(checkBox, textField);
        checkBox.setOnAction(ae -> {
            if (checkBox.isSelected()){
                chosenElements.add(t);
            } else {
                chosenElements.remove(t);
            }
        });
    }

    public void select(){
        this.checkBox.fire();
    }
}
