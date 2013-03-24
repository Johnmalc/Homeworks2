/**
 * 
 */
package de.university.reutlingen.aufgabe1.exceptions;

/**
 * @author johnmalc
 * @anastasiastudent
 * 
 */
public class KeineKarte extends Exception {

	public KeineKarte() {
		System.out.println("");
		System.out.println("Sie haben KEINE Karte im Automat");
	}

}
