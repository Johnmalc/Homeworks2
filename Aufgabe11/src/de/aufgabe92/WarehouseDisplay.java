package de.aufgabe9;

import java.util.Observable;
import java.util.Observer;

/**
 * welche den aktuellen Lagerbestand eines Produktes auf der Konsole ausgibt,
 * sobald sich der Lagerbestand andert
 */
public class WarehouseDisplay implements Observer {

	@Override
	public void update(Observable o, Object arg) {
<<<<<<< HEAD:Aufgabe11/src/de/aufgabe92/WarehouseDisplay.java
		System.out.println("der aktuelle Lagerbestand ist " + arg);
=======
		System.out.println("Neues anzahl von Produkten ->" + ((Produkt) o).getHolding());
>>>>>>> aufgabe:Aufgabe11/src/de/aufgabe9/WarehouseDisplay.java
	}
}
