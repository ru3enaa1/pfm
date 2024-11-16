package main.java.com.pfm.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/software_financiero";
    private static final String usuario = "root";
    private static final String contrasena = "TBEv#Y8H3?M3Z5j";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, usuario, contrasena);
    }
}
