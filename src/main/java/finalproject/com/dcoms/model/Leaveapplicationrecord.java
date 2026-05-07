package finalproject.com.dcoms.model;

import java.io.Serializable;

public class Leaveapplicationrecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private String leaveId;
    private String employeeId;
    private String leaveType;
    private String startDate;
    private String endDate;
    private String status;

    public Leaveapplicationrecord(String leaveId, String employeeId, String leaveType,
                                  String startDate, String endDate, String status) {
        this.leaveId    = leaveId;
        this.employeeId = employeeId;
        this.leaveType  = leaveType;
        this.startDate  = startDate;
        this.endDate    = endDate;
        this.status     = status;
    }

    public String getLeaveId()    { return leaveId; }
    public String getEmployeeId() { return employeeId; }
    public String getLeaveType()  { return leaveType; }
    public String getStartDate()  { return startDate; }
    public String getEndDate()    { return endDate; }
    public String getStatus()     { return status; }
}