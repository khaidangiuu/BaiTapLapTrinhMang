/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Core;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Khai-Dangiuu
 */
public interface NumberInterface extends Remote{
    public int ucln(int a, int b) throws RemoteException;
    public boolean isPrime(int x) throws RemoteException;
}
