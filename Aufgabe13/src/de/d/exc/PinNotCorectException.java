package de.d.exc;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */

public class PinNotCorectException extends Exception {

	public PinNotCorectException() {
		System.out.println("");
		System.out.println("Sie haben falsches PIN eingeben.");
	}
}
