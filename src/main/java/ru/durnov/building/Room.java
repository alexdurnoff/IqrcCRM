package ru.durnov.building;

import ru.durnov.dao.RoomEntity;
import ru.durnov.log.LogRecord;

import java.util.*;


public class Room {
    private final Device controlPanel;
    private final Map<String, Device> deviceMap;
    private final String roomName;

    public Room(RoomEntity entity){
        this.deviceMap = new HashMap<>();
        this.roomName = entity.getRoomName();
        entity.getDeviceEntities().forEach(deviceEntity -> {
            deviceMap.put(
                    deviceEntity.getMacAddress(),
                    new DeviceFactory(
                            deviceEntity.getMacAddress()
                    ).device()
            );
        });
        Collection<Device> values = this.deviceMap.values();
        ControlPanel controlPanel = null;
        for (Device device : values) {
            if (device instanceof ControlPanel) controlPanel = (ControlPanel) device;
        }
        this.controlPanel = controlPanel;
    }

    public void addRecord(LogRecord logRecord){
        this.deviceMap.get(logRecord.macAddress()).addRecord(logRecord);
    }
}
