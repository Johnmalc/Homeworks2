package de.university.reutlingen.aufgabe1;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
	/**
	 * TODO
	 * Zum hinzufugen
	 * @author 
	 * @author 
	 */
	public static void main(String[] args) {
		try {

			/*
			 * Erstellung eines accounts. Und auch eine Karte. Wenn man bei
			 * card1.setPin() falsches pin eingeben, dann wie nach der aufgabe,
			 * kriegen sie nichts
			 */
			Scanner scanYourNumber = new Scanner(System.in);
			System.out.println("An welchen account wollen nutzen (sprich save&read) - 1 oder 2 ");
			int yourNumber = scanYourNumber.nextInt();
			
			// Wahl eines accounts
			switch (yourNumber) {
			case 1:
				Account account1 = new Account();
				
				System.out.println("Geben sie ihren account nummer");
				account1.setAccountNumber(scanYourNumber.nextInt());
				
				System.out.println("Geben sie ihren bank deposit");
				account1.setBankDeposit(scanYourNumber.nextInt());
				
				System.out.println("Geben sie dispo Kredit (overdraft) deposit");
				account1.setOverdraft(scanYourNumber.nextInt());
				
				System.out.println("Geben sie ihres Pin. Es muss 4 stellig sein");
				account1.setPin(scanYourNumber.nextInt());
				
				//Erstellungs eines CashCard objects
				CashCard card1 = new CashCard();
				
				// speichert die gleiche nummer des account in karte. Damit mit ihre immer verbindet.  
				int cardNumber = account1.getAccountNumber();
				card1.setAccountNumber(cardNumber);
				
				System.out.println("Geben sie ihres Pin fur die Karte. Es muss 4 stellig sein");
				card1.setPin(scanYourNumber.nextInt());
				
				//Speichert Pin der Karte in card1pin variable
				int card1Pin = card1.getPin();
				
				// In CashMaschine wird objekt1 ubergeben und gespeichert
				CashMachine a = new CashMachine(account1);
				/*
				 * Wenn diese Methode kommentiert wird, werden informationen
				 * angezeigt (und immer mit dem 0 betrag) und pin uberpruft (das muss noch in cashmaschine TODO sein)
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

				scanYourNumber.close();
				break;

			case 2:
				/*
				 * Hier sind schon kommentare weggelassen ! Waeren gleich
				 */
				Account account2 = new Account();
				System.out.println("Geben sie ihren account nummer");
				account2.setAccountNumber(scanYourNumber.nextInt());
				System.out.println("Geben sie ihren bank deposit");
				account2.setBankDeposit(scanYourNumber.nextInt());
				System.out
						.println("Geben sie dispo Kredit (overdraft) deposit");
				account2.setOverdraft(scanYourNumber.nextInt());
				System.out
						.println("Geben sie ihres Pin. Es muss 4 stellig sein");
				account2.setPin(scanYourNumber.nextInt());

				CashCard card2 = new CashCard();
				int cardNumber2 = account2.getAccountNumber();
				card2.setAccountNumber(cardNumber2);
				System.out
						.println("Geben sie ihres Pin fur die Karte. Es muss 4 stellig sein");
				card2.setPin(scanYourNumber.nextInt());
				int card2Pin = card2.getPin();

				CashMachine b = new CashMachine(account2);
				b.insertCashCard(card2);

				b.enterPin(card2Pin);
				b.accountStatement();
				b.withdraw(10000);
				b.ejectCashCard();

				scanYourNumber.close();
				break;
			default:
				System.out.println("Nur 1 oder 2 eingeben");
			}
		}catch (NoSuchElementException msg) {
			System.out.println("Keinen Element gesetzt" + msg.getMessage());
		} catch (IllegalStateException msg) {
			System.out.println(" Scanner closed" + msg.getMessage());
		} catch (Error msg) {
			System.err.println(msg.getMessage());
		}
	}
}
