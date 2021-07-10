package ru.durnov.building;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Blocks {
    private final Set<Block> blockSet;

    public Blocks(Set<Block> blockSet) {
        this.blockSet = blockSet;
    }

    public Set<Block> blockElementSet(){
        return new LinkedHashSet<>(this.blockSet);
    }

    public Set<Room> roomElementSet(){
        Set<Room> roomSet = new LinkedHashSet<>();
        this.blockSet.forEach(block -> roomSet.addAll(block.roomSet()));
        return roomSet;
    }
}
