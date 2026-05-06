package finalproject.com.dcoms.client.controller;

import java.rmi.RemoteException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import finalproject.com.dcoms.client.view.HRFrame;
import finalproject.com.dcoms.remote.HRMService;

public class StaffController {
    private HRMService service;
    private HRFrame HRDashboard;

    public StaffController(HRMService service) {
        this.service = service;
    }

    public void registerEmp(String firstName, String lastName, String passportNumber, String username,
            String password, String passconfirm) {

        new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                return service.registerEmp(firstName, lastName, passportNumber, username, password, passconfirm);
            }

            @Override
            protected void done() {
                try {
                    boolean success = get();
                    if (success) {
                        JOptionPane.showMessageDialog(null, "Employee registered successfully!");
                        // e.g. staffDashboard.clearForm(); or navigate away
                    } else {
                        JOptionPane.showMessageDialog(null, "Registration failed. Please try again.");
                    }
                } catch (Exception e) {
                    System.out.println("Failed to register employee: " + e.getMessage());
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
            }
        }.execute();
    }
}
