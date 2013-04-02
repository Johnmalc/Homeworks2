package de.reutlingen.university.aufgabe3;

/**
 * 
 * @author Anastasia Baron
 * @author Dmitry Petrov
 * 
 * Jedes Schuhpaar soll in einer eigenen Schachtel untergebracht werden. 
 * Um die generische Klasse Box wiederverwenden zu können soll eine neue Klasse 
 * ShoeBox erstellt werden, welche von Box erbt. Um zu verhindern, dass neben 
 * Schuhobjekten auch andere Objekte in ShoeBox abgelegt werden koennen, 
 * ist es erforderlich den generischen Platzhalter der Klasse entsprechend einzuschränken.
 * 
 *
 * @param <T>
 */

//Nur Shoes koennen abgelegt werden 
public class ShoeBox<T extends Shoes> extends Box<T> { 
	
private T pairShoe;

public ShoeBox(){
    	
    }  

    //hinzufuegen
	public void addShoes(T pairShoe){
	this.pairShoe=pairShoe;
	}
	
	//entfernen	
	public void removePairShoe()
		{
			pairShoe = null;
		}
	
	// gibt den Inhalt der Schachtel zurueck
	public String toString(){
	return "in diesem Schachtel liegen: " + pairShoe.toString();
		}
}
