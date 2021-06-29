package ru.durnov.dao;

import ru.durnov.building.RoomDevice;
import ru.durnov.building.BuildingRoom;

import java.util.Set;

public interface DataBase {
    Set<BuildingRoom> roomSet();
    Set<RoomDevice> deviseSet();

}
