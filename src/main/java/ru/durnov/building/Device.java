package ru.durnov.building;

import ru.durnov.log.LogRecord;

import java.util.List;

public interface Device {
    void addRecord(LogRecord logRecord);
    List<LogRecord> logRecords();
}
