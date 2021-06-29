package ru.durnov.building;

import java.util.ArrayList;
import java.util.List;



public class BuildingRoom {

    private final RoomDevice controlPane;
    private final List<RoomDevice> roomDeviceList = new ArrayList<>();

    public BuildingRoom(RoomDevice controlPane, List<RoomDevice> roomDeviceList){
        this.controlPane = controlPane;
        this.roomDeviceList.addAll(roomDeviceList);
    }
}
