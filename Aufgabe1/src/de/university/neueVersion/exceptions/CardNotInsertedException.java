package de.university.neueVersion.exceptions;

import de.university.neueVersion.exceptions.MeineException;

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
