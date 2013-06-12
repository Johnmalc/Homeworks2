package de.aufgabe.d;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */
public class WarehouseOrder implements Observer {
	/**
	 * welche bei einer Lagerbestandsveranderung pruft. Ob der
	 * Mindestlagerbestand unterschritten wurde und ggf. automatisch eine
	 * Bestell-Warnung auf die Konsole ausgibt.
	 */
	@Override
	public void update(Observable o, Object arg) {
		if (((Produkt) o).getHolding() <= ((Produkt) o).getMinHolding()) {
			System.out.println("Sie muessen bald neubestellen!!!!!!!!!!!");
		}
	}
}
