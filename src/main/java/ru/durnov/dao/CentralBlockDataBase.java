package ru.durnov.dao;

import ru.durnov.building.Device;
import ru.durnov.building.Room;

import java.util.Set;

public class CentralBlockDataBase implements DataBase{


    public CentralBlockDataBase(String userName, String password, int port) {

    }

    @Override
    public Set<Room> roomSet() {
        return null;
    }

    @Override
    public Set<Device> deviseSet() {
        return null;
    }
}
