/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.com.dcoms.client.model;

/**
 *
 * @author zechn
 */
public class FamilyDetails {
    private String employeeId;
    private String spouseName;
    private int children;

    public FamilyDetails(String employeeId, String spouseName, int children) {
        this.employeeId = employeeId;
        this.spouseName = spouseName;
        this.children = children;
    }

    public static FamilyDetails fromStringArray(String employeeId, String[] data) {
        if (data == null || data.length < 2) return null;
        return new FamilyDetails(
            employeeId, 
            data[0], 
            Integer.parseInt(data[1])
        );
    }

    public String[] toStringArray() {
        return new String[]{ spouseName, String.valueOf(children) };
    }

    // Getters
    public String getEmployeeId() { return employeeId; }
    public String getSpouseName() { return spouseName; }
    public int getChildren() { return children; }

    // Setters
    public void setSpouseName(String spouseName) { this.spouseName = spouseName; }
    public void setChildren(int children) { this.children = children; }
}