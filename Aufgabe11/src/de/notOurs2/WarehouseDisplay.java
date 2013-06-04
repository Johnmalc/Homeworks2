package de.notOurs2;

import java.util.Observer;
import java.util.Observable;

public class WarehouseDisplay implements Observer {

	@Override
	public void update(Observable o, Object obj) {
		System.out.println("Name des Produktes: " + ((Product) o).getpDescr());
		System.out.println("Neuer Lagerbestand: " + ((Product) o).getHolding());
	}

}
