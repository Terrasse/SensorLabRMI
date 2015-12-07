/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Observer;

/**
 *
 * @author charoy
 */
public interface ISensor extends Remote {
    public double getValue() throws SensorNotActivated,RemoteException;
    public void onOff() throws RemoteException;
    public boolean getStatus() throws RemoteException;
}
