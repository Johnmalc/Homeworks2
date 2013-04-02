package de.reutlingen.university.aufgabe3;

import de.reutlingen.university.aufgabe3.NichtErlaubtesFormatException;

/**
 * @author Dmitry Petrov
 * @author Anastasia Baron
 * 
 * Schreiben Sie die abstrakte Klasse Shoes, diese dient als Basisklasse fuer Paar 
 * verschiedener Schuharten. Jedes Schuhpaarobjekt besteht aus einem Namen und 
 * einer Schuhgroesse. Es sollen auch halbe Schuhgroessen erlaubt sein
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
	double schuhgroesse; 

	// Konstruktor	
 	public Shoes(String name, double schuhgroesse ) {
	 this.name=name;
	 try {
		this.setSchuhgroesse(schuhgroesse);
	} catch (NichtErlaubtesFormatException e) {
	 }
	 
}
 //Set-Methode fuer Schuhegroesse erlaubt auch die Halbgroesse.
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
 	
 	//damit Methode toString in der Klasse Box gut funktionieren koennte
 	public String toString(){
 		if (state==State.GROESSE_OK)
 		{return name +" mit der Groesse " + schuhgroesse;}
 		return null;
			}

}
