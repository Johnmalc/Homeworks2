package de.reutlingen.university.aufgabe3;

/**
 * @author Dmitry Petrov
 * @author Anastasia Baron
 * 
 *         Schreiben Sie die abstrakte Klasse Shoes, diese dient als Basisklasse
 *         fuer Paar verschiedener Schuharten. Jedes Schuhpaarobjekt besteht aus
 *         einem Namen und einer Schuhgroesse. Es sollen auch halbe
 *         Schuhgroessen erlaubt sein
 * 
 */

public abstract class Shoes {
	State state;
	String name;
	double schuhgroesse;

	// Konstruktor
	public Shoes(String name, double schuhgroesseX){
		this.name = name;
			try {
				this.setSchuhgroesse(schuhgroesseX);
			} catch (NichtErlaubtesFormatException e) {
				e.getMessage();
			}
	}
	// Set-Methode fuer Schuhegroesse erlaubt auch die Halbgroesse.
	public void setSchuhgroesse(double schuhgroesseX) throws NichtErlaubtesFormatException{
		if (schuhgroesseX * 2 == (int)(schuhgroesseX * 2)) {
			state = State.GROESSE_OK;
			this.schuhgroesse = schuhgroesseX;
		}else { 
			throw new NichtErlaubtesFormatException();
		}
	}

	// damit Methode toString in der Klasse Box gut funktionieren koennte
	public String toString() {
		if (state == State.GROESSE_OK) {
			return name + " mit der Groesse " + schuhgroesse;
		}
		return null;
	}
}
