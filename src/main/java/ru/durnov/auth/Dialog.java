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
    private boolean exitCondition = true;

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
        this.setResultConverter(new MyConverter());
        this.setOnCloseRequest(e -> {
            this.exitCondition = true;
        });
    }


    private class MyConverter implements javafx.util.Callback<ButtonType, Block> {
        @Override
        public Block call(ButtonType param) {
            setOnCloseRequest(e -> {
                exitCondition = false;
            });
            try {
                return new CentralBlock(
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
            } catch (JSchException | SftpException e) {
                if (userNameTextField.getText().equals("admin") && passwordField.getText().equals("1111")){
                    return new AdminCentralBlock();
                } else {
                    return new NewAttamptBlock();
                }
            }
        }
    }

    public  boolean isExit(){
        return this.exitCondition;
    }
}
