/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.com.dcoms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author albad
 */
public class LeaveApplicationDAO {
     public boolean applyLeave(String leaveId, String employeeId, String leaveType,
                              String startDate, String endDate) {
        System.out.println("DEBUG DAO: Attempting to insert leave - ID=" + leaveId + ", Employee=" + employeeId + ", Type=" + leaveType + ", Start=" + startDate + ", End=" + endDate);
        
        try {
            Connection conn = dbConnection.getConnection();
            if (conn == null) {
                System.out.println("DEBUG DAO: Connection is null!");
                return false;
            }
            
            // Check if employee exists
            java.sql.PreparedStatement checkStmt = conn.prepareStatement("SELECT employeeId FROM Employee WHERE employeeId = ?");
            checkStmt.setString(1, employeeId);
            java.sql.ResultSet rs = checkStmt.executeQuery();
            if (!rs.next()) {
                System.out.println("DEBUG DAO: Employee " + employeeId + " does not exist in database!");
                return false;
            }
            
            // Insert leave application
            String sql = "INSERT INTO LeaveApplication (leaveId, employeeId, leaveType, startDate, endDate, status) " +
                     "VALUES (?, ?, ?, ?, ?, 'Pending')";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, leaveId);
            stmt.setString(2, employeeId);
            stmt.setString(3, leaveType);
            stmt.setString(4, startDate);
            stmt.setString(5, endDate);
            stmt.executeUpdate();
            System.out.println("DEBUG DAO: Insert successful!");
            
            // Calculate leave duration and deduct from balance
            try {
                java.time.LocalDate start = java.time.LocalDate.parse(startDate);
                java.time.LocalDate end = java.time.LocalDate.parse(endDate);
                int duration = (int) java.time.temporal.ChronoUnit.DAYS.between(start, end) + 1;
                
                // Get current balance and deduct
                PreparedStatement balStmt = conn.prepareStatement("SELECT leaveBalance FROM Employee WHERE employeeId = ?");
                balStmt.setString(1, employeeId);
                ResultSet balRs = balStmt.executeQuery();
                if (balRs.next()) {
                    int currentBalance = balRs.getInt("leaveBalance");
                    int newBalance = currentBalance - duration;
                    if (newBalance < 0) newBalance = 0;
                    
                    // Update the leave balance
                    PreparedStatement updStmt = conn.prepareStatement("UPDATE Employee SET leaveBalance = ? WHERE employeeId = ?");
                    updStmt.setInt(1, newBalance);
                    updStmt.setString(2, employeeId);
                    updStmt.executeUpdate();
                    
                    System.out.println("DEBUG DAO: Deducted " + duration + " days from leave balance. Old: " + currentBalance + ", New: " + newBalance);
                }
            } catch (Exception e) {
                System.out.println("DEBUG DAO: Error updating leave balance: " + e.getMessage());
            }
            
            return true;
        } catch (SQLException e) {
            System.out.println("LeaveApplicationDAO error: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateLeaveStatus(String leaveId, String status) {
        String sql = "UPDATE LeaveApplication SET status = ? WHERE leaveId = ?";
        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, status);
            stmt.setString(2, leaveId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("LeaveApplicationDAO error: " + e.getMessage());
            return false;
        }
    }

    public List<String[]> getLeavesByEmployee(String employeeId) {
        List<String[]> leaves = new ArrayList<>();
        String sql = "SELECT leaveId, leaveType, startDate, endDate, status " +
                     "FROM LeaveApplication WHERE employeeId = ?";
        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                leaves.add(new String[]{
                    rs.getString("leaveId"),
                    rs.getString("leaveType"),
                    rs.getString("startDate"),
                    rs.getString("endDate"),
                    rs.getString("status")
                });
            }
        } catch (SQLException e) {
            System.out.println("LeaveApplicationDAO error: " + e.getMessage());
        }
        return leaves;
    }

    public List<String[]> getLeavesByEmployeeAndYear(String employeeId, int year) {
        List<String[]> leaves = new ArrayList<>();
        String sql = "SELECT leaveId, leaveType, startDate, endDate, status " +
                     "FROM LeaveApplication " +
                     "WHERE employeeId = ? AND YEAR(startDate) = ?";
        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, employeeId);
            stmt.setInt(2, year);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                leaves.add(new String[]{
                    rs.getString("leaveId"),
                    rs.getString("leaveType"),
                    rs.getString("startDate"),
                    rs.getString("endDate"),
                    rs.getString("status")
                });
            }
        } catch (SQLException e) {
            System.out.println("LeaveApplicationDAO error: " + e.getMessage());
        }
        return leaves;
    }
}
