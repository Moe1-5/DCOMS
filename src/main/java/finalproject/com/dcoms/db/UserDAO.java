package finalproject.com.dcoms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

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