/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai2_TCP;

/**
 *
 * @author Khai-Dangiuu
 */
import java.net.*;
import java.io.*;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is listening on port 12345");
            
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Co 1 Client ket noi tai dia chi: " + socket);

                    DataInputStream input = new DataInputStream(socket.getInputStream());
                    DataOutputStream output = new DataOutputStream(socket.getOutputStream());

                    double number = input.readDouble();
                    System.out.println("Received number: " + number);

                    // Convert to hexadecimal
                    String hexString = toHexadecimal(number);
                    // Check if the number is perfect
                    boolean isPerfect = isPerfectNumber((int) number);

                    output.writeUTF(hexString);
                    output.writeBoolean(isPerfect);

                    System.out.println("Sent results to client");
                } catch (IOException e) {
                    System.out.println("Error in client communication: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private static String toHexadecimal(double number) {
        if (number == (long) number) {
            return Long.toHexString((long) number).toUpperCase();
        } else {
            return Double.toHexString(number).toUpperCase();
        }
    }

    private static boolean isPerfectNumber(int number) {
        if (number < 1) return false;
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
}