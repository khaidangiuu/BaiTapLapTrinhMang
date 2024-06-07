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

public class Server {

    public static void main(String[] args) {
        final int PORT = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is running and waiting for client...");
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    System.out.println("Co 1 Client ket noi tai dia chi: " + clientSocket);

                    DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                    DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
                    //Nhận dữ liệu từ Client
                    String inputLine = in.readUTF();
                    //Xử lý dữ liệu
                    int wordCount = countWords(inputLine);
                    String reverse = reverseInputString(inputLine);
                    //Trả dữ liệu về cho Client
                    out.writeInt(wordCount);
                    out.writeUTF(reverse);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int countWords(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int count = 0;
        boolean inWord = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                if (!inWord) {
                    count++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }

        return count;
    }

    public static String reverseInputString(String s) {
        if (s == null) {
            return s;
        }
        String reverseString = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reverseString = reverseString + s.charAt(i);
        }
        return reverseString;
    }
}
