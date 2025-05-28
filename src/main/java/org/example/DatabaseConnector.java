package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    public static final String DB_URL = "jdbc:sqlite:find_me_a_coffee.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL);
            System.out.println("Conexão com SQLite estabelecida.");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
        return conn;
    }
}
