/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Khai-Dangiuu
 */
public class Server {
    private final int PORT = 3210;
    public static void main(String[] args) {
        new Server().run();
    }

    private void run() {
        try{
            Registry reg = LocateRegistry.createRegistry(PORT);
            reg.rebind("NumberService", new NumberClass());
            System.out.println("May chu dang chay...");
        } catch (RemoteException e){
            System.out.println("Khong the khoi chay may chu");
        }
    }
    
}
