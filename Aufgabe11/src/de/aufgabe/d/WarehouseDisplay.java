package de.aufgabe.d;

import java.util.Observable;
import java.util.Observer;
/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */
/**
 * welche den aktuellen Lagerbestand eines Produktes auf der Konsole ausgibt,
 * sobald sich der Lagerbestand andert
 */
public class WarehouseDisplay implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Neues anzahl von Produkten -> "
				+ ((Produkt) o).getHolding());
	}
}
