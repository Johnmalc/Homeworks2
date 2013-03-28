package de.university.reutlingen.aufgabe2;

public class Produkt<T> {
	private T produktBeschreibung;
	private double produktPreis;

	public Produkt(T ProduktbeschreibungX, double ProduktpreisX) {
		this.produktBeschreibung = ProduktbeschreibungX;
		this.produktPreis = ProduktpreisX;
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
