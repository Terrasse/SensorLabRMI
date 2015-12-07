package eu.telecomnancy;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
	// lancement du serveur
	// qui s'enregistre sur le rmiregistry en local
	public static void main(String args[]) {
		// Cr�er et installer un gestionnaire de s�curit�
		// System.setSecurityManager(new RMISecurityManager());
		try {
                    // creation du registre 
                    LocateRegistry.createRegistry(1099);
                    
                    // creation d'un objet serveur
                    RandomSensorObservable randomSensor = new RandomSensorObservable();

                    // génération du proxy
                    ISensorObservable stubRandomSensor = (ISensorObservable) UnicastRemoteObject.exportObject(randomSensor, 0);

                    // récupération du registre
                    Registry reg = LocateRegistry.getRegistry(1099);

                    System.out.println(stubRandomSensor.getStatus());
                    // enregistrement du stub sur rmi
                    reg.rebind("randomSensor1",stubRandomSensor);
                    System.out.println("le RandomSensor est introduit dans le RMI");
			
		} catch (Exception e) {
			System.out.println("Erreur !  RandomSensor : " + e.getMessage());
			e.printStackTrace();
		}
	}
}
