package ru.durnov.building;

import com.jcraft.jsch.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SFTPChannel {
    private final static Logger logger = LogManager.getLogger(SFTPChannel.class);
    private final String PATH_TO_SOURCE_DIRECTORY = "/home/pi/iqrclog/previousdays";
    protected String pathToDownloadDirectory = "Downloads";
    private final Session session;
    private final ChannelSftp channelSftp;
    private final Vector vector;
    private final List<File> fileList = new ArrayList<>();

    public SFTPChannel(String host, String user, String password, int port) throws JSchException, SftpException {
        this.session = new JSch().getSession(user, host, port);
        this.session.connect();
        Channel channel = session.openChannel("sftp");
        channel.connect();
        this.channelSftp = (ChannelSftp) channel;
        this.vector = channelSftp.ls(PATH_TO_SOURCE_DIRECTORY);
    }
    public List<File> fileList(LocalDate start, LocalDate stop) throws SftpException {
        Interval interval = new Interval(start, stop);
        if (interval.dateIsInsideInterval(LocalDate.now())) this.fileList.add(new CurrentDayLogFile().file());
        this.fileList.addAll(new LogFiles(channelSftp, vector, interval).fileList());
        return this.fileList;
    }
}
