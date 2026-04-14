/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.com.dcoms.client.controller;

import finalproject.com.dcoms.client.model.Employee;
import finalproject.com.dcoms.client.view.EmployeeFrame;
import finalproject.com.dcoms.remote.HRMService;
import java.rmi.RemoteException;
import javax.swing.SwingWorker;

/**
 *
 * @author zaku
 */
public class EmployeeController {

    private HRMService service;
    private EmployeeFrame employeeDashboard;

    public EmployeeController(HRMService service, EmployeeFrame employeeDashboard) {
        this.service = service;
        this.employeeDashboard = employeeDashboard;
    }

    public void loadEmployee(String employeeId) {
        // SwingWorker enables async calls to server separate from ui thread (multithreading)
        new SwingWorker<String[], Void>() {
            @Override
            protected String[] doInBackground() throws Exception {
                return service.getEmployeeById("1");
            }
            
            @Override
            protected void done() {
                try {
                    String[] employeeDetails = get();
                    Employee employee = Employee.fromStringArray(employeeDetails);
                    employeeDashboard.setEmployeeDetails(employee);
                } catch (Exception e) {
                    System.out.println("Failed to load employee: " + e.getMessage());
                }
            }
        }.execute();
    }   
}
