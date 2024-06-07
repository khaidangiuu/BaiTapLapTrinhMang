/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai1_UDP;

/**
 *
 * @author Khai-Dangiuu
 */
import java.io.*;
import java.net.*;
public class Server {
    private final int PORT = 7;
    public static void main(String[] args){
        new Server().run();
    }
    public void run(){
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            System.out.println("May chu dang chay...");
            while (true) {
                byte[] buffer = new byte[1024]; //65507
                DatagramPacket rPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(rPacket);

                InetAddress host = rPacket.getAddress();
                int port = rPacket.getPort();
                String inputLine = new String(rPacket.getData(), 0, rPacket.getLength());
                System.out.println("Nhan duoc tu Client: " + inputLine);

                int wordCount = countWords(inputLine);
                String reverse = reverseInputString(inputLine);

                byte[] sendDataWordCount = String.valueOf(wordCount).getBytes();
                DatagramPacket sendPacketWordCount = new DatagramPacket(sendDataWordCount, sendDataWordCount.length, host, port);
                socket.send(sendPacketWordCount);

                byte[] sendDataReverse = reverse.getBytes();
                DatagramPacket sPacketReverse = new DatagramPacket(sendDataReverse, sendDataReverse.length, host, port);
                socket.send(sPacketReverse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private static int countWords(String input) {
        // Implement your word count logic here
        return input.split("\\s+").length;
    }

    private static String reverseInputString(String input) {
        // Implement your string reverse logic here
        return new StringBuilder(input).reverse().toString();
    }
    
}
