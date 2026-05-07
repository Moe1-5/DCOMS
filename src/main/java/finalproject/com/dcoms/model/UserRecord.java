package finalproject.com.dcoms.model;

import java.io.Serializable;

public class UserRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String username;
    private String password;
    private String role; 
    private String employeeId; 
    private String hrId;       

    public UserRecord(String userId, String username, String password,
                      String role, String employeeId, String hrId) {
        this.userId     = userId;
        this.username   = username;
        this.password   = password;
        this.role       = role;
        this.employeeId = employeeId;
        this.hrId       = hrId;
    }

    public String getUserId()     { return userId; }
    public String getUsername()   { return username; }
    public String getPassword()   { return password; }
    public String getRole()       { return role; }
    public String getEmployeeId() { return employeeId; }
    public String getHrId()       { return hrId; }
}