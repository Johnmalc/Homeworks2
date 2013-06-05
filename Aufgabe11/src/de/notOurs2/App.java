package de.notOurs2;

public class App {
	public static void main(String[] args) {
		Product p1 = new Product(111, "Apfel", 2000, 250);
		WarehouseDisplay wd1 = new WarehouseDisplay();
		p1.addObserver(wd1);
		p1.removeProducts(233);

		Product p2 = new Product(112, "Ball", 500, 50);
		WarehouseDisplay wd2 = new WarehouseDisplay();
		p2.addObserver(wd2);
		p2.removeProducts(5000);
	}

}
