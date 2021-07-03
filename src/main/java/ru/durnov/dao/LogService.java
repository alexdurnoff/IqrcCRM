package ru.durnov.dao;

import ru.durnov.building.Room;

import java.util.Set;

public class LogService implements DaoService{
    private final DataBase dataBase;

    public LogService(String userName, String password, int port){
        this.dataBase = new CentralBlockDataBase(userName, password, port);
    }




    @Override
    public Set<Room> roomSet() {
        return this.dataBase.roomSet();
    }


}
