/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.Remote;
/**
 *
 * @author charoy
 */
public class Client implements SensorListener {
    ISensor sense;
    Scanner c=new Scanner(System.in);
    public Client(ISensorObservable sensor) {
        sense=sensor;
    }
    
    public void menu() throws RemoteException{
        String rep="";
        while (!"q".equals(rep)) {
            try {
                rep= c.nextLine();
                switch (rep) {
                    case "o": {
                        sense.onOff();
                        break;
                    }
                    case "s": {
                        System.out.println("status :"+sense.getStatus());
                        break;
                    }
                    case "v": {
                        System.out.println("value :"+sense.getValue());
                        break;
                    }
                    default : System.out.println("q: quitter - o: switch - s: status - v: value");
                }
            } catch (SensorNotActivated | RemoteException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

	@Override
	public void statusChanged(double value, boolean status) {
		System.out.println("value :"+ value);
		System.out.println("status :"+ status);
	}
    
}
