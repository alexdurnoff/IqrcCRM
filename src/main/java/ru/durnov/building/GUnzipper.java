package ru.durnov.building;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.GZIPInputStream;

class GUnzipper {
    private final String fileName;


    GUnzipper(String fileName) {
        this.fileName = "Downloads/" + fileName;
    }



    void unzipFile(){
        if (!fileName.contains(".gz")) return;
        String resultFileName = fileName.substring(0, fileName.indexOf(".gz"));
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream);
             FileOutputStream fileOutputStream = new FileOutputStream(resultFileName)){
            Files.deleteIfExists(Paths.get(resultFileName));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = gzipInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer, 0, len);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
