package ru.durnov.dao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ROOMS")
public class RoomEntity {
    @Id
    @Column(name = "ROOMID")
    private int id;

    @Column(name = "ROOMNAME")
    String roomName;

    @OneToMany(mappedBy = "room",fetch = FetchType.EAGER)
    Set<DeviceEntity> deviceEntities = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Set<DeviceEntity> getDeviceEntities() {
        return deviceEntities;
    }

    public void setDeviceEntities(Set<DeviceEntity> deviceEntities) {
        this.deviceEntities = deviceEntities;
    }
}
