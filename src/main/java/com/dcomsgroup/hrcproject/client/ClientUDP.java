
package com.dcomsgroup.hrcproject.client;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class ClientUDP {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("localhost");
 
        String message = "Hello, UDP Server!";
        byte[] buffer = message.getBytes();
 
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, 1234);
        clientSocket.send(packet);  // Send message to server
 
        clientSocket.close();
    }
}