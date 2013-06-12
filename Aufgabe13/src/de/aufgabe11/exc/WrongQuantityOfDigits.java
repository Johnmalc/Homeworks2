package de.aufgabe11.exc;

public class WrongQuantityOfDigits extends Exception {

	public WrongQuantityOfDigits() {
		System.out.println("Sie muessen nur 4 stellige Nummer eingeben");
	}

}
