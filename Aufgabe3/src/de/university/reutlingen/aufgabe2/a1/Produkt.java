package de.university.reutlingen.aufgabe2.a1;

public class Produkt<T> {
	private T produktBeschreibung;
	private double produktPreis;

	public Produkt(T produktBeschreibungX, double produktPreisX) {
		this.produktBeschreibung = produktBeschreibungX;
		this.produktPreis = produktPreisX;
	}

	void setProduktbeschreibung(T value) {
		this.produktBeschreibung = value;
	}

	public T getProduktBeschreibung() {
		return produktBeschreibung;
	}

	public void setProduktPreis(double value) {
		this.produktPreis = value;
	}

	public double getProduktPreis() {
		return produktPreis;
	}

}
