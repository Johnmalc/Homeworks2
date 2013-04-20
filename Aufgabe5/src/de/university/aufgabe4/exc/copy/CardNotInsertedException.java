package de.university.aufgabe4.exc.copy;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */

public class CardNotInsertedException extends MeineException {

	public CardNotInsertedException() {
		System.out.println("");
		System.out.println("Es gibt keine Karte im Automat.");
	}

}
