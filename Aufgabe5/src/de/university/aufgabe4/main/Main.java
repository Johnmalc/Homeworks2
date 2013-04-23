package de.university.aufgabe4.main;

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
		 * der Methode isEmpty(). prints true if empty - false if it full
		 */
		System.out.println(ac.isEmpty());
		/*
		 * Testen Sie die neuen Methoden der Liste ausfuhrlich
		 */
		//ac.insertFirst(new Account(999954, 465, 06541, 0555));
		ac.add(new Account(54564654, 465, 06541, 0555));
		ac.add(new Account(454, 465, 06541, 554));
		System.out.println(ac.toString());

		System.out.println(ac.isEmpty());
		System.out.println(ac.size());
		System.out.println("");
		System.out.println(ac.get(0)); // oder schon
		System.out.println("----------- Ausgabe der liste: -----------");
		System.out.println(ac.size());

		/*
		 * 2 Account-Objekte der Liste hinzu und geben Sie die Liste auf der
		 * Konsole aus. Insiration taken from
		 * http://www.java-examples.com/get-elements-linkedlist-java-example
		 */
		ac.add(new Account(54564654, 465, 06541, 0555));
		ac.add(new Account(654864, 465, 06541, 0555));
		System.out.println(ac.toString());

		/*
		 * Fugen Sie ein weiteres Account-Objekt mit Hilfe der Methode
		 * insertFirst(...) in die Liste ein. Uberprufen Sie die Korrektheit
		 * indem Sie die Liste erneut auf der Konsole ausgeben.
		 */
		System.out.println("\n " + "----------- Ausgabe der 2 liste: -------");
		ac.insertFirst(new Account(54, 654, 9, 333));
		System.out.println(ac.toString());
		
		System.out.println("\n " + "----------- Ausgabe der Cashmaschine acocunts : -------");
		CashMachine<Account> a = new CashMachine<Account>();
		System.out.println(a.accounts.toString());
	
	}

}
