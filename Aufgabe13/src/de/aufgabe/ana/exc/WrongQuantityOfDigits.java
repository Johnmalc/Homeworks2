package de.aufgabe.ana.exc;

public class WrongQuantityOfDigits extends Exception {

	public WrongQuantityOfDigits() {
		System.out.println("Sie muessen nur 4 stellige Nummer eingeben");
	}

}
