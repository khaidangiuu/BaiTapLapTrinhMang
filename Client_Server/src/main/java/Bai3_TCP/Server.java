/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bai3_TCP;

/**
 *
 * @author Khai-Dangiuu
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    
    private final int PORT = 12345;
    
    public static void main(String[] args) {
        new Server().run();
    }
    
    public void run() {
        try {
            ServerSocket server = new ServerSocket(PORT);
            System.out.println("May chu dangg chay...");
            while (true) {
                Socket sk = server.accept();
                DataInputStream in = new DataInputStream(sk.getInputStream());
                DataOutputStream out = new DataOutputStream(sk.getOutputStream());
                //Nhận dữ liệu
                int a = in.readInt();
                int b = in.readInt();
                //Xu lu yeu cau Client
                int ucln = timUCLN(a, b);                
                boolean SNTA = SNT(a);
                boolean SNTB = SNT(b);
                //Trả kết quả về cho Client
                out.writeInt(ucln);
                out.writeBoolean(SNTA);
                out.writeBoolean(SNTB);
                sk.close();
            }
        } catch (IOException e) {
            System.out.println("Khong the khoi chay may chu!!!");
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
