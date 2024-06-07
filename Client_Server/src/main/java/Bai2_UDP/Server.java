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

public class Server {

    private final int PORT = 1234;

    public static void main(String[] args) {
        new Server().run();
    }

    private void run() {
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            System.out.println("May chu dang chay...");
            while (true) {
                try {
                    byte[] buffer = new byte[1024];
                    DatagramPacket rPacket = new DatagramPacket(buffer, buffer.length);
                    socket.receive(rPacket);
                    byte[] data = rPacket.getData();

                    ByteArrayInputStream byteStream = new ByteArrayInputStream(data);
                    DataInputStream dataStream = new DataInputStream(byteStream);
                    double number = dataStream.readDouble();
                    //Xu ly du lieu
                    String hexString = toHexadecimal(number);
                    boolean isPerfect = isPerfectNumber((int) number);

                    //Gui du lieu ve client
                    ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
                    DataOutputStream dataOutStream = new DataOutputStream(byteOutStream);
                    dataOutStream.writeUTF(hexString);
                    dataOutStream.writeBoolean(isPerfect);

                    byte[] sendData = byteOutStream.toByteArray();
                    DatagramPacket sPacket = new DatagramPacket(sendData, sendData.length, rPacket.getAddress(), rPacket.getPort());
                    socket.send(sPacket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
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
        if (number < 1) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }
}
