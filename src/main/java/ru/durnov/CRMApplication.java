package ru.durnov;

import javafx.application.Application;
import javafx.stage.Stage;
import ru.durnov.auth.Authentication;
import ru.durnov.auth.ExitCentralBlock;
import ru.durnov.building.Block;

public class CRMApplication extends Application {
    private final Authentication authentication = new Authentication();


    @Override
    public void start(Stage primaryStage) throws Exception {
        Block block = authentication.centralBlock();
        System.out.println(block.getClass());
    }
}
