package ru.durnov.auth;

import ru.durnov.building.Block;


import java.util.Optional;
import java.util.function.Supplier;

public class Authentication {
    private final Dialog dialog = new Dialog();

    public Authentication() {

    }

    public Authentication(boolean isExit){
        if (isExit) System.exit(0);
    }

    public Block centralBlock(){
        Optional<Block> optional = this.dialog.showAndWait();
        if (isExit()) {
            System.exit(0);
        }
        return optional.orElseGet(this::centralBlock);
    }

    public boolean isExit() {
        return this.dialog.isExit();
    }
}
