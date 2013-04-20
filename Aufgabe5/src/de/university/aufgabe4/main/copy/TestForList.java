package de.university.aufgabe4.main.copy;

import meineversion.Account;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */

public class TestForList {

	public static void main(String[] args) {

		/*
		 * Testen Sie die Klasse List insbesondere unter Verwendung der Klasse
		 * Account (aus Aufgabe 1) als Konkretisierung des Typ-Parameters
		 */
		List<Account> ac = new List<Account>();
		/*
		 * Prufen Sie vor und nach dem Hinzufugen der Elemente den Ruckgabewert
		 * der Methode isEmpty().
		 * prints true if empty
		 * false if it full
		 */
		System.out.println(ac.isEmpty());
		/*
		 * Testen Sie die neuen Methoden der Liste ausfuhrlich
		 */
		ac.insertFirst(new Account(54564654, 465, 06541, 0555));
		ac.insertFirst(new Account(54564654, 465, 06541, 0555));
		// ac.get(0); //nicht funktieniert
		System.out.println(ac.isEmpty());
		ac.toString();
		System.out.println(ac.size());

		/*
		 * 2 Account-Objekte der Liste hinzu und geben Sie die Liste auf der
		 * Konsole aus. Insiration taken from
		 * http://www.java-examples.com/get-elements-linkedlist-java-example
		 */
//		ac.add(new Account(54564654, 465, 06541, 0555));
//		ac.add(new Account(654864, 465, 06541, 0555));
//
//		// gibt sie wieder zuruck
//		for (int i = 0; i < ac.size(); i++) {
//			System.out.println(ac.get(i) +": "+ac.toString());
//		}
		/*
		 * Fugen Sie ein weiteres Account-Objekt mit Hilfe der Methode
		 * insertFirst(...) in die Liste ein. Uberprufen Sie die Korrektheit
		 * indem Sie die Liste erneut auf der Konsole ausgeben.
		 */

	}

}
