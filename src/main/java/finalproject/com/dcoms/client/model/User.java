package finalproject.com.dcoms.client.model;

/**
 *
 * @author
 */
public class User {

    private String userId;
    private String username;
    private String password;
    private String role;
    private String employeeId;
    private String hrId;

    public User(String userId, String username, String password, String role,
                String employeeId, String hrId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.employeeId = employeeId;
        this.hrId = hrId;
    }

    public static User fromStringArray(String[] data) {
        if (data == null || data.length < 6) return null;

        return new User(
            data[0],
            data[1],
            data[2],
            data[3],
            data[4],
            data[5]
        );
    }

    public String[] toStringArray() {
        return new String[]{
            userId,
            username,
            password,
            role,
            employeeId,
            hrId
        };
    }

    // Getters
    public String getUserId() { return userId; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public String getEmployeeId() { return employeeId; }
    public String getHrId() { return hrId; }

    // Setters
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setRole(String role) { this.role = role; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public void setHrId(String hrId) { this.hrId = hrId; }
}