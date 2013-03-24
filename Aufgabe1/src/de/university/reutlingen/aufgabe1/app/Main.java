package de.university.reutlingen.aufgabe1.app;

import java.util.InputMismatchException;
import java.util.Scanner;

import de.university.reutlingen.aufgabe1.exceptions.AnyException;
import de.university.reutlingen.aufgabe1.exceptions.KarteAus;
import de.university.reutlingen.aufgabe1.exceptions.KeineKarte;
import de.university.reutlingen.aufgabe1.exceptions.PinFalsch;

/**
 * TODO
 * 
 * @author
 * @author
 */

public class Main {

	public static void main(String[] args) throws AnyException, KeineKarte, PinFalsch, KarteAus {
		@SuppressWarnings("resource")
		// no need to close it; VM will take care 
		// http://www.coderanch.com/t/590921/java/java/Scanner-Resource-leak
		Scanner scanYourNumber = new Scanner(System.in);
		try {

			/*
			 * Erstellung eines accounts. Und auch eine Karte.
			 */
			
			Account[] account1 = new Account[3];

			System.out.println("An welche position wollen sie ihren account spreichern");
			int positionOfAccount = scanYourNumber.nextInt();
			
			account1[positionOfAccount] = new Account();
			account1[positionOfAccount].setAccountPossition(positionOfAccount);

			System.out.println("Geben sie ihren account nummer");
			account1[positionOfAccount].setAccountNumber(scanYourNumber.nextInt());

			System.out.println("Geben sie ihren bank deposit");
			account1[positionOfAccount].setBankDeposit(scanYourNumber.nextInt());

			System.out.println("Geben sie dispo Kredit (overdraft) deposit");
			account1[positionOfAccount].setOverdraft(scanYourNumber.nextDouble());

			System.out.println("Geben sie ihres Pin ('account erstellung'). Es muss 4 stellig sein");
			account1[positionOfAccount].setPin(scanYourNumber.nextInt());

			// Erstellungs eines CashCard objects
			CashCard card1 = new CashCard();

			// speichert die gleiche nummer des account in karte. Damit mit ihre
			// immer verbindet.
			int cardNumber = account1[positionOfAccount].getAccountNumber();
			card1.setAccountNumber(cardNumber);
			/**
			 * Wenn man bei card1.setPin() falsches pin eingeben, dann sie kriegen nichts
			 */
			System.out.println("Geben sie ihres Pin fur die Karte ('verbindung mit acc.'). Nur 4 Stelle");
			card1.setPin(scanYourNumber.nextInt());

			// Speichert Pin der Karte in card1pin variable
			int card1Pin = card1.getPin();

			// In CashMaschine wird objekt1 ubergeben und gespeichert
			CashMachine cashMachine = new CashMachine(account1);
			/*
			 * Wenn diese Methode kommentiert wird, werden informationen
			 * angezeigt und pin uberpruft
			 */
			cashMachine.insertCashCard(card1);

				/*
				 * Weitere Moglichkeit zum andern Wenn diese methode
				 * enterPin kommentiert wird, dann keine karte im Automat und
				 * keine Informationen angezeigt werden Wenn card inserted,dann
				 * werden nur information angezeigt. Die Uberprufung wird nicht
				 * statfinden. Sie konnen auch hier die withdraw nicht nutzen Am
				 * besten testen mit mehr als 1000000 oder 10, sieht man
				 * ergebniss 
				 * ?tested? withdraw - ja beides 
				 * ?tested? statement -ja beides 
				 * ?tested? pin - jae
				 */
			cashMachine.enterPin(card1Pin);
			cashMachine.accountStatement();
			cashMachine.withdraw(10000);
			cashMachine.ejectCashCard();
		} catch (ArrayIndexOutOfBoundsException msg) {
			System.out.println("Sie wollen position ausserhalb eines Array zugreffen " + msg.getMessage() );
		} catch (InputMismatchException msg) {
			System.out.println("Etwas ist falsch bei der Eingabe: "+ msg.getMessage());
		} catch (IllegalStateException msg) {
			System.out.println(msg.getMessage());
		} catch (Error msg) {
			System.err.println(msg.getMessage());
		}
	}
}
