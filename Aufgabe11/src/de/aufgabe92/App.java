package de.aufgabe9;

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
<<<<<<< HEAD:Aufgabe11/src/de/aufgabe92/App.java
		WarehouseDisplay wd = new WarehouseDisplay();
		WarehouseOrder wo = new WarehouseOrder();
		pr.addObserver(wd);
		pr.addObserver(wo);

		pr.removeProducts(10);

=======
		System.out.println(pr.toString());
		WarehouseDisplay wd = new WarehouseDisplay();
		WarehouseOrder wo = new WarehouseOrder();

		pr.addObserver(wo);
		pr.addObserver(wd);

		pr.removeProducts(1);
		pr.removeProducts(11);
>>>>>>> aufgabe:Aufgabe11/src/de/aufgabe9/App.java
	}

}
