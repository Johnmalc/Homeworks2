package de.aufgabe8.main;

import java.util.*;

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
		System.out.println("Ist die Liste leer : " + ac.isEmpty()); 
		
		/*
		 * 2 Account-Objekte der Liste hinzu und geben Sie die Liste auf der
		 * Konsole aus. Insiration taken from
		 * http://www.java-examples.com/get-elements-linkedlist-java-example
		 */
		Account das =  new Account(23456789, 465, 06541, 5465);
		Account das2 = new Account(32846519, 4965, 8576, 3122);
		Account das3 = new Account(123456, 465, 06541, 2135);
		//Element der Klasse Account in die Liste einfuegen
		ac.put(das.getAccountNumber(), das);
		ac.put(das2.getAccountNumber(), das2);
		System.out.println("\n" + "----------- Ausgabe der Map: -----------");
		System.out.println(ac.toString());
		
		/*
		 * Fugen Sie ein weiteres Account-Objekt mit Hilfe der Methode
		 * insertFirst(...) in die Liste ein. Uberprufen Sie die Korrektheit
		 * indem Sie die Liste erneut auf der Konsole ausgeben.
		 */
		ac.put(das3.getAccountNumber(), das3);

		// Gibt false zurueck, wenn die Liste nicht leer ist
		System.out.println("Ist die Map leer : " + ac.isEmpty());

		// Gibt die Anzahl der Elementen in der Liste zurueck
		System.out.println("Grosse der Maps : " + ac.size());
		System.out.println("\n" + "----------- Ausgabe der 2 Map: -----------");
		System.out.println(ac.toString());
		System.out.println("----------- Ausgabe des ersten Elements ------------");

		System.out.println(ac.get(0));

		System.out.println("\n" + "----------- Ausgabe der Iterator: -------");

		Iterator<Integer> s = ac.keyIterator();
		int p = 0;
		// Schaut nach Existenz des nächsten Elements
		while (s.hasNext() == true) {
			p++;
			System.out.println(p + " " + s.next());
		}
		
		System.out.println("---------------------------------------");
		System.out.println("Gibt es weitere elemente in der Liste: " + s.hasNext());
		
	}

}
