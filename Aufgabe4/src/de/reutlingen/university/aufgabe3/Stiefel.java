package de.reutlingen.university.aufgabe3;

/**
 *  
 * @author Dmitry Petrov
 * @author Anastasia Baron
 *
 * 
 * Erstellen Sie f�r die Schuharten Stiefel und Sportschuhe eigene Klassen, 
 * welche von der Klasse Shoes erben.
 *  
 *
 */
public class Stiefel extends Shoes {

	Stiefel(String name, double schuhgroesse) throws NichtErlaubtesFormatException {
		super(name, schuhgroesse);
	}

}
