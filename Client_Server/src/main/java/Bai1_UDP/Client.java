/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai1_UDP;

/**
 *
 * @author Khai-Dangiuu
 */
import java.net.*;
import java.io.*;

public class Client {

    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 7;
                try {
            DatagramSocket socket = socket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName(SERVER_ADDRESS);

            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                System.out.print("Moi nhap 1 xau ky tu: ");
                String userInput = stdIn.readLine();
                if (userInput == null || userInput.equals("exit")) {
                    break;
                }
                //Gửi dữ liệu cho Server
                byte[] sendData = userInput.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, SERVER_PORT);
                socket.send(sendPacket);
                //Nhận kết quả từ Server
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("So tu trong xau: " + response);
                socket.receive(receivePacket);
                String reverse = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Xau dao nguoc: " + reverse);
                
                socket.close();
            }
        } catch (UnknownHostException e) {
            System.err.println("Khong tim thay dia chi: " + SERVER_ADDRESS);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Khomg the ket noi voi dia chi: " + SERVER_ADDRESS);
            System.exit(1);
        } 
    }

}
