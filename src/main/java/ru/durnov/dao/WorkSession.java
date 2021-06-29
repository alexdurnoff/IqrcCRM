package ru.durnov.dao;

import org.hibernate.Session;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class WorkSession {
    private final String userName;
    private final String password;
    private final String hostName;
    private final int port;

    public WorkSession(String userName, String password, String hostName, int port) {
        this.userName = userName;
        this.password = password;
        this.hostName = hostName;
        this.port = port;
    }

    public Session session(){
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder
                .applySetting("hibernate.connection.datasource", this.hostName + ":" + this.port)
                .applySetting("hibernate.hbm2ddl.auto", "create-drop")
                .applySetting("hibernate.format_sql", "true")
                .applySetting("hibernate.use_sql_comments", "true")
                .applySetting("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
                .applySetting("hibernate.connection.username", this.userName)
                .applySetting("hibernate.connection.password", this.password)
                .applySetting("javax.persistence.jdbc.driver", "com.mysql.jdbc.Driver");
        return new MetadataSources(
                builder.build()
        ).buildMetadata().buildSessionFactory().openSession();
    }
}
