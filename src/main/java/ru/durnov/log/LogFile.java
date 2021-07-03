package ru.durnov.log;

public class LogFile implements Log{
    @Override
    public LogRecord nextRecord() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }
}
