package finalproject.com.dcoms.model;

import java.io.Serializable;

public class FamilyDetailsRecord implements Serializable {
    private static final long serialVersionUID = 1L;

    private String employeeId;
    private String spouseName;
    private int    children;

    public FamilyDetailsRecord(String employeeId, String spouseName, int children) {
        this.employeeId = employeeId;
        this.spouseName = spouseName;
        this.children   = children;
    }

    public String getEmployeeId() { return employeeId; }
    public String getSpouseName() { return spouseName; }
    public int    getChildren()   { return children; }
}