package ru.durnov.auth;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import ru.durnov.building.Block;
import ru.durnov.building.Room;

import java.io.File;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class AdminCentralBlock implements Block {
    @Override
    public Set<Room> roomSet() {
        return Collections.emptySet();
    }

    @Override
    public List<File> downLoadedFiles(LocalDate start, LocalDate stop) throws JSchException, SftpException {
        return Collections.emptyList();
    }

    @Override
    public Block withName(String name) {
        return this;
    }

    @Override
    public String name() {
        return "";
    }
}
