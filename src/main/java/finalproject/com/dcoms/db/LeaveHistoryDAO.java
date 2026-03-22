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
public class LeaveHistoryDAO {
    public boolean insertLeaveHistory(String leaveId, String status) {
        String sql = "INSERT INTO LeaveHistory (leaveId, status) VALUES (?, ?)";
        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, leaveId);
            stmt.setString(2, status);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("LeaveHistoryDAO error: " + e.getMessage());
            return false;
        }
    }

    public List<String[]> getHistoryByEmployee(String employeeId) {
        List<String[]> history = new ArrayList<>();
        String sql = "SELECT lh.leaveId, lh.status " +
                     "FROM LeaveHistory lh " +
                     "JOIN LeaveApplication la ON lh.leaveId = la.leaveId " +
                     "WHERE la.employeeId = ?";
        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                history.add(new String[]{
                    rs.getString("leaveId"),
                    rs.getString("status")
                });
            }
        } catch (SQLException e) {
            System.out.println("LeaveHistoryDAO error: " + e.getMessage());
        }
        return history;
    }
}
