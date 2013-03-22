package de.university.reutlingen.aufgabe1;

public class State {
	Karte status;

	/**
	 * Enumeration
	 * http://javarevisited.blogspot.cz/2011/08/enum-in-java-example-
	 * tutorial.html
	 */
	public enum Karte {
		READY, CARD_INSERTED, PIN_CORRECT, PIN_WRONG;
	}

	public Karte statusReady = Karte.READY;
	public Karte statusCardInserted = Karte.CARD_INSERTED;
	public Karte statusPinCorrect = Karte.PIN_CORRECT;
	public Karte statusPinWrong = Karte.PIN_WRONG;

	/**
	 * 
	 * @return status
	 */
	public Karte getStatus() {
		return status;
	}

	/**
	 * <h2>Setzt den Status des Emums</h2 Kopiert (Copyright - not mine) aus dem
	 * http://www.java-forum.org/java-basics-anfaenger-themen/87727-enum-dann-
	 * setter -setzen.html
	 */
	public void setStatus(Karte status) {
		if (status != null) {
			this.status = status;
		} else {
			throw new NullPointerException("status darf nicht null sein");
		}
	}
}