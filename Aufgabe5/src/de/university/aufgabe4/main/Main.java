package de.university.aufgabe4.main;

import java.util.Iterator;
import de.university.aufgabe4.exc.*;

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
<<<<<<< HEAD
		ac.add(new Account(2345678, 465, 06541, 0265));
		ac.add(new Account(3456789, 465, 06541, 5554));
		ac.insertFirst(new Account(123456, 465, 06541, 6595));
=======
		ac.add(new Account(54564654, 465, 06541, 0555));
		ac.add(new Account(454, 465, 06541, 554));
		ac.insertFirst(new Account(12345678, 465, 06541, 0555)); // funktioniert auch mit dem 
>>>>>>> f9c2250a6aaac3ecc2747458d2a5649f3f5eb7d6
		
		System.out.println(ac.toString());

		System.out.println(ac.isEmpty());
		System.out.println(ac.size());
		
		System.out.println(ac.get(0)); // gibt ertes Element aus der Liste
		
<<<<<<< HEAD
		
	
		
		System.out.println("");
		System.out.println("----------- Ausgabe der liste: -----------");
		
=======
		System.out.println("");
		System.out.println("----------- Ausgabe der liste: -----------");
>>>>>>> f9c2250a6aaac3ecc2747458d2a5649f3f5eb7d6

		/*
		 * 2 Account-Objekte der Liste hinzu und geben Sie die Liste auf der
		 * Konsole aus. Insiration taken from
		 * http://www.java-examples.com/get-elements-linkedlist-java-example
		 */
<<<<<<< HEAD
		ac.add(new Account(45678912, 2358, 06541, 2555));
		ac.add(new Account(56789472, 2589, 06541, 1455));
=======
		ac.add(new Account(54564654, 465, 06541, 0555));
		ac.add(new Account(654864, 465, 06541, 0555));
>>>>>>> f9c2250a6aaac3ecc2747458d2a5649f3f5eb7d6
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
<<<<<<< HEAD
=======
	
		
		System.out.println("------------------------------------------------------");

		CashMachine cashMachine = new CashMachine();
		CashCard cashCard1 = new CashCard(12345678);
		CashCard cashCard2 = new CashCard(23456789);

		// Test 1 um CardNotInsertedException zu pruefen
		try {
			cashMachine.accountStatement();
		} catch (CardNotInsertedException e) {
			System.out.println("Test1 ist erfolgreich" + "\n");

		}
		
		// Test 2 um CardInsertedException zu pruefen
		try {
			System.out.println("Sie setzen die Karte im Automat");
			cashMachine.insertCashCard(cashCard1);
			cashMachine.insertCashCard(cashCard2);
		} catch (CardInsertedException e) {
			System.out.println("Test2 ist erfolgreich" + "\n");
		} catch (InvalidCardException e) {
			System.out.println("Test2 ist nicht bestanden.");
		}

		/*
		 * Test 3 um PinNotCorectException zu pruefen; CardNotInsertedException
		 * sollte in dem Fall nicht aufgetreten werden!
		 * Wenn pin richtig wird nichts angezeigt
		 */
		try {
			cashMachine.pinEingeben(1256);
		} catch (PinNotCorectException e) {
			System.out.println("Test3 ist erfolgreich" + "\n");
		} catch (CardNotInsertedException e) {
			System.out.println("Test3 ist nicht bestanden" + "\n");
		} catch (InvalidCardException e) {
			System.out.println("Test3 ist nicht bestanden" + "\n");
		}

		/*
		 * Test 4 um NotEnoughMoneyException zu pruefen; PinNotCorectException
		 * und CardNotInsertedException sollten hier nicht getroffen werden
		 */
		try {
			cashMachine.pinEingeben(0555);
			cashMachine.withdraw(10900);
		} catch (PinNotCorectException e) {
			System.out.println("Test4 ist nicht bestanden" + "\n");
		} catch (CardNotInsertedException e) {
			System.out.println("Test4 ist nicht bestanden" + "\n");
		} catch (NotEnoughMoneyException e) {
			System.out.println("Test4 ist erfolgreich!" + "\n");
		} catch (InvalidCardException e) {
			System.out.println("Test4 ist nicht bestanden" + "\n");
		}

		// Test 5 prueft, ob InvalidCardException funktioniert
		try {
			cashMachine.ejectCashCard(); // Wir entfernen aktuelle gueltige Karte
			cashMachine.insertCashCard(new CashCard(11111111)); 
			/* Es wurde kein Konto mit disesem Kontonummer geschpeichert, 
			 * d.h. es sollte die Fehlermeldung erscheinen, 
			 * dass es kein Konto existiert, das dieser Karte zugeordnet ist
			 */
		} catch (CardNotInsertedException e) {
			System.out.println("Test5 ist nict bestanden!" + "\n");
		} catch (CardInsertedException e) {
			System.out.println("Test5 ist nict bestanden!" + "\n");
		} catch (InvalidCardException e) {
			System.out.println("Test5 ist erfolgreich!" + "\n");
		}
>>>>>>> f9c2250a6aaac3ecc2747458d2a5649f3f5eb7d6
	}

}
