/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author charoy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	// recuperation du registre 
    	try {
    		// recuperation de registre
        	Registry r=LocateRegistry.getRegistry();
	    	
                // recuperation de la ref distante
                ISensorObservable s=(ISensorObservable) r.lookup("randomSensor1");
			
	        Client c=new Client(s);
	        
	        SensorListener stubClient = (SensorListener) UnicastRemoteObject.exportObject(c, 0);
	        
	        // enregistrement du client sur le serveur
	        s.addListener(stubClient);
	        
	        c.menu();
	     
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
