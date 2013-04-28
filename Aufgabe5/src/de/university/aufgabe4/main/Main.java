package de.university.aufgabe4.main;

import java.util.Iterator;

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
		List<Account> ac = new List<Account>();
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
		
		//Element der Klasse Account in die Liste einfuegen
		ac.add(new Account(23456789, 465, 06541, 5465));
		ac.add(new Account(32846519, 4965, 8576, 3122));
		System.out.println("\n" + "----------- Ausgabe der Liste: -----------");
		System.out.println(ac.toString());
		
		/*
		 * Fugen Sie ein weiteres Account-Objekt mit Hilfe der Methode
		 * insertFirst(...) in die Liste ein. Uberprufen Sie die Korrektheit
		 * indem Sie die Liste erneut auf der Konsole ausgeben.
		 */
		ac.insertFirst(new Account(123456, 465, 06541, 2135));

		// Gibt false zurueck, wenn die Liste nicht leer ist
		System.out.println("Ist die Liste leer : " + ac.isEmpty());

		// Gibt die Anzahl der Elementen in der Liste zurueck
		System.out.println("Grosse der Liste : " + ac.size());
		System.out.println("\n" + "----------- Ausgabe der 2 Liste: -----------");
		System.out.println(ac.toString());
		System.out.println("----------- Ausgabe des ersten Elements ------------");

		System.out.println(ac.get(0));

		System.out.println("\n" + "----------- Ausgabe der Iterator: -------");

		Iterator<Account> s = ac.iterator();
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
