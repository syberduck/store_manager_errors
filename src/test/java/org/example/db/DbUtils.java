package org.example.db;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {

    private static Connection connection;

    private static Connection createConnection() throws SQLException, ClassNotFoundException {
        // Параметры подключения
        String host = "localhost";
        int port = 5435;
        String databaseName = "strg_users_db";
        String user = "storage_admin";
        String password = "THw7l0bxvPPkWUhP";
        // Строка подключения
        String url = "jdbc:postgresql://" + host + ":" + port + "/" + databaseName;
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, password);
    }

    @SneakyThrows
    public static Connection getConnection() {
        if(connection == null) {
            connection = createConnection();
        }
        return connection;
    }

    @SneakyThrows
    public static void closeConnection() {
        if(connection != null) {
            connection.close();
        }
    }
}
