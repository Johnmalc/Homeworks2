package de.reutlingen.university.aufgabe3;

/**
 * @author Dmitry Petrov
 * @author Anastasia Baron
 * 
 *         Erstellen Sie fur die Schuharten Stiefel und Sportschuhe eigene
 *         Klassen, welche von der Klasse Shoes erben.
 *         
 * @throws NichtErlaubtesFormatException
 */
public class Stiefel extends Shoes {

	public Stiefel(String name, double schuhgroesse) throws NichtErlaubtesFormatException {
		super(name, schuhgroesse);
	}

}
