package de.aufgabe8.main;

import java.util.*;
import java.util.Map.Entry;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */

public class Main {
	public static void main(String[] args) {

		/*
		 * Testen Sie die Klasse List insbesondere unter Verwendung der Klasse
		 * Account (aus Aufgabe 1) als Konkretisierung des Typ-Parameters
		 */
		TreeMap<Integer, Account> ac = new TreeMap<Integer, Account>();
		/*
		 * Prufen Sie vor und nach dem Hinzufugen der Elemente den Ruckgabewert
		 * der Methode isEmpty(). Gibt true wenn leer - false wenn besetzt
		 */
		System.out.println("Ist die Set leer : " + ac.isEmpty());

		/*
		 * 2 Account-Objekte der Liste hinzu und geben Sie die Liste auf der
		 * Konsole aus. Insiration taken from
		 * http://www.java-examples.com/get-elements-linkedlist-java-example
		 */
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
		 * http://stackoverflow.com/questions/46898/how-do-i-iterate-over-each-entry
		 * -in-a-map
		 */
		for (Entry<Integer, Account> entry : ac.entrySet()) {
			System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	}
}
