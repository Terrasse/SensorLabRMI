/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author charoy
 */
public interface SensorListener extends Remote {
	public void statusChanged(double value,boolean status) throws RemoteException;
}
