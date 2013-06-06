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
<<<<<<< HEAD:Aufgabe11/src/de/aufgabe92/WarehouseOrder.java
		if (((Produkt) o).minHolding >= (Integer) arg) {
			System.out.println("-= Bestell-Warnung =-");
			System.out.println("Eine Bestellung ist zu machen.");
		}

=======
		if (((Produkt) o).getHolding() < ((Produkt) o).getMinHolding()) {
			System.out.println("Sie mussen bald mehr einkaufen");
		}
>>>>>>> aufgabe:Aufgabe11/src/de/aufgabe9/WarehouseOrder.java
	}
}
