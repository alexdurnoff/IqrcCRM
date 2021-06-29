package ru.durnov.auth;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

class PrevisionSession {
    private final Properties properties;
    private final Path path = Path.of("prevision_session.txt");

    PrevisionSession(){
        this.properties = new Properties();
        try {
            this.properties.load(Files.newInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String userName(){
        String userName = this.properties.getProperty("userName");
        if (userName == null) return "";
        return userName;
    }

    String password(){
        String password = this.properties.getProperty("password");
        if (password == null) return "";
        return password;
    }
    String ip(){
        String ip = this.properties.getProperty("ip");
        if (ip == null) return "";
        return ip;
    }

    void save(String user, String passwd, String ipAddress) throws IOException {
        this.properties.setProperty("userName", user);
        this.properties.setProperty("password", passwd);
        this.properties.setProperty("ip", ipAddress);
        this.properties.store(Files.newOutputStream(path), "");
    }


}
