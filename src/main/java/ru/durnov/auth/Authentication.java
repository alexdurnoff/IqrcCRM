package ru.durnov.auth;

import ru.durnov.building.Block;
import ru.durnov.building.CentralBlock;

import java.util.Optional;

public class Authentication {
    private final Dialog dialog = new Dialog();

    public Authentication() {

    }

    public Block centralBlock(){
        Optional<Block> optional = this.dialog.showAndWait();
        if (isExit()) {
            return new EmptyCentralBlock();
        }
        return optional.orElseGet(() -> new Authentication().centralBlock());
    }

    public boolean isExit() {
        return this.dialog.isExit();
    }
}
