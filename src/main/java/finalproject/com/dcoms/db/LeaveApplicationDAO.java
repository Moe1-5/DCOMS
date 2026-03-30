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
        String sql = "INSERT INTO LeaveApplication (leaveId, employeeId, leaveType, startDate, endDate, status) " +
                     "VALUES (?, ?, ?, ?, ?, 'Pending')";
        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, leaveId);
            stmt.setString(2, employeeId);
            stmt.setString(3, leaveType);
            stmt.setString(4, startDate);
            stmt.setString(5, endDate);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("LeaveApplicationDAO error: " + e.getMessage());
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
