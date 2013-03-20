package de.university.reutlingen.aufgabe1;

/**
 * @author johnmalc
 * 
 */
public class Exception extends IllegalStateException {
	String fehler;

	public Exception(String fehler) {
		super(fehler);
	}

	public Exception() {

	}

}
