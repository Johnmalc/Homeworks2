package de.aufgabe6.kartenspiel;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

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
		ls.add("karo 2");
		ls.add("karo 3");
		ls.add("karo 4");
		ls.add("karo 5");
		ls.add("karo 6");
		ls.add("karo 7");
		ls.add("karo 8");
		ls.add("karo 9");
		ls.add("karo 10");
		ls.add("karo Bube");
		ls.add("karo Dame");
		ls.add("karo Konig");
		ls.add("karo (kick) Ass");

		ls.add("pic 2");
		ls.add("pic 3");
		ls.add("pic 4");
		ls.add("pic 5");
		ls.add("pic 6");
		ls.add("pic 7");
		ls.add("pic 8");
		ls.add("pic 9");
		ls.add("pic 10");
		ls.add("pic Bube");
		ls.add("pic Dame");
		ls.add("pic Konig");
		ls.add("pic (kick) Ass");

		ls.add("herz 2");
		ls.add("herz 3");
		ls.add("herz 4");
		ls.add("herz 5");
		ls.add("herz 6");
		ls.add("herz 7");
		ls.add("herz 8");
		ls.add("herz 9");
		ls.add("herz 10");
		ls.add("herz Bube");
		ls.add("herz Dame");
		ls.add("herz Konig");
		ls.add("herz (kick) Ass");

		ls.add("kreuz 2");
		ls.add("kreuz 3");
		ls.add("kreuz 4");
		ls.add("kreuz 5");
		ls.add("kreuz 6");
		ls.add("kreuz 7");
		ls.add("kreuz 8");
		ls.add("kreuz 9");
		ls.add("kreuz 10");
		ls.add("kreuz Bube");
		ls.add("kreuz Dame");
		ls.add("kreuz Konig");
		ls.add("kreuz (kick) Ass");
		Iterator<String> ds = ls.iterator();

		// Ausgabe des Kartenstapels
		while (ds.hasNext()) {
			System.out.println(ds.next());
		}

		// Methode aus der Collections-Klasse mischt den Kartenstapel
		Collections.shuffle(ls);

		// Zum Einlesen von den Kommandozeilen
		Scanner sc = new Scanner(System.in);
		System.out.print("Anzahl von Spielern: ");
		int anzahlSpieler = sc.nextInt();
		System.out.print("Anzahl der Karten : ");
		int anzahlKarten = sc.nextInt();

		// Ausgabe des gemischten Kartenstapels
		System.out.println(ls);

		// Schleife zum Erstellen einer Liste fuer jeden Spieler
		int i = 0;
		while (i < anzahlSpieler)// wird wiederholt so oft, bis die gewuenschte
									// Anzahl nicht erzielt wird
		{
			List<String> spieler = new LinkedList<String>(ls.subList(0,
					anzahlKarten));
			ls.removeAll(spieler); // loescht die Elemente dieser Liste vom
									// ganzen Stapel
			System.out.println(spieler);// gibt die Karte dieses Spilers zurueck
			i++;
		}

		System.out.println(ls);// gibt die restlichen Karten in dem
								// Kartenspalten zurueck

	}

}
