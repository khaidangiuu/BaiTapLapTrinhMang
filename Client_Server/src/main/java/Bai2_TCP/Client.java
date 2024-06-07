/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai2_TCP;

import java.net.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Khai-Dangiuu
 */
public class Client {

    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port)) {
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            DataInputStream input = new DataInputStream(socket.getInputStream());

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a decimal number: ");
            double number = scanner.nextDouble();

            // Send the number to the server
            output.writeDouble(number);

            // Receive results from the server
            String hexString = input.readUTF();
            boolean isPerfect = input.readBoolean();

            System.out.println("Hexadecimal representation: " + hexString);
            System.out.println("Is perfect number: " + isPerfect);
        } catch (UnknownHostException e) {
            System.out.println("Server not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}
