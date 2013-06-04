package de.notOurs2;

import java.util.Observer;
import java.util.Observable;

public class WarehouseOrder implements Observer {
	public WarehouseOrder() {
	}

	public void update(Observable o, Object obj) {
		if (((Product) o).getHolding() > ((Product) o).getMinHolding()) {
			System.out
					.println("Der Mindestlagerbestand wird unterschritten bestellen Sie bitte Neu!");
		}
	}

}