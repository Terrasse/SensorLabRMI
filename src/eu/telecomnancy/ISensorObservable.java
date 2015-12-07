package eu.telecomnancy;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ISensorObservable extends ISensor,Remote {
    public void addListener(SensorListener s) throws RemoteException;
    public void removeListener(SensorListener s)throws RemoteException;
    public void notifyListeners()throws RemoteException;
}
