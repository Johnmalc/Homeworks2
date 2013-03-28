package de.univeristy.reutlingen.aufgabe2.a3;

import de.univeristy.reutlingen.aufgabe2.a3.ProductDescription.PriceLevel;

public class Produkt<T> {
	public T produktBeschreibung;
	public PriceLevel produktPreis;

	public Produkt(T produktBeschreibungX, PriceLevel produktPreis) {
		this.produktBeschreibung = produktBeschreibungX;
		this.produktPreis = produktPreis;
	}

	void setProduktbeschreibung(T value) {
		this.produktBeschreibung = value;
	}

	public T getProduktBeschreibung() {
		return produktBeschreibung;
	}

	public PriceLevel getProduktPreis() {
		return produktPreis;
	}

}
