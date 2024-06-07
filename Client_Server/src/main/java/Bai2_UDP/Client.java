/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai2_UDP;

/**
 *
 * @author Khai-Dangiuu
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 1234;

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(hostname);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a decimal number: ");
            double number = scanner.nextDouble();

            // Convert the number to a byte array
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            DataOutputStream dataStream = new DataOutputStream(byteStream);
            dataStream.writeDouble(number);
            byte[] sendData = byteStream.toByteArray();

            // Send the number to the server
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
            socket.send(sendPacket);

            // Prepare to receive the result from the server
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(receivePacket);

            // Convert the received data back to UTF and boolean
            ByteArrayInputStream byteInStream = new ByteArrayInputStream(receivePacket.getData());
            DataInputStream dataInStream = new DataInputStream(byteInStream);
            String hexString = dataInStream.readUTF();
            boolean isPerfect = dataInStream.readBoolean();

            System.out.println("Hexadecimal representation: " + hexString);
            System.out.println("Is perfect number: " + isPerfect);
        } catch (UnknownHostException e) {
            System.out.println("Server not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
    
}
