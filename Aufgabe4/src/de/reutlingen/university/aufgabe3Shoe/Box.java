package de.reutlingen.university.aufgabe3Shoe;
/**
 * 
 * @author Petrov Dmitrij, Baron Anastasia;
 * 
 *Beliebige Objekte sollen in einer Schachtel aufbewahrt 
 *werden können. Erstellen Sie dazu eine generische 
 *Klasse Box mit Methoden zum hinzufügen und entfernen 
 *von Objekten. Außerdem soll die Klasse Box über eine 
 *Methode public String toString() verfügen, welche den
 * Inhalt der Schachtel zurückgibt. 
 * 
 * @param <T>
 */
public class Box<T> { //"Beliebige Objekte sollen in einer Schachtel aufbewahrt werden können." 
 private T pairShoe;  
    public Box() {}  
	
	public void addShoes(T pairShoe){ //hinzufuegen
	this.pairShoe=pairShoe;
	}
	
	public void removePairShoe() { //entfernen
			pairShoe = null;
		}
		
	public String toString(){ // gibt den Inhalt der Schachtel zurueck
	
		return "In diesem Schachtel liegen: " + pairShoe.toString();
		}
	

	
}