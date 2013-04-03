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
	public Shoes(String name, double schuhgroesse) {
		this.name = name;
			this.setSchuhgroesse(schuhgroesse);
	}
	// Set-Methode fuer Schuhegroesse erlaubt auch die Halbgroesse.
	public void setSchuhgroesse(double schuhgroesse){
		if (schuhgroesse * 2 == (int) (schuhgroesse * 2)) {
			state = State.GROESSE_OK;
			this.schuhgroesse = schuhgroesse;
		}else { // TODO
			System.out.println("Fehler entstanden.");
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
