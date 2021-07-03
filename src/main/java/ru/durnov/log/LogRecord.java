package ru.durnov.log;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface LogRecord {
    String macAddress();
    LocalDateTime localDateTime();
    Status status();

}
