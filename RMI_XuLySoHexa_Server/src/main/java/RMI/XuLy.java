/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import Core.NumberInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Khai-Dangiuu
 */
public class XuLy extends UnicastRemoteObject implements NumberInterface{

    public XuLy() throws RemoteException {
    }

    @Override
    public String doiSangHex(double n) throws RemoteException {
        if (n == (long) n) {
            return Long.toHexString((long) n).toUpperCase();
        } else {
            return Double.toHexString(n).toUpperCase();
        }
    }

    @Override
    public boolean soHoanHao(int n) throws RemoteException {
        if (n < 1) return false;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum == n;
    }
    
}
