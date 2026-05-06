package finalproject.com.dcoms.client;

import finalproject.com.dcoms.remote.HRMService;
import finalproject.com.dcoms.client.view.EmployeeFrame;
import finalproject.com.dcoms.client.view.LoginFrame;
import finalproject.com.dcoms.client.view.ClientIPPromptFrame;
import finalproject.com.dcoms.client.controller.EmployeeController;
import finalproject.com.dcoms.client.controller.LoginController;

import javax.security.auth.login.LoginContext;

public class Client {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            System.setProperty("javax.net.ssl.trustStore", "client.truststore");
            System.setProperty("javax.net.ssl.trustStorePassword", "password123");

            ClientIPPromptFrame promptFrame = new ClientIPPromptFrame();
            promptFrame.setConnectCallback(new ClientIPPromptFrame.ConnectCallback() {
                @Override
                public void onConnectSuccess(HRMService service) {
                    ClientApp app = new ClientApp(service);
                    LoginController loginController = new LoginController(service, app);
                    EmployeeController employeeController = new EmployeeController(service);
                    app.setController(loginController);
                    app.setController(employeeController);
                    app.showLogin();
                }

                @Override
                public void onConnectFailure(String error) {
                    javax.swing.JOptionPane.showMessageDialog(null,
                        "Could not connect to server: " + error,
                        "Connection Error",
                        javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            });
            promptFrame.setVisible(true);
        });
    }
}