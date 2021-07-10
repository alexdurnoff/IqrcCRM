package ru.durnov.ui;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import ru.durnov.building.Block;
import ru.durnov.building.Room;
import ru.durnov.dao.RoomEntity;

import java.io.File;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(ApplicationExtension.class)
class WorkPaneTest  {
    private JsonPane jsonPane;

    @Start
    private void start(Stage stage){
        this.jsonPane = new JsonPane(Collections.singleton(new Block() {
            @Override
            public Set<Room> roomSet() {
                Set<Room> roomSet = new HashSet<>();
                RoomEntity roomEntity = new RoomEntity();
                roomEntity.setRoomName("room1");
                roomSet.add(new Room(roomEntity));
                roomEntity = new RoomEntity();
                roomEntity.setRoomName("room2");
                roomSet.add(new Room(roomEntity));
                return roomSet;
            }

            @Override
            public List<File> downLoadedFiles(LocalDate start, LocalDate stop) throws JSchException, SftpException {
                return null;
            }

            @Override
            public Block withName(String name) {
                return null;
            }

            @Override
            public String name() {
                return "block1";
            }
        }));
        FlowPane flowPane = new FlowPane(jsonPane);
        Scene scene = new Scene(flowPane);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    void test1(FxRobot fxRobot){
        fxRobot.capture(this.jsonPane);
    }
}