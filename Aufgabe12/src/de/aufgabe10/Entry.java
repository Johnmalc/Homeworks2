package de.aufgabe10;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */
public interface Entry {
	/*
	 * Component
	 */
	/**
	 * Mittels einer Methode print soll die verschachtelte Struktur auf der
	 * Konsole ausgegeben werden.
	 */
	public void prinVerschachtelteStruktur();

	/**
	 * Mittels einer Methode numberOfEntries soll die Anzahl der Eintrage in dem
	 * jeweiligen Teilbaum ermittelt werden.
	 * 
	 * @return eintrage
	 */
	public int numberOfEntries();
}
