package ru.durnov.auth;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import ru.durnov.building.Block;
import ru.durnov.building.BuildingRoom;

import java.io.File;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class EmptyCentralBlock implements Block {
    @Override
    public Set<BuildingRoom> roomSet() {
        return Collections.emptySet();
    }

    @Override
    public List<File> downLoadedFiles(LocalDate start, LocalDate stop) throws JSchException, SftpException {
        return Collections.emptyList();
    }

    @Override
    public boolean authorize() {
        return false;
    }
}
