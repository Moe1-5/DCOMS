/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.com.dcoms.server;

import finalproject.com.dcoms.remote.HRMService;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.rmi.ssl.SslRMIServerSocketFactory;

/**
 *
 * @author albad
 */
public class Server {

    private static final String HOST = "localhost";
    private static final int PORT = 1099;

    public static void main(String[] args) {
        try {
            System.setProperty("javax.net.ssl.keyStore", "server.keystore");
            System.setProperty("javax.net.ssl.keyStorePassword", "password123");

            SslRMIClientSocketFactory csf = new SslRMIClientSocketFactory();
            SslRMIServerSocketFactory ssf = new SslRMIServerSocketFactory();
            
            LocateRegistry.createRegistry(PORT);
            System.out.println("RMI registry started on port "+PORT+"...");

            HRMService service = new HRMServiceImpl(csf, ssf);
            Naming.rebind("rmi://"+HOST+"/HRMService", service);
            System.out.println("HRMService is ready and waiting for clients...");

        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
