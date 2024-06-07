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
public interface XauInterface extends Remote{
    public int demTu(String ch) throws RemoteException;
    public String daoXau(String ch) throws RemoteException;
    
}
