package de.aufgabe.ana;

public class App {

	/**
	 * beispielhaft ein Produkt erzeugt, jeweils ein Objekt der beiden
	 * Observer-Klassen beim Produkt registriert und dann den Lagerbestand so
	 * verringert, dass beide Observer aktiv werden mussen. Im Falle, dass zu
	 * wenig Lagerbestand vorhanden ist soll eine RuntimeException geworfen
	 * werden.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Produkt pr = new Produkt(12654, "Produkt Nr1", 15, 5);
		WarehouseDisplay wd = new WarehouseDisplay();
		WarehouseOrder wo = new WarehouseOrder();
		pr.addObserver(wd);
		pr.addObserver(wo);

		pr.removeProducts(10);

	}

}
