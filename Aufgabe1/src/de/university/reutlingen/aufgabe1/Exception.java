package de.university.reutlingen.aufgabe1;

/**
 * TODO
 * @author 
 * @author 
 */
public class Exception extends IllegalStateException {
	String fehler;

	public Exception(String fehler) {
		super(fehler);
	}

	public Exception() {

	}

}
