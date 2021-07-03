package ru.durnov.building;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface Block {
    Set<Room> roomSet();
    List<File> downLoadedFiles(LocalDate start, LocalDate stop) throws JSchException, SftpException;
    boolean authorize();
}
