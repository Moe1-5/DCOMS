/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.com.dcoms.server;

import finalproject.com.dcoms.remote.HRMService;
import finalproject.com.dcoms.db.dbConnection;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.rmi.ssl.SslRMIServerSocketFactory;

/**
 *
 * @author albad
 */
public class Server {

    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 1099;
    private static ServerIPPromptFrame promptFrame;

    public static void main(String[] args) {
        promptFrame = new ServerIPPromptFrame();
        promptFrame.setStartCallback(new ServerIPPromptFrame.StartCallback() {
            @Override
            public void onStart(String rmiHostname, int rmiPort, String dbHost, int dbPort) {
                startServer(rmiHostname, rmiPort, dbHost, dbPort);
                promptFrame.setServerRunning(true);
            }

            @Override
            public void onCancel() {
                System.exit(0);
            }

            @Override
            public void onStop() {
                System.exit(0);
            }
        });
        promptFrame.setVisible(true);
    }

    private static void startServer(String rmiHostname, int rmiPort, String dbHost, int dbPort) {
        System.setProperty("java.rmi.server.hostname", rmiHostname);
        System.setProperty("dcoms.db.host", dbHost);
        System.setProperty("dcoms.db.port", String.valueOf(dbPort));

        try {
            System.setProperty("javax.net.ssl.keyStore", "server.keystore");
            System.setProperty("javax.net.ssl.keyStorePassword", "password123");

            SslRMIClientSocketFactory csf = new SslRMIClientSocketFactory();
            SslRMIServerSocketFactory ssf = new SslRMIServerSocketFactory();

            LocateRegistry.createRegistry(rmiPort);
            System.out.println("RMI registry started on port " + rmiPort + "...");

            HRMService service = new HRMServiceImpl(csf, ssf);
            Naming.rebind("rmi://" + rmiHostname + "/HRMService", service);
            System.out.println("HRMService is ready and waiting for clients...");

            promptFrame.setServerRunning(true);

        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
            e.printStackTrace();
            promptFrame.setServerRunning(false);
            javax.swing.JOptionPane.showMessageDialog(promptFrame,
                "Failed to start server: " + e.getMessage(),
                "Server Error",
                javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }
}