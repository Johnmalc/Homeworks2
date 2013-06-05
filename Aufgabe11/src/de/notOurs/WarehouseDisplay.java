package de.notOurs;

import java.util.Observable;
import java.util.Observer;

public class WarehouseDisplay implements Observer {

	public WarehouseDisplay() {
	}

	public void update(Observable o, Object obj) {
		System.out.println("Stock changed to: " + obj);
		System.out.println("New Stock -> " + obj);
	}
}
