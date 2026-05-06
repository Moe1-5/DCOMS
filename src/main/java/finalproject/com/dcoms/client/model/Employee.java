/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.com.dcoms.client.model;

/**
 *
 * @author zechn
 */
public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String icPassport;
    private int leaveBalance;

    public Employee(String employeeId, String firstName, String lastName, String icPassport, int leaveBalance) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.icPassport = icPassport;
        this.leaveBalance = leaveBalance;
    }

    public static Employee fromStringArray(String[] data) {
        if (data == null || data.length < 5) return null;
        return new Employee(
            data[0], 
            data[1], 
            data[2], 
            data[3], 
            Integer.parseInt(data[4])
        );
    }

    public String[] toStringArray() {
        return new String[]{
            employeeId, firstName, lastName, icPassport, String.valueOf(leaveBalance)
        };
    }

    // Getters
    public String getEmployeeId() { return employeeId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getIcPassport() { return icPassport; }
    public int getLeaveBalance() { return leaveBalance; }

    // Setters
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setIcPassport(String icPassport) { this.icPassport = icPassport; }
    public void setLeaveBalance(int leaveBalance) { this.leaveBalance = leaveBalance; }
}