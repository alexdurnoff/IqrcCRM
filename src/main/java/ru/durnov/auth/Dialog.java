package ru.durnov.auth;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import ru.durnov.building.Block;
import ru.durnov.building.CentralBlock;
import ru.durnov.building.SSH;
import ru.durnov.dao.LogService;

public class Dialog extends javafx.scene.control.Dialog<Block> {
    private final TextField userNameTextField;
    private final PasswordField passwordField;
    private final TextField ipAdressTextField;
    private final PrevisionSession previsionSession;
    private final ButtonType buttonType;
    private boolean exitCondition = false;

    public Dialog() {
        this.previsionSession = new PrevisionSession();
        this.userNameTextField = new TextField(this.previsionSession.userName());
        this.passwordField = new PasswordField();
        this.passwordField.textProperty().setValue(this.previsionSession.password());
        this.ipAdressTextField = new TextField(this.previsionSession.ip());
        this.buttonType = new ButtonType("Авторизоваться");
        this.setHeight(200);
        this.setWidth(400);
        this.setResizable(true);
        Label userNameLabel = new Label("Имя пользователя");
        Label passwordLabel = new Label("Пароль");
        Label ipAdressLabel = new Label("IP адрес");
        GridPane gridPane = new GridPane();
        this.setTitle("Окно авторизации");
        this.setHeaderText("Вход в приложение");
        gridPane.add(ipAdressLabel, 0, 0);
        gridPane.add(ipAdressTextField, 1, 0);
        gridPane.add(userNameLabel, 0, 1);
        gridPane.add(userNameTextField, 1, 1);
        gridPane.add(passwordLabel, 0 , 2);
        gridPane.add(passwordField, 1, 2);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        this.getDialogPane().setContent(gridPane);
        this.getDialogPane().getButtonTypes().add(buttonType);
        this.setResult(new ExitCentralBlock());
        this.setResultConverter(new MyConverter());
        this.setOnCloseRequest(e -> {
            if (this.getResult() instanceof ExitCentralBlock) this.exitCondition = true;
        });
        this.setOnShown(e -> this.exitCondition = false);
    }


    private class MyConverter implements javafx.util.Callback<ButtonType, Block> {
        @Override
        public Block call(ButtonType param) {
            if (userNameTextField.getText().equals("admin") && passwordField.getText().equals("1111")){
                previsionSession.save(
                        userNameTextField.getText(),
                        passwordField.getText(),
                        ipAdressTextField.getText()
                );
                return new AdminCentralBlock();
            }
            try {
                CentralBlock centralBlock = new CentralBlock(
                        userNameTextField.getText(),
                        new LogService(
                                userNameTextField.getText(),
                                passwordField.getText(),
                                3306
                        ),
                        new SSH(
                                ipAdressTextField.getText(),
                                22,
                                userNameTextField.getText(),
                                passwordField.getText()
                        )
                );
                previsionSession.save(
                        userNameTextField.getText(),
                        passwordField.getText(),
                        ipAdressTextField.getText()
                );
                return centralBlock;
            } catch (JSchException | SftpException e) {
                return new NewAttemptBlock();
            }
        }
    }

    public  boolean isExit(){
        return this.exitCondition;
    }
}
