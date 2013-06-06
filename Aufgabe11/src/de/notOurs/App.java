package de.notOurs;

public class App {
	public static void main(String[] args) {
		Produkt p = new Produkt(5, 2);
		WarehouseDisplay wh = new WarehouseDisplay();
		WarehouseOrder wo = new WarehouseOrder();
		p.addObserver(wo);
		p.addObserver(wh);
		p.setMindestlagerbestand(10);

		System.out.println(p.getLagerbestand());

		p.setBestandserhoehung(5);
		System.out.println(p.getLagerbestand());

		p.setBestandserhoehung(10);
		System.out.println(p.getLagerbestand());
		System.out.println(p.hasChanged());

		try {
			p.removeProducts(500);
		} catch (RuntimeException r) {
			System.out.println(r);
		}

		p.deleteObservers();
	}

}
