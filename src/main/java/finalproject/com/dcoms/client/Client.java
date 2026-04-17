package finalproject.com.dcoms.client;

import finalproject.com.dcoms.remote.HRMService;
import finalproject.com.dcoms.client.view.EmployeeFrame;
import finalproject.com.dcoms.client.view.LoginFrame;
import finalproject.com.dcoms.client.controller.EmployeeController;
import finalproject.com.dcoms.client.controller.LoginController;

import java.rmi.Naming;

import javax.security.auth.login.LoginContext;

public class Client {

    private static final String HOST = "localhost";
    private static final int PORT = 1099;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                System.setProperty("javax.net.ssl.trustStore", "client.truststore");
                System.setProperty("javax.net.ssl.trustStorePassword", "password123");

                String url = "rmi://" + HOST + ":" + PORT + "/HRMService";
                HRMService service = (HRMService) Naming.lookup(url);

                // EmployeeFrame employeeDashboard = new EmployeeFrame();
                // EmployeeController controller = new EmployeeController(service,
                // employeeDashboard);
                // employeeDashboard.setController(controller);
                // controller.loadEmployee("1");

                // employeeDashboard.setVisible(true);

                // TESTING LOGIN
                ClientApp app = new ClientApp(service);
                LoginController loginController = new LoginController(service, app);
                EmployeeController employeeController = new EmployeeController(service);
                app.setController(loginController);
                app.setController(employeeController);
                app.showLogin();

                // LoginFrame loginFrame = new LoginFrame();
                // loginFrame.setController(loginController);
                // loginFrame.setVisible(true);

            } catch (Exception e) {
                System.out.println("Could not connect to server: " + e.getMessage());
            }
        });
    }
}
