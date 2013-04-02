package de.university.neueVersion.exceptions;

import de.university.neueVersion.exceptions.MeineException;

/** 
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */

public class InvalidCardException extends MeineException {
	
	public InvalidCardException() {
		System.out.println("");
		System.out.println("Diese Karte ist keinem Konto zugeordnet. ");
	}
}
