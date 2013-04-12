package de.university.reutlingen.newVersion;

import de.university.reutlingen.newVersion.ProductDescription.PriceLevel;

public class Produkt<T> {
	public T produktBeschreibung;
	public PriceLevel produktPreis; // enum

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
