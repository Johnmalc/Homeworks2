package de.aufgabe11.exc;

/** 
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */

public class InvalidCardException extends Exception {
	
	public InvalidCardException() {
		System.out.println("");
		System.out.println("Diese Karte ist keinem Konto zugeordnet. ");
	}
}
