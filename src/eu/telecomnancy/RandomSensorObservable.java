/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.telecomnancy;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author charoy
 */
public class RandomSensorObservable implements ISensorObservable {

    private boolean status = false; //false = off - true = on
    double start = 50;
    double currentValue;
    double end = 100;
    private ArrayList<SensorListener> listeners;

    public RandomSensorObservable(){
    	listeners = new ArrayList<SensorListener>();
    }
    
    @Override
    public double getValue() throws SensorNotActivated {
    	System.out.println("PASSSE");
        if (status) {
            double random = new Random().nextDouble();
            currentValue = start + (random * (end - start));
            notifyListeners();
            return currentValue;
        } else {
            throw new SensorNotActivated("random Sensor not activated");
        }
    }

    @Override
    public void onOff() {
    	System.out.println("passe stats");
        status = !status;
        notifyListeners();
    }

    @Override
    public boolean getStatus() {
        return status;
    }
    
    public void addListener(SensorListener s) {
        listeners.add(s);
    }
    
    public void removeListener(SensorListener s) {
        listeners.remove(s);
    }
    
    public void notifyListeners() {
    	System.out.println("PASSSE");
        for (SensorListener sensorListener : listeners) {
        	System.out.println("PASSSEboucle");
            try {
				sensorListener.statusChanged(this.currentValue,this.status);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}
