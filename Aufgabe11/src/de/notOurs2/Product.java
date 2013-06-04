package de.notOurs2;

import java.util.Observable;
import java.util.Observer;

public class Product extends Observable {

	// =======================Attribute========================
	Observer wacheWD;
	private int pNr;
	private String pDescr;
	private int holding;
	private int minHolding;

	// =======================Konstruktor=======================
	public Product(int pNr, String pDescr, int holding, int minHolding) {
		super();
		this.pNr = pNr;
		this.pDescr = pDescr;
		this.holding = holding;
		this.minHolding = minHolding;
	}

	// =======================Getter- & Settermethoden=======================

	public int getpNr() {
		return pNr;
	}

	public void setpNr(int pNr) {
		this.pNr = pNr;
	}

	public String getpDescr() {
		return pDescr;
	}

	public void setpDescr(String pDescr) {
		this.pDescr = pDescr;
	}

	public int getHolding() {
		return holding;
	}

	public void setHolding(int holding) {
		this.holding = holding;
	}

	public int getMinHolding() {
		return minHolding;
	}

	public void setMinHolding(int minHolding) {
		this.minHolding = minHolding;
	}

	public Observer getWacheWD() {
		return wacheWD;
	}

	public void setWacheWD(Observer wacheWD) {
		this.wacheWD = wacheWD;
	}

	// ========================weitere Methoden=======================

	public void removeProducts(int amount) {
		if (holding >= amount) {
			holding -= amount;
			setChanged();
			notifyObservers(holding);
		}

		else {
			throw new RuntimeException(
					"Sie d�rfen nicht mehr Abbuchen als im Lager vorhanden ist. Bestellen Sie bitte zuerst neu!!!");
		}
	}
}
