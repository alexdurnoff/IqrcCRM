package ru.durnov.ui;

import java.time.LocalDate;

public class DateInterval {
    private LocalDate beginIntervalValue;
    private LocalDate engIntervalValue;

    public LocalDate getBeginIntervalValue() {
        return beginIntervalValue;
    }

    public void setBeginIntervalValue(LocalDate beginIntervalValue) {
        this.beginIntervalValue = beginIntervalValue;
    }

    public LocalDate getEngIntervalValue() {
        return engIntervalValue;
    }

    public void setEngIntervalValue(LocalDate engIntervalValue) {
        this.engIntervalValue = engIntervalValue;
    }

    public int getDaysLength(){
        int result = 0;
        LocalDate localDate = beginIntervalValue;
        while (engIntervalValue.compareTo(localDate) > 0){
            result++;
            localDate = localDate.plusDays(1);
        }
        return result;
    }

    @Override
    public String toString() {
        return beginIntervalValue +
                "-" + engIntervalValue;
    }
}
