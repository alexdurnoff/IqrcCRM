package ru.durnov.dao;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Device {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ROOMID")
    private Room room;
}
