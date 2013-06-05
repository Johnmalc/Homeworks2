package de.notOurs;

import java.util.Observable;

public class Produkt extends Observable {

	private int Produktnummer;
	private String Produktbeschreibung;
	private int Lagerbestand;
	private int Mindestlagerbestand;

	public Produkt(int Lagerbestand, int Mindestlagerbestand) {
		this.Lagerbestand = Lagerbestand;
		this.Mindestlagerbestand = Mindestlagerbestand;
	}

	public void setProduktnummer(int Produktnummer) {
		this.Produktnummer = Produktnummer;
	}

	public void setProduktbeschreibung(String Produktbeschreibung) {
		this.Produktbeschreibung = Produktbeschreibung;
	}

	public void setLagerbestand(int Lagerbestand) {
		this.Lagerbestand = Lagerbestand;
	}

	public void setMindestlagerbestand(int Mindestlagerbestand) {
		this.Mindestlagerbestand = Mindestlagerbestand;
	}

	public int getProduktnummer() {
		return Produktnummer;
	}

	public String getProduktbeschreibung() {
		return Produktbeschreibung;
	}

	public int getLagerbestand() {
		return Lagerbestand;
	}

	public int getMindestlagerbestand() {
		return Mindestlagerbestand;
	}

	public void removeProducts(int amount) throws RuntimeException {
		if (Lagerbestand <= 0)
			throw new RuntimeException("Lagerbestand darf nicht negativ sein");
		Lagerbestand = Lagerbestand - amount;
		setChanged(); // Signal fur Beobachter
		notifyObservers(Lagerbestand);
	}

	public void setBestandserhoehung(int amount) {
		Lagerbestand = Lagerbestand + amount;
		setChanged(); // Signal fuer Observer
		notifyObservers(Lagerbestand);

	}

}
