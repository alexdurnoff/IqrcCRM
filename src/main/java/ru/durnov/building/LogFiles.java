package ru.durnov.building;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LogFiles {
    private final static Logger logger = LogManager.getLogger(LogFiles.class);
    private final String PATH_TO_SOURCE_DIRECTORY = "/home/pi/iqrclog/previousdays";
    protected String pathToDownloadDirectory = "Downloads";
    private final List<File> fileList = new ArrayList<>();
    private final Vector vector;
    private final Interval interval;
    private final ChannelSftp channelSftp;
    private final ExecutorService executorService;

    public LogFiles(ChannelSftp channelSftp, Vector vector, Interval interval) {
        this.channelSftp = channelSftp;
        this.vector = vector;
        this.interval = interval;
        this.executorService = Executors.newFixedThreadPool(4);
    }

    public List<File> fileList() throws SftpException {
        for (Object object : vector) {
            if (object.getClass().equals(ChannelSftp.LsEntry.class)){
                ChannelSftp.LsEntry entry = (ChannelSftp.LsEntry) object;
                String fileName = entry.getFilename();
                if (this.interval.isLogFileName(fileName)){
                    String sourcePath = PATH_TO_SOURCE_DIRECTORY + "/" + fileName;
                    channelSftp.get(sourcePath, pathToDownloadDirectory);
                    executorService.execute(() -> {
                        new GUnzipper(fileName).unzipFile();
                    });
                    String resultFileName = pathToDownloadDirectory + "/" + fileName.substring(0, fileName.indexOf(".gz"));
                    this.fileList.add(new File(resultFileName));
                }
            }
        }
        return this.fileList;
    }
}
