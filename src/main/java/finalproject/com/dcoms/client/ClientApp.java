package finalproject.com.dcoms.client;

import finalproject.com.dcoms.client.model.User;
import finalproject.com.dcoms.client.controller.EmployeeController;
import finalproject.com.dcoms.client.controller.LoginController;
import finalproject.com.dcoms.client.view.EmployeeDashboard;
import finalproject.com.dcoms.client.view.EmployeeFrame;
import finalproject.com.dcoms.client.view.HRFrame;
import finalproject.com.dcoms.client.view.LoginFrame;
import finalproject.com.dcoms.remote.HRMService;

public class ClientApp {
    private HRMService service;
    private LoginController loginController;
    private EmployeeController employeeController;
    private LoginFrame loginFrame;

    public ClientApp(HRMService service) {
        this.service = service;
        // this.loginController = loginController;
    }

    public void showLogin() {
        LoginFrame loginFrame = new LoginFrame();
        this.loginFrame = loginFrame;
        loginFrame.setController(loginController);
        loginFrame.setVisible(true);
    }

    public void showEmployeeDashboard(User user) {
        System.out.println("DEBUG CLIENT: ognna show employee dashboard!");
        EmployeeFrame employeeDashboard = new EmployeeFrame();
        employeeDashboard.setController(employeeController);
        employeeController.setDashboard(employeeDashboard);
        employeeDashboard.setVisible(true);
        employeeController.loadEmployee(user.getEmployeeId());
        loginFrame.dispose();
    }

    public void showStaffDashboard() {
        System.out.println("DEBUGCLIENT trying to show staff board...");
        HRFrame hrFrame = new HRFrame();
        
    }

    public void setController(LoginController loginController) {
        this.loginController = loginController;
    }

    public void setController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}
