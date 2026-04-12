/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.com.dcoms.client.model;

/**
 *
 * @author zechn
 */
public class LeaveApplication {
    private String leaveId;
    private String employeeId;
    private String leaveType;
    private String startDate;
    private String endDate;
    private String status;

    public LeaveApplication(String leaveId, String employeeId, String leaveType, String startDate, String endDate, String status) {
        this.leaveId = leaveId;
        this.employeeId = employeeId;
        this.leaveType = leaveType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public static LeaveApplication fromStringArray(String employeeId, String[] data) {
        if (data == null || data.length < 5) return null;
        return new LeaveApplication(
            data[0], // leaveId
            employeeId,
            data[1], // leaveType
            data[2], // startDate
            data[3], // endDate
            data[4]  // status
        );
    }

    public String[] toStringArray() {
        return new String[]{ leaveId, leaveType, startDate, endDate, status };
    }

    // Getters
    public String getLeaveId() { return leaveId; }
    public String getEmployeeId() { return employeeId; }
    public String getLeaveType() { return leaveType; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public String getStatus() { return status; }

    // Setters
    public void setLeaveType(String leaveType) { this.leaveType = leaveType; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
    public void setStatus(String status) { this.status = status; }
}