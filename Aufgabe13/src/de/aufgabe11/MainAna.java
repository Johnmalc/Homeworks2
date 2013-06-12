package de.aufgabe11;

import java.util.*;
import java.util.Map.Entry;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */

public class MainAna {
	public static void main(String[] args) {

		HashMap<Integer, Account> ac = new HashMap<Integer, Account>();
		/*
		 * Prufen Sie vor und nach dem Hinzufugen der Elemente den Ruckgabewert
		 * der Methode isEmpty(). Gibt true wenn leer - false wenn besetzt
		 */
		System.out.println("Ist die Set leer : " + ac.isEmpty());

		// erstellung account objekten, die danach in map kommen
		Account das = new Account(23456789, 465, 06541, 5465);
		Account das2 = new Account(32846519, 4965, 8576, 3122);
		Account das3 = new Account(123456, 465, 06541, 2135);

		// Element der Klasse Account in die Liste einfuegen
		ac.put(das.getAccountNumber(), das);
		ac.put(das2.getAccountNumber(), das2);
		ac.put(das3.getAccountNumber(), das3);

		System.out.println("\n" + "----------- Ausgabe der Map: -----------");
		System.out.println(ac.toString());

		// Gibt false zurueck, wenn die Liste nicht leer ist
		System.out.println("Ist die Map leer : " + ac.isEmpty());

		// Gibt die Anzahl der Elementen in der Liste zurueck
		System.out.println("Grosse der Maps : " + ac.size());

		System.out.println("\n" + "----------- Ausgabe der Iterator: -------");

		/*
		 * Iterator fur Schluessel-Werte
		 */
		Iterator<Integer> iter = (Iterator<Integer>) ac.keySet().iterator();
		while (iter.hasNext() == true) {
			System.out.println(" " + iter.next());
		}

		/*
		 * Iterator fur Werte
		 */
		Iterator<Account> iter2 = (Iterator<Account>) ac.values().iterator();
		while (iter2.hasNext() == true) {
			System.out.println(" " + iter2.next());
		}

		/*
		 * Ausgabe mit der Hilfe des Interfaces Entry
		 */
		System.out.println("\n"
				+ "----------- Ausgabe der Schlussel-Wert-Paar: -------");
		for (Entry<Integer, Account> entry : ac.entrySet()) {
			System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	}
}
