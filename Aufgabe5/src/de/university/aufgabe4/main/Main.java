package de.university.aufgabe4.main;
import de.university.aufgabe4.exc.*;
/** 
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */

public class Main {

	public static void main(String[] args) {

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
			cashMachine.pinEingeben(1234);
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
	}
}
