package de.notOurs;

import java.util.Observer;
import java.util.Observable;

public class WarehouseOrder implements Observer {
	public void update(Observable o, Object obj)

	{
		if (((Produkt) o).getLagerbestand() <= ((Produkt) o)
				.getMindestlagerbestand()) {
			System.out.println("Stock too low");
			System.out.println("Current stock -> "
					+ ((Produkt) o).getLagerbestand());
			System.out.println("Please refill!!");
		}
	}
}
