package ru.durnov;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.durnov.auth.Authentication;
import ru.durnov.auth.ExitCentralBlock;
import ru.durnov.building.Block;
import ru.durnov.email.EmailService;
import ru.durnov.ui.IQRCTabPane;

public class CRMApplication extends Application {
    private final Authentication authentication = new Authentication();
    private final EmailService emailService = new EmailService();


    @Override
    public void start(Stage primaryStage) throws Exception {
        Block block = authentication.centralBlock();
        Scene scene = new Scene(new IQRCTabPane(block), 1200, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Программа анализа данных системы IQRC");
        primaryStage.show();
        primaryStage.setOnCloseRequest(e -> System.exit(0));
        emailService.start();
    }
}
