/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.com.dcoms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author albad
 */
public class dbConnection {

    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 1527;

    private static String getHost() {
        return System.getProperty("dcoms.db.host", DEFAULT_HOST);
    }

    private static int getPort() {
        try {
            String portStr = System.getProperty("dcoms.db.port");
            if (portStr != null && !portStr.isEmpty()) {
                return Integer.parseInt(portStr);
            }
        } catch (NumberFormatException e) {
        }
        return DEFAULT_PORT;
    }

    private static String getDbUrl() {
        return "jdbc:derby://" + getHost() + ":" + getPort() + "/DCOMS";
    }

    private static final String USERNAME = "DCOMS";
    private static final String PASSWORD = "DCOMS";

    private static Connection connection = null;

    private dbConnection() {
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                connection = DriverManager.getConnection(getDbUrl(), USERNAME, PASSWORD);
                System.out.println("Successfully connected to Database");
            } catch (ClassNotFoundException e) {
                System.out.println("Derby driver is not found: " + e.getMessage());
            } catch (SQLException e) {
                System.out.println("Connection Failed :" + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Connection is successfully closed");
            } catch (SQLException e) {
                System.out.println("Failed to close connection: " + e.getMessage());
            }
        }
    }

}
