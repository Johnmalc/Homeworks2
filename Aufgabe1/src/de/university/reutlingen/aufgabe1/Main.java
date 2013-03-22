package de.university.reutlingen.aufgabe1;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * TODO
 * 
 * @author
 * @author
 */

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		// no need to close it; VM will take care 
		// http://www.coderanch.com/t/590921/java/java/Scanner-Resource-leak
		Scanner scanYourNumber = new Scanner(System.in);
		try {

			/*
			 * Erstellung eines accounts. Und auch eine Karte. Wenn man bei
			 * card1.setPin() falsches pin eingeben, dann wie nach der aufgabe,
			 * kriegen sie nichts
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
			account1[positionOfAccount].setOverdraft(scanYourNumber.nextInt());

			System.out.println("Geben sie ihres Pin. Es muss 4 stellig sein");
			account1[positionOfAccount].setPin(scanYourNumber.nextInt());

			// Erstellungs eines CashCard objects
			CashCard card1 = new CashCard();

			// speichert die gleiche nummer des account in karte. Damit mit ihre
			// immer verbindet.
			int cardNumber = account1[positionOfAccount].getAccountNumber();
			card1.setAccountNumber(cardNumber);

			System.out.println("Geben sie ihres Pin fur die Karte. Es muss 4 stellig sein");
			card1.setPin(scanYourNumber.nextInt());

			// Speichert Pin der Karte in card1pin variable
			int card1Pin = card1.getPin();

			// In CashMaschine wird objekt1 ubergeben und gespeichert
			CashMachine a = new CashMachine(account1);
			/*
			 * Wenn diese Methode kommentiert wird, werden informationen
			 * angezeigt und pin uberpruft
			 */
			a.insertCashCard(card1);

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
			a.enterPin(card1Pin);
			a.accountStatement();
			a.withdraw(10000);
			a.ejectCashCard();
		} catch (NoSuchElementException msg) {
			System.out.println("Keinen Element gesetzt " + msg.getMessage());
		} catch (IllegalStateException msg) {
			System.out.println(msg.getMessage());
		} catch (Error msg) {
			System.err.println(msg.getMessage());
		}
	}
}
