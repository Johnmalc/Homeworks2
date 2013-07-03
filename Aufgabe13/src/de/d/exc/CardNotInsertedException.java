package de.d.exc;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */

public class CardNotInsertedException extends Exception {

	public CardNotInsertedException() {
		System.out.println("");
		System.out.println("Es gibt keine Karte im Automat.");
	}

}
