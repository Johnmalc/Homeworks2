package de.reutlingen.university.aufgabe3Shoe;

/**
 * Jedes Schuhpaar soll in einer eigenen Schachtel untergebracht werden. 
 * Um die generische Klasse Box wiederverwenden zu können soll eine neue Klasse 
 * ShoeBox erstellt werden, welche von Box erbt. Um zu verhindern, dass neben 
 * Schuhobjekten auch andere Objekte in ShoeBox abgelegt werden können, 
 * ist es erforderlich den generischen Platzhalter der Klasse entsprechend einzuschränken.
 * 
 * @author Dmitrij Petrov, Anastasia Baron 
 *
 * @param <T>
 */
public class ShoeBox<T extends Shoes> extends Box<T> { //Nur Shoes koennen abgelegt werden 
	
private T pairShoe;

public ShoeBox() {
    	
    }  
	
	public void addShoes(T pairShoe){
	this.pairShoe=pairShoe;
	}
	
	public void removePairShoe()
		{
			pairShoe = null;
		}
		
	public String toString(){
	return "in diesem Schachtel liegen: " + pairShoe.toString();
		}
}
