package ru.durnov.building;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Interval {
    private final LocalDate start;
    private final LocalDate stop;
    private final List<String> dateStringList = new ArrayList<>();


    public Interval(LocalDate start, LocalDate stop) {
        this.start = start;
        this.stop = stop;
        LocalDate localDate = start;
        while (localDate.compareTo(stop) <= 0){
            this.dateStringList.add(localDate.toString());
            localDate = localDate.plusDays(1);
        }
    }

    public boolean dateIsInsideInterval(LocalDate localDate){
        return this.dateStringList.contains(localDate.toString());
    }

    public boolean dateIsInsideInterval(String dateString){
        return this.dateStringList.contains(dateString);
    }

    public boolean isLogFileName(String fileName){
        for (String str : dateStringList) {
            if (fileName.contains(str)) return true;
        }
        return false;
    }
}
