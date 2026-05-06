/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.com.dcoms.client.controller;

import finalproject.com.dcoms.client.model.Employee;
import finalproject.com.dcoms.client.view.EmployeeFrame;
import finalproject.com.dcoms.remote.HRMService;
import java.rmi.RemoteException;
import java.util.List;
import javax.swing.SwingWorker;

public class EmployeeController {

    private HRMService service;
    private EmployeeFrame employeeFrame;

    public EmployeeController(HRMService service) {
        this.service = service;
    }

    public void setEmployeeFrame(EmployeeFrame employeeFrame) {
        this.employeeFrame = employeeFrame;
    }

    public void loadEmployee(String employeeId) {
        new SwingWorker<String[], Void>() {
            @Override
            protected String[] doInBackground() throws Exception {
                return service.getEmployeeById(employeeId);
            }

            @Override
            protected void done() {
                try {
                    String[] employeeDetails = get();
                    Employee employee = Employee.fromStringArray(employeeDetails);
                    employeeFrame.setDashboardDetails(employee);
                } catch (Exception e) {
                    System.out.println("Failed to load employee: " + e.getMessage());
                }
            }
        }.execute();
    }

    public void loadFamilyDetails(String employeeId) {
        new SwingWorker<String[], Void>() {
            @Override
            protected String[] doInBackground() throws Exception {
                return service.getFamilyByEmployeeId(employeeId);
            }

            @Override
            protected void done() {
                try {
                    String[] familyDetails = get();
                    employeeFrame.setPersonalDetails(familyDetails);
                } catch (Exception e) {
                    System.out.println("Failed to load family details: " + e.getMessage());
                }
            }
        }.execute();
    }

    public void loadLeaveHistory(String employeeId) {
        new SwingWorker<List<String[]>, Void>() {
            @Override
            protected List<String[]> doInBackground() throws Exception {
                return service.getLeavesByEmployee(employeeId);
            }

            @Override
            protected void done() {
                try {
                    List<String[]> history = get();
                    employeeFrame.setLeaveHistory(history);
                } catch (Exception e) {
                    System.out.println("Failed to load leave history: " + e.getMessage());
                }
            }
        }.execute();
    }

    public void applyLeave(String leaveId, String employeeId, String leaveType, String startDate, String endDate) {
        new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                return service.applyLeave(leaveId, employeeId, leaveType, startDate, endDate);
            }

            @Override
            protected void done() {
                try {
                    boolean success = get();
                    if (success) {
                        System.out.println("Leave application submitted successfully");
                        employeeFrame.onLeaveApplied();
                    } else {
                        System.out.println("Failed to submit leave application - check date format (use DD-MM-YYYY) and leave type values");
                    }
                } catch (Exception e) {
                    System.out.println("Failed to apply leave: " + e.getMessage());
                }
            }
        }.execute();
    }

    public void updateEmployeeDetails(String employeeId, String firstName, String lastName, String icPassport, String spouseName, int children) {
        new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                boolean employeeUpdated = service.updateEmployeeById(employeeId, firstName, lastName, icPassport);
                boolean familyUpdated = service.updateFamilyDetails(employeeId, spouseName, children);
                return employeeUpdated && familyUpdated;
            }

            @Override
            protected void done() {
                try {
                    boolean success = get();
                    if (success) {
                        System.out.println("Employee details updated successfully");
                        employeeFrame.onEmployeeDetailsUpdated();
                    } else {
                        System.out.println("Failed to update employee details");
                    }
                } catch (Exception e) {
                    System.out.println("Failed to update employee details: " + e.getMessage());
                }
            }
        }.execute();
    }
}
