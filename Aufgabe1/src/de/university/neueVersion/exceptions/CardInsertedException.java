package de.university.neueVersion.exceptions;

public class CardInsertedException extends Exception {
	
	static String message ="-= Eine Karte ist schon eingegeben! Bitte entwerfen. =-";
	/**
	 * U NAS RAZNYE KONSTRUKTORY. Posmotrim, s kakim luchshe idet. 
	 * Zdes pochti takojzhe kak i v AnyException u tebya
	 *  
	 * ?tested?
	 */
			public CardInsertedException (){
        super(message); 
        }
}
