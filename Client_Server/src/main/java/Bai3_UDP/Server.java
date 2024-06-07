/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai3_UDP;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Khai-Dangiuu
 */
public class Server {
    private final int PORT = 1234;
    public static void main(String[] args) {
        new Server().run();
    }

    private void run() {
        try {
            DatagramSocket socket = new DatagramSocket(PORT);
            System.out.println("May chu dang chay...");
            while(true){
                byte[] buffer = new byte[1024];
                DatagramPacket rPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(rPacket);
                
                byte[] data = rPacket.getData();
                ByteArrayInputStream byteStream = new ByteArrayInputStream(data);
                DataInputStream dataStream = new DataInputStream(byteStream);
                int a = dataStream.readInt();
                int b = dataStream.readInt();
                
                int ucln = timUCLN(a, b);
                boolean snta = SNT(a);
                boolean sntb = SNT(b);
                
                //gui du lieu ve Client
                ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
                    DataOutputStream dataOutStream = new DataOutputStream(byteOutStream);
                    dataOutStream.writeInt(ucln);
                    dataOutStream.writeBoolean(snta);
                    dataOutStream.writeBoolean(sntb);

                    byte[] sendData = byteOutStream.toByteArray();
                    DatagramPacket sPacket = new DatagramPacket(sendData, sendData.length, rPacket.getAddress(), rPacket.getPort());
                    socket.send(sPacket);
            }
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
    
    //tim UCLN
    public int timUCLN(int a, int b) {
        if (b == 0) {
            return a;
        }
        return timUCLN(b, a % b);
    }

    //Kiem tra so nguyen to
    public boolean SNT(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
}
