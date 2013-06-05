package de.aufgabe9;

import java.util.Observable;
import java.util.Observer;

public class WarehouseOrder implements Observer {
	/**
	 * welche bei einer Lagerbestandsveranderung pruft. Ob der
	 * Mindestlagerbestand unterschritten wurde und ggf. automatisch eine
	 * Bestell-Warnung auf die Konsole ausgibt.
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (((Produkt) o).minHolding >= (Integer) arg) {
			System.out.println("-= Bestell-Warnung =-");
			System.out.println("Eine Bestellung ist zu machen.");
		}

	}

}
