package de.aufgabe9;

import java.util.Observable;
import java.util.Observer;

public class WarehouseDisplay implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("der aktuelle Lagerbestand ist " + arg);
	}
	/**
	 * welche den aktuellen Lagerbestand eines Produktes auf der Konsole
	 * ausgibt, sobald sich der Lagerbestand andert
	 */

}
