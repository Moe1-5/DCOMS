/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.com.dcoms.server;

import finalproject.com.dcoms.remote.HRMService;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
/**
 *
 * @author albad
 */
public class Server {
     public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("RMI registry started on port 1099...");

            HRMService service = new HRMServiceImpl();
            Naming.rebind("rmi://localhost/HRMService", service);
            System.out.println("HRMService is ready and waiting for clients...");

        } catch (Exception e) {
            System.out.println("Server error: " + e.getMessage());
        }
    }
}
