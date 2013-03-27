package de.university.neueVersion.exceptions;

public class InvalidCardException extends MeineException {
	public InvalidCardException() {
		System.out.println("");
		System.out.println("Diese Karte ist keinem Konto zugeordnet. ");
	}
}
