package de.reutlingen.university.aufgabe3;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */

@SuppressWarnings("serial")
public class NichtErlaubtesFormatException extends Exception {

	public NichtErlaubtesFormatException() {
		System.out.println("Schuhegroesse wurde nicht anerkannt. Es sind halbe Schuhgroessen erlaubt.");
	}

}
