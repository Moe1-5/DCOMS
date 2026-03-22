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
public class FamilyDetailsDAO {
    public boolean insertFamilyDetails(String employeeId, String spouseName, int children) {
        String sql = "INSERT INTO FamilyDetails (employeeId, spouseName, children) VALUES (?, ?, ?)";
        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, employeeId);
            stmt.setString(2, spouseName);
            stmt.setInt(3, children);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("FamilyDetailsDAO error: " + e.getMessage());
            return false;
        }
    }

    public boolean updateFamilyDetails(String employeeId, String spouseName, int children) {
        String sql = "UPDATE FamilyDetails SET spouseName = ?, children = ? WHERE employeeId = ?";
        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, spouseName);
            stmt.setInt(2, children);
            stmt.setString(3, employeeId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("FamilyDetailsDAO error: " + e.getMessage());
            return false;
        }
    }

    public String[] getFamilyByEmployeeId(String employeeId) {
        String sql = "SELECT spouseName, children FROM FamilyDetails WHERE employeeId = ?";
        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new String[]{
                    rs.getString("spouseName"),
                    String.valueOf(rs.getInt("children"))
                };
            }
        } catch (SQLException e) {
            System.out.println("FamilyDetailsDAO error: " + e.getMessage());
        }
        return null;
    }
}
