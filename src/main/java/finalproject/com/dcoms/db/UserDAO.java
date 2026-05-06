package finalproject.com.dcoms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public boolean createUser(String username, String hashedPassword, String role, String employeeId, String hrId) {
        String userId = generateUserId();
        if (userId == null) {
            System.out.println("UserDAO error: Failed to generate user ID");
            return false;
        }

        String sql = "INSERT INTO User (userId, username, password, role, employeeId, hrId) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, userId);
            stmt.setString(2, username);
            stmt.setString(3, hashedPassword);
            stmt.setString(4, role);

            // Only one of these should be non-null depending on role
            if (employeeId != null) {
                stmt.setString(5, employeeId);
            } else {
                stmt.setNull(5, java.sql.Types.VARCHAR);
            }

            if (hrId != null) {
                stmt.setString(6, hrId);
            } else {
                stmt.setNull(6, java.sql.Types.VARCHAR);
            }

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            System.out.println("UserDAO error: " + e.getMessage());
            return false;
        }
    }

    private String generateUserId() {
        String sql = "SELECT userId FROM User ORDER BY userId DESC FETCH FIRST 1 ROWS ONLY 1";

        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String lastId = rs.getString("userId"); // e.g. "U007"
                int num = Integer.parseInt(lastId.substring(1)); // strip "U" -> 7
                return String.format("U%03d", num + 1); // -> "U008"
            } else {
                return "U001"; // first user ever
            }

        } catch (SQLException e) {
            System.out.println("UserDAO error generating ID: " + e.getMessage());
            return null;
        }
    }

    public String[] getUserByUsername(String username) {
        String sql = "SELECT userId, username, password, role, employeeId, hrId FROM Users WHERE username = ?";

        try {
            Connection conn = dbConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new String[] {
                        rs.getString("userId"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("role"),
                        rs.getString("employeeId"), // may be null
                        rs.getString("hrId") // may be null
                };
            }

        } catch (SQLException e) {
            System.out.println("UserDAO error: " + e.getMessage());
        }

        return null;
    }

    public String[] login(String username, String password) {
        // find user by the arg username
        String[] user = getUserByUsername(username);
        // check that users password with arg password, if yes, return user string[], if
        // not, return error
        System.out.println("SERVER: stored user password is:" + user[2]);
        System.out.println("SERVER: clientside pass is:" + password);
        if (user[2].equals(password)) {

            System.out.println("DEBUG: login worked");
            return user;
        } else {
            System.out.println("DEBUG: login is wrong");
            return null;
        }

    }
}