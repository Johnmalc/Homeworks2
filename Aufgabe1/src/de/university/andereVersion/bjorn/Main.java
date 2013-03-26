package de.university.andereVersion.bjorn;

import java.util.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner eingabe = new Scanner(System.in);
		boolean fertig = false;
		double betrag = 0;

		CashMachine automat = new CashMachine();
		CashCard karte = new CashCard();
		karte.setAccountNumber(20012);
		automat.aVier.setAccountNumber(20012);
		automat.aVier.setBankDeposit(5000);
		automat.aVier.setOverdraft(2000);
		automat.aVier.setPin(20041);

		while (fertig != true) {

			// System.out.println("Bitte Karte eingeben");
			automat.insertCashCard(karte);
			System.out.println("");
			System.out.println("MENUE");
			System.out.println("---------------------");
			System.out.println("");
			System.out.println("1: Kontodaten abrufen");
			System.out.println("2: Auszahlung");
			System.out.println("3: Verlassen");
			System.out.println("Ihre Wahl: ");
			int wahl = 0;

			try {
				wahl = eingabe.nextInt();
			} catch (InputMismatchException f) {
				System.out.println("");
				System.out.println("Fehler bitte 1, 2 oder 3 eingebn!");
				eingabe.next();
			}

			switch (wahl) {

			case 1:

				automat.accountStatement();
				break;

			case 2:
				automat.enterPin(0);
				System.out.println("");
				System.out.println("Betrag: ");

				try {
					betrag = eingabe.nextDouble();

				} catch (InputMismatchException e) {
					System.out
							.println("Fehler! Es wurde kein gültiger Betrag eingegeben: ");
					eingabe.next();

				}
				automat.withdraw(betrag);

				break;

			case 3:

				automat.ejectCashCard();
				System.out.println("");
				fertig = true;
				break;

			} // end of switch

		} // end of while

	}

}
