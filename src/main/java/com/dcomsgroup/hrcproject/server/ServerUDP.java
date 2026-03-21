package com.dcomsgroup.hrcproject.server;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class ServerUDP {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(1234);
        byte[] buffer = new byte[1024];
 
        System.out.println("UDP Server is running...");
 
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        serverSocket.receive(packet);  // Wait for client message
 
        String message = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Client says: " + message);
 
        serverSocket.close();
    }
}
