package ru.durnov.dao;

import javax.persistence.*;

@Entity
@Table(name = "usbdevices")
public class DeviceEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROOMID")
    private RoomEntity roomEntity;

    @Column(name = "DEVICEMAC")
    private String macAddress;

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }
}
