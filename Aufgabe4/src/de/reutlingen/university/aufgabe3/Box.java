package de.reutlingen.university.aufgabe3;
/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 * 
 *         Beliebige Objekte sollen in einer Schachtel aufbewahrt werden konnen.
 *         Erstellen Sie dazu eine generische Klasse Box mit Methoden zum
 *         hinzufugen und entfernen von Objekten. Auuerdem soll die Klasse Box
 *         uber eine Methode public String toString() verfuegen, welche den
 *         Inhalt der Schachtel zurueckgibt.
 * 
 * @param <T>
 */

// Beliebige Objekte koennen in einer Schachtel aufbewahrt werden.
public class Box<T> {
	private T pairShoe;
	public Box() {
	}

	// hinzufuegen
	public void addShoes(T pairShoe) {
		this.pairShoe = pairShoe;
	}

	// entfernen
	public void removePairShoe() {
		pairShoe = null;
	}

	// gibt den Inhalt der Schachtel zurueck
	public String toString() {
		return "In diesem Schachtel liegen: " + pairShoe.toString();
	}

}
