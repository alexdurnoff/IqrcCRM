package ru.durnov.building;

import com.jcraft.jsch.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

public class SSH {
    private final String host;
    private final int port;
    private final String user;
    private final String password;
    private final SFTPChannel channel;

    public SSH(String host, int port, String user, String password) throws JSchException, SftpException {
        this.host = host;
        this.port = port;
        this.user = user;
        this.password = password;
        this.channel = new SFTPChannel(this.host, this.user, this.password, this.port);
    }

    SSH withPort(int port) throws JSchException, SftpException {
        return new SSH(this.host, port, this.user, this.password);
    }

    SSH withUser(String user) throws JSchException, SftpException {
        return new SSH(this.host, this.port, user, this.password);
    }

    SSH withPassword(String password) throws JSchException, SftpException {
        return new SSH(this.host, this.port, this.user, password);
    }

    List<File> downloadedFiles(LocalDate start, LocalDate stop) throws JSchException, SftpException {
        return this.channel.fileList(start, stop);
    }

    public boolean authorize() {
        return false;
    }
}
