package ru.durnov.log;

public interface Log {
    LogRecord nextRecord();
    boolean hasNext();
}
