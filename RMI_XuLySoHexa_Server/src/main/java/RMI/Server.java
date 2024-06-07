/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Khai-Dangiuu
 */
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    private final int PORT = 12345;
    public static void main(String[] args) {
        new Server().run();
    }

    private void run() {
        try {
            Registry reg = LocateRegistry.createRegistry(PORT);
            reg.rebind("KhaiDangiuu", new XuLy());
            System.out.println("May chu dang chay...");
        } catch (RemoteException ex) {
            System.out.println("Khong the khoi tao may chu!!!");
        }
    } 
}
