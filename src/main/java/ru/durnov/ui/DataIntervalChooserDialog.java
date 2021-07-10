package ru.durnov.ui;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;


public class DataIntervalChooserDialog extends Dialog<DateInterval> {
    private final DateInterval dateInterval;

    public DataIntervalChooserDialog(){
        this.dateInterval = new DateInterval();
        this.setHeight(300);
        this.setWidth(500);
        this.setResizable(true);
        DatePicker beginDatePicker = new DatePicker();
        beginDatePicker.setOnAction(ae -> this.dateInterval.setBeginIntervalValue(beginDatePicker.getValue()));
        Label beginDataPickerLabel = new Label("Выбрать начало интервала выгрузки");
        DatePicker endDatePicker = new DatePicker();
        endDatePicker.setOnAction(ae -> this.dateInterval.setEngIntervalValue(endDatePicker.getValue()));
        Label endDataPickerLabel = new Label("Выбрать окончание интервала выгрузки");
        GridPane gridPane = new GridPane();
        gridPane.add(beginDataPickerLabel, 0, 0);
        gridPane.add(beginDatePicker, 1, 0);
        gridPane.add(endDataPickerLabel, 0, 1);
        gridPane.add(endDatePicker, 1, 1);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        this.getDialogPane().setContent(gridPane);
        ButtonType buttonTypeOk = ButtonType.OK;
        this.getDialogPane().getButtonTypes().add(buttonTypeOk);
        this.setResult(dateInterval);
        this.setResultConverter(new MyConverter());
    }

    class MyConverter implements Callback<ButtonType, DateInterval>{
        @Override
        public DateInterval call(ButtonType param) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setResizable(true);
            if (dateInterval.getBeginIntervalValue() == null){
                alert.setContentText("Не задано начало интервала выгрузки");
                alert.showAndWait();
            } else if (dateInterval.getEngIntervalValue() == null) {
                alert.setContentText("Не задан конец интервала выгрузки");
                alert.showAndWait();
            }
            return dateInterval;
        }
    }
}
