/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.com.dcoms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author albad
 */
public class EmployeeDAO {
    
    public String[] getEmployeeById(String employeeId) {
        String sql = "SELECT employeeId, firstName, lastName, icPassport, leaveBalance FROM Employee WHERE employeeId = ?";
       try{
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return new String[]{
                    rs.getString("employeeId"),
                    rs.getString("firstName"),
                    rs.getString("lastName"),
                    rs.getString("icPassport"),
                    String.valueOf(rs.getInt("leaveBalance"))
                };
            }
        }catch(SQLException e){
            System.out.println("EmployeeDAO error: " + e.getMessage());
        }
        return null;
    }
    
    public int getLeaveBalance(String employeeId){
        String sql = "SELECT leaveBalance FROM Employee WHERE employeeId = ?";
        
        try{
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,employeeId);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                  return rs.getInt("leaveBalance");
            }
        }catch(SQLException e){
            System.out.println("employee DAO: " + e.getMessage());
        }
        return -1;
    }

    public boolean updateEmployeeById(String employeeId, String firstName, String lastName, String icPassport) {
        String sql = "UPDATE Employee SET firstName = ?, lastName = ?, icPassport = ? WHERE employeeId = ?";
        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, icPassport);
            stmt.setString(4, employeeId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("EmployeeDAO error: " + e.getMessage());
            return false;
        }
    }
}
