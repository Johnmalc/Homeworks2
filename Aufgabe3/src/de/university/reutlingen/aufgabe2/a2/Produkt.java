package de.university.reutlingen.aufgabe2.a2;

public class Produkt<T> {
	private T produktBeschreibung;
	private double neuesPreis;

	public Produkt(T produktBeschreibungX, double neuesPreisX) {
		this.produktBeschreibung = produktBeschreibungX;
		this.neuesPreis = neuesPreisX;
	}

	public T getProduktBeschreibung() {
		return produktBeschreibung;
	}

	public double getProduktPreis() {
		return neuesPreis;
	}

}
