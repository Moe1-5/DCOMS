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

    public String createEmployee(String firstName, String lastName, String icPassport) {
        String employeeId = generateEmployeeId();
        if (employeeId == null) {
            System.out.println("EmployeeDAO error: Failed to generate employee ID");
            return null;
        }

        String sql = "INSERT INTO Employee (employeeId, firstName, lastName, icPassport, leaveBalance) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, employeeId);
            stmt.setString(2, firstName);
            stmt.setString(3, lastName);
            stmt.setString(4, icPassport);
            stmt.setInt(5, 14);

            int rows = stmt.executeUpdate();
            return rows > 0 ? employeeId : null; // return the ID on success, null on fail

        } catch (SQLException e) {
            System.out.println("EmployeeDAO error: " + e.getMessage());
            return null;
        }
    }

    private String generateEmployeeId() {
        String sql = "SELECT employeeId FROM Employee ORDER BY employeeId DESC FETCH FIRST 1 ROWS ONLY";

        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String lastId = rs.getString("employeeId"); // e.g. "E007"
                int num = Integer.parseInt(lastId.substring(1)); // strip "E" -> 7
                return String.format("E%03d", num + 1); // -> "E008"
            } else {
                return "E001"; // first employee ever
            }

        } catch (SQLException e) {
            System.out.println("EmployeeDAO error generating ID: " + e.getMessage());
            return null;
        }
    }

    public String[] getEmployeeById(String employeeId) {
        String sql = "SELECT employeeId, firstName, lastName, icPassport, leaveBalance FROM Employee WHERE employeeId = ?";
        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new String[] {
                        rs.getString("employeeId"),
                        rs.getString("firstName"),
                        rs.getString("lastName"),
                        rs.getString("icPassport"),
                        String.valueOf(rs.getInt("leaveBalance"))
                };
            }
        } catch (SQLException e) {
            System.out.println("EmployeeDAO error: " + e.getMessage());
        }
        return null;
    }

    public int getLeaveBalance(String employeeId) {
        String sql = "SELECT leaveBalance FROM Employee WHERE employeeId = ?";

        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, employeeId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("leaveBalance");
            }
        } catch (SQLException e) {
            System.out.println("employee DAO: " + e.getMessage());
        }
        return -1;
    }
}
