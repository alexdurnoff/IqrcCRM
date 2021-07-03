package ru.durnov.dao;

import ru.durnov.building.Device;
import ru.durnov.building.Room;

import java.util.Set;

public interface DataBase {
    Set<Room> roomSet();
    Set<Device> deviseSet();

}
