package de.university.reutlingen.aufgabe1;

public class Karte {
	State status;

	/**
	 * Enumeration
	 * http://javarevisited.blogspot.cz/2011/08/enum-in-java-example-
	 * tutorial.html
	 */
	public enum State {
		READY, CARD_INSERTED, PIN_CORRECT, PIN_WRONG;
	}

	public State statusReady = State.READY;
	public State statusCardInserted = State.CARD_INSERTED;
	public State statusPinCorrect = State.PIN_CORRECT;
	public State statusPinWrong = State.PIN_WRONG;

	/**
	 * 
	 * @return status
	 */
	public State getStatus() {
		return status;
	}

	/**
	 * <h2>Setzt den Status des Emums</h2 Kopiert (Copyright - not mine) aus dem
	 * http://www.java-forum.org/java-basics-anfaenger-themen/87727-enum-dann-
	 * setter -setzen.html
	 */
	public void setStatus(State status) {
		if (status != null) {
			this.status = status;
		} else {
			throw new NullPointerException("status darf nicht null sein");
		}
	}
}