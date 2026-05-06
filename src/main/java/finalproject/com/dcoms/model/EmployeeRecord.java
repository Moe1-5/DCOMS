package finalproject.com.dcoms.model;

import java.io.Serializable;

public class EmployeeRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    private String employeeId;
    private String firstName;
    private String lastName;
    private String icPassport;
    private int leaveBalance;

    public EmployeeRecord(String employeeId, String firstName, String lastName,
                          String icPassport, int leaveBalance) {
        this.employeeId  = employeeId;
        this.firstName   = firstName;
        this.lastName    = lastName;
        this.icPassport  = icPassport;
        this.leaveBalance = leaveBalance;
    }

    public String getEmployeeId()  { return employeeId; }
    public String getFirstName()   { return firstName; }
    public String getLastName()    { return lastName; }
    public String getIcPassport()  { return icPassport; }
    public int    getLeaveBalance(){ return leaveBalance; }
}