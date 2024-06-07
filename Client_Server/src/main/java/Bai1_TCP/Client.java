/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai1_TCP;

/**
 *
 * @author Khai-Dangiuu
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 12345;

        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT); 
                DataOutputStream out = new DataOutputStream(socket.getOutputStream()); 
                DataInputStream in = new DataInputStream(socket.getInputStream());) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Moi nhap 1 xau ky tu: ");
            String userInput = sc.nextLine();
            //Gửi dữ liệu cho Server
            out.writeUTF(userInput);
            //Nhận dữ liệu trả về từ Server
            int response = in.readInt();
            System.out.println("So tu trong xau: " + response);
            String reverse = in.readUTF();
            System.out.println("Xau dao nguoc: " + reverse);
        } catch (UnknownHostException e) {
            System.err.println("Khong tim thay dia chi: " + SERVER_ADDRESS);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + SERVER_ADDRESS);
            System.exit(1);
        }
    }
}
