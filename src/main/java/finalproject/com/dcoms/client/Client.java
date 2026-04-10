package finalproject.com.dcoms.client;

import finalproject.com.dcoms.remote.HRMService;
import finalproject.com.dcoms.client.view.EmployeeDashboard;
import finalproject.com.dcoms.client.controller.EmployeeController;
import java.rmi.Naming;

public class Client {

    private static final String HOST = "localhost";
    private static final int PORT = 1099;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            try {
                HRMService service = lookupService(HOST, PORT);

                EmployeeDashboard employeeDashboard = new EmployeeDashboard();

                EmployeeController controller = new EmployeeController(service, employeeDashboard);

                employeeDashboard.setController(controller);
                
                controller.loadName("1");

                employeeDashboard.setVisible(true);

            } catch (Exception e) {
                System.out.println("Could not connect to server: " + e.getMessage());
            }
        });
    }

    private static HRMService lookupService(String host, int port) throws Exception {
        String url = "rmi://" + host + ":" + port + "/HRMService";
        return (HRMService) Naming.lookup(url);
    }
}