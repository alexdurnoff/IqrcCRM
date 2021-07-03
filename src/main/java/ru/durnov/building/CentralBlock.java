package ru.durnov.building;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import ru.durnov.dao.DaoService;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class CentralBlock implements Block{
    private final DaoService daoService;
    private final SSH ssh;



    public CentralBlock(DaoService daoService, SSH ssh) {
        this.daoService = daoService;
        this.ssh = ssh;
    }

    @Override
    public Set<Room> roomSet() {
        return this.daoService.roomSet();
    }

    @Override
    public List<File> downLoadedFiles(LocalDate start, LocalDate stop) throws JSchException, SftpException {
        return this.ssh.downloadedFiles(start, stop);
    }

    @Override
    public boolean authorize() {
        return (this.ssh.authorize());
    }
}
