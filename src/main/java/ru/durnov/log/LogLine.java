package ru.durnov.log;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LogLine implements LogRecord {
    private final LocalDate localDate;
    private final String string;

    public LogLine(LocalDate localDate, String string) {
        this.localDate = localDate;
        this.string = string;
    }


    @Override
    public String macAddress() {
        return null;
    }

    @Override
    public LocalDateTime localDateTime() {
        return null;
    }

    @Override
    public Status status() {
        return null;
    }
}
