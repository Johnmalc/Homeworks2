package de.aufgabe6.kartenspiel;

import java.util.*;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */
public class Geben {
	/*
	 * Schreiben Sie ein Programm, das ein Kartenspiel mit 52 Karten mit 4
	 * Farben (Kreuz, Pik, Herz und Karo) zu je 13 Karten (Ass, Konig, Dame,
	 * Bube, 10, 9, 8, 7, 6, 5, 4, 3, 2) auf eine uber die Kommandozeile
	 * definierte Anzahl von Spielern verteilt. Das zweite
	 * Kommandozeilenargument gibt an wie viele Karten jeder Spieler erhalten
	 * soll. Hinweis: Karten konnen als String-Objekte reprasentiert werden
	 * ("karo 6","herz dame", ...). Eine Liste eignet sich zur Darstellung des
	 * Kartenstapels, mit der shuffle-Methode aus der Collections-Klasse kann
	 * der Kartenstapel gemischt werden und mit der Methode sublist(...) soll
	 * man ein Blatt je Spieler definieren und aus dem restlichen Kartenstapel
	 * loschen. Inspiratation:
	 * http://www.tutorialspoint.com/java/util/collections_shuffle.htm
	 */
	public static void main(String[] args) {

		List<String> ls = new LinkedList<String>();

		String array[] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Bube", "Dame", "Konig", "(kick) Ass"};
		String sad[] = {"kreuz", "karo", "piko", "herz"};
		
		for (int i = 0; i < array.length; i++) {
			for (int s = 0; s < sad.length; s++) {
				ls.add(sad[s].toString() + " " + array[i].toString());
			}
		}
		//System.out.println(ls.toString()); //Ausgabe der Liste
		
		// Methode aus der Collections-Klasse mischt den Kartenstapel
		Collections.shuffle(ls);
		
		// Zum Einlesen von den Kommandozeilen
		int anzahlSpieler = Integer.parseInt(args[0]);
		int anzahlKarten = Integer.parseInt(args[1]);
		System.out.print("Anzahl der Karten : " + anzahlSpieler + "\n");
		System.out.print("Anzahl von Spielern: " + anzahlKarten + "\n");

		// Schleife zum Erstellen einer Liste fuer jeden Spieler
		int i = 0;
		while (i < anzahlSpieler) {
			// wird wiederholt so oft, bis die gewuenschte Anzahl nicht erzielt
			// wird

			List<String> spieler = new LinkedList<String>(ls.subList(0,
					anzahlKarten));
			ls.removeAll(spieler);

			// loescht die Elemente dieser Liste vom ganzen Stapel
			System.out.println(spieler);
			// gibt die Karte dieses Spilers zurueck
			i++;
		}
	}
}
