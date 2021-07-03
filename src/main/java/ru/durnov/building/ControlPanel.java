package ru.durnov.building;

import ru.durnov.log.LogRecord;

import java.util.ArrayList;
import java.util.List;

public class ControlPanel implements Device{
    private final String macAddress;
    private final List<LogRecord> logRecords;

    public ControlPanel(String macAddress){
        this.macAddress = macAddress;
        this.logRecords = new ArrayList<>();
    }


    @Override
    public void addRecord(LogRecord logRecord) {
        this.logRecords.add(logRecord);
    }

    @Override
    public List<LogRecord> logRecords() {
        return this.logRecords;
    }
}
