package ru.durnov.dao;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ROOMS")
public class Room {
    @Id
    @Column(name = "ROOMID")
    private int id;

    @Column(name = "ROOMNAME")
    String roomName;

    @OneToMany(mappedBy = "room",fetch = FetchType.EAGER)
    Set<Device> devices = new HashSet<>();
}
