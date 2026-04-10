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
    private static final String DB_URL = "jdbc:derby://localhost:1527/DCOMS";
    private static final String USERNAME = "DCOMS"; 
    private static final String PASSWORD = "DCOMS";  
    
    private static Connection connection = null;
    
    private dbConnection(){}
    
    public static Connection getConnection() {
        if(connection == null){
            try{
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                System.out.println("Successfully connected to Database");
            }catch(ClassNotFoundException e) {
                System.out.println("Derby driver is not found: "+ e.getMessage());
            }catch(SQLException e){
                System.out.println("Connection Failed :" + e.getMessage());
            }
        }
        return connection;
    }
    
    public static void closeConnection() {
        if (connection != null){
            try{
                connection.close();
                connection = null;
                System.out.println("Connection is successfully closed");
            }catch(SQLException e){
                System.out.println("Failed to close connection: " + e.getMessage());
            }
        }
    }
    
    
}
