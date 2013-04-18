package de.university.aufgabe4.main;

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
		List<Account> ac = new List<>();
		/*
		 * Prufen Sie vor und nach dem Hinzufugen der Elemente den Ruckgabewert
		 * der Methode isEmpty().
		 */
		ac.isEmpty();
		/*
		 * Testen Sie die neuen Methoden der Liste ausfuhrlich
		 */
		ac.add(elem);
		ac.get(pos);
		ac.insertFirst(elem);
		ac.isEmpty();
		ac.next();
		ac.remove();
		ac.toString();
		ac.size();

		/*
		 * 2 Account-Objekte der Liste hinzu und geben Sie die Liste auf der
		 * Konsole aus. Insiration taken from
		 * http://www.java-examples.com/get-elements-linkedlist-java-example
		 */
		ac.add(elem);
		ac.add(elem);

		// gibt sie wieder zuruck
		for (int i = 0; i < ac.size(); i++) {
			System.out.println(ac.get(i));
		}
		/*
		 * Fugen Sie ein weiteres Account-Objekt mit Hilfe der Methode
		 * insertFirst(...) in die Liste ein. Uberprufen Sie die Korrektheit
		 * indem Sie die Liste erneut auf der Konsole ausgeben.
		 */

	}

}
