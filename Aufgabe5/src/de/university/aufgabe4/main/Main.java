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
		 * der Methode isEmpty(). prints true if empty - false if it full
		 */
		System.out.println(ac.isEmpty());
		/*
		 * Testen Sie die neuen Methoden der Liste ausfuhrlich
		 */
		 // funktioniert auch mit dem 
		ac.add(new Account(2345678, 465, 06541, 0265));
		ac.add(new Account(3456789, 465, 06541, 5554));
		ac.insertFirst(new Account(123456, 465, 06541, 6595));
		
		System.out.println(ac.toString());

		System.out.println(ac.isEmpty());
		System.out.println(ac.size());
		
		System.out.println(ac.get(0)); // gibt ertes Element aus der Liste
		
		
	
		
		System.out.println("");
		System.out.println("----------- Ausgabe der liste: -----------");
		

		/*
		 * 2 Account-Objekte der Liste hinzu und geben Sie die Liste auf der
		 * Konsole aus. Insiration taken from
		 * http://www.java-examples.com/get-elements-linkedlist-java-example
		 */
		ac.add(new Account(45678912, 2358, 06541, 2555));
		ac.add(new Account(56789472, 2589, 06541, 1455));
		System.out.println(ac.size());
		System.out.println(ac.toString());

		/*
		 * Fugen Sie ein weiteres Account-Objekt mit Hilfe der Methode
		 * insertFirst(...) in die Liste ein. Uberprufen Sie die Korrektheit
		 * indem Sie die Liste erneut auf der Konsole ausgeben.
		 */
		System.out.println("\n " + "----------- Ausgabe 2 der liste: -------");
		ac.insertFirst(new Account(1112586, 654, 9, 3363));
		System.out.println(ac.toString());
		
		System.out.println("\n " + "----------- Ausgabe der Cashmaschine acocunts : -------");
		CashMachine<Account> a = new CashMachine<Account>();
		System.out.println(a.accounts.toString());
	
		System.out.println("\n " + "----------- Ausgabe der Iterator: -------");

		Iterator<Account> s = ac.getIterator();
		int p = 0;
		while (s.hasNext() == true ) { // gleicht ab
			p++;
			System.out.println(p + " " + s.next());
		}
	}

}
