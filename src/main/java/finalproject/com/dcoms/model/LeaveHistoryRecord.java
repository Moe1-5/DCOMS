package finalproject.com.dcoms.model;

import java.io.Serializable;

public class LeaveHistoryRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private String leaveId;
    private String status;

    public LeaveHistoryRecord(String leaveId, String status) {
        this.leaveId = leaveId;
        this.status  = status;
    }

    public String getLeaveId() { return leaveId; }
    public String getStatus()  { return status; }
}