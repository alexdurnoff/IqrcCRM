package ru.durnov.dao;

import ru.durnov.building.RoomDevice;
import ru.durnov.building.BuildingRoom;

import java.util.Set;

public class CentralBlockDataBase implements DataBase{


    public CentralBlockDataBase(String userName, String password, int port) {

    }

    @Override
    public Set<BuildingRoom> roomSet() {
        return null;
    }

    @Override
    public Set<RoomDevice> deviseSet() {
        return null;
    }
}
