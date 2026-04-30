package finalproject.com.dcoms.client.controller;

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
        System.out.println("STAFFCONTROLLER: yea tryn to register emp: " + firstName + lastName + passportNumber
                + password + passconfirm);
    }
}
