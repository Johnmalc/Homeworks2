package de.university.neueVersion.exceptions;

/** 
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */

public class PinNotCorectException extends MeineException {
	
	public PinNotCorectException() {
		System.out.println("");
		System.out.println("Sie haben entwerder noch keinen PIN eingegeben oder war er falsch.");
	}

}
