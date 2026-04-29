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
                return service.getHistoryByEmployee(employeeId);
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
}
