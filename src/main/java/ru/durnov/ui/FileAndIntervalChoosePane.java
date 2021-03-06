package ru.durnov.ui;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

public class FileAndIntervalChoosePane {
    private final TextField fileTextFiled = new TextField();
    private final TextField intervalTextField = new TextField();

    public FileAndIntervalChoosePane(){
        Button fileButton = new Button("Выбрать файл для выгрузки");
        fileButton.setOnAction(ae ->{
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showSaveDialog(new Stage());
            fileTextFiled.setText(file.getAbsolutePath());
            fileTextFiled.setUserData(file);
        });
        Button intervalButton = new Button("Выбрать интервал для выгрузки");
        intervalButton.setOnAction(ae -> {
            Optional<DateInterval> optional = new DataIntervalChooserDialog().showAndWait();
            optional.ifPresent(interval -> intervalTextField.setUserData(optional.get()));
        });
    }

    public File file(){
        return (File) this.fileTextFiled.getUserData();
    }

    public DateInterval dateInterval(){
        return (DateInterval) this.intervalTextField.getUserData();
    }
}
