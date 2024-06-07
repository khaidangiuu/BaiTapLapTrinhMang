/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import Core.XauInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Khai-Dangiuu
 */
public class XuLy extends UnicastRemoteObject implements XauInterface{

    public XuLy() throws RemoteException {
    }
    
    @Override
    public int demTu(String ch) throws RemoteException {
         return ch.split("\\s+").length;
    }

    @Override
    public String daoXau(String ch) throws RemoteException {
        return new StringBuilder(ch).reverse().toString();
    }
    
}
