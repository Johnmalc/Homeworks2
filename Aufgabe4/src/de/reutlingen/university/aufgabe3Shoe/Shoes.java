package de.reutlingen.university.aufgabe3Shoe;

import de.reutlingen.university.aufgabe3Shoe.NichtErlaubtesFormatException;

/**Schreiben Sie die abstrakte Klasse Shoes, diese dient als Basisklasse für Paar 
 * verschiedener Schuharten. Jedes Schuhpaarobjekt besteht aus einem Namen und 
 * einer Schuhgröße. Es sollen auch halbe Schuhgrößen erlaubt sein
 * 
 * 
 * 
 * @author Dmitrij Petrov, Anastasia Baron
 *
 */

public abstract class Shoes 
{
    State state=State.GROESSE_NICHT_ERLAUBT;
	String name;
	double schuhgroesse; //TODO "Es sollen auch halbe Schuhgroessen erlaubt sein" 

	// Konstruktor	
 	public Shoes(String name, double schuhgroesse ) {
	 this.name=name;
	 try {
		this.setSchuhgroesse(schuhgroesse);
	} catch (NichtErlaubtesFormatException e) {
	 }
	 
}
 	public void setSchuhgroesse(double schuhgroesse) throws NichtErlaubtesFormatException{
 		if(schuhgroesse*2==(int)(schuhgroesse*2) )
 		 {
 			state=state.GROESSE_OK;
 			 this.schuhgroesse=schuhgroesse;
 		 }
 			 else {
 				 throw new NichtErlaubtesFormatException();
 			 }	
 	}
 	
 	public String toString()//damit Methode toString in der Klasse Box gut funktionieren koennte
	{
 		if (state==State.GROESSE_OK)
 		{return name +" mit der Groesse " + schuhgroesse;}
 		return null;
			}

}
