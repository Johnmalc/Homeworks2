package de.university.andereVersion.bjorn;

import java.util.*;

public class CashMachine {
	public enum Zustand {
		READY, CARD_INSERTED, PIN_CORRECT, PIN_WRONG;
	}

	Zustand eins;
	Zustand zwei;
	CashCard cashCard = new CashCard();
	public String status;
	Account aEins = new Account();
	Account aZwei = new Account();
	Account aDrei = new Account();
	Account aVier = new Account();
	Account aFuenf = new Account();
	Account aSechs = new Account();
	Account aSieben = new Account();
	Account aAcht = new Account();
	Account aNeun = new Account();
	Account aZehn = new Account();
	Account inBearbeitung = new Account();
	Scanner enter = new Scanner(System.in);

	Account[] accounts = { aEins, aZwei, aDrei, aVier, aFuenf, aSechs, aSieben,
			aAcht, aNeun, aZehn };

	public CashMachine() {
		this.eins = Zustand.READY;
		this.zwei = Zustand.PIN_WRONG;
		status = "READY";
	}

	public void insertCashCard(CashCard cashCarde) {
		switch (eins) {
		case READY:
			eins = Zustand.CARD_INSERTED;
			status = "CARD INSERTED";
			System.out.println("Status : " + status);
			System.out.println("Willkommen");
			cashCard = cashCarde;

			for (int i = 0; i < accounts.length; i++) {
				if (cashCard.getAccountNumber() == accounts[i]
						.getAccountNumber()) {
					inBearbeitung = accounts[i];
					System.out.println("Konto gefunden!");

				} // end of if

			} // end of for

			if (inBearbeitung.getAccountNumber() == 0) {
				System.out.println("");
				System.out
						.println("Fehler EC-Karte konnte keinem Konto zugewiesen werden");
				System.exit(-1);
			} // end of if-else

			break;

		case CARD_INSERTED:
			System.out.println("Karte ist bereits eingelesen!");
			break;

		}

	} // Methodenende

	public void withdraw(double amount) {
		switch (eins) {
		case CARD_INSERTED:

			switch (zwei) {
			case PIN_CORRECT:

				if (amount <= (inBearbeitung.getOverdraft() + inBearbeitung
						.getBankDeposit())) {
					inBearbeitung.bankDeposit = (inBearbeitung.bankDeposit - amount);
					System.out.println("Ihr Neuer Kontostand betraegt : "
							+ inBearbeitung.getBankDeposit() + " EUR");

				}

				else {
					System.out
							.println("Der Angeforderte Betrag ueberschreitet ihr Dispolimit! Keine Auszahlung moeglich");

				} // end of if-else
				break;

			case PIN_WRONG:

				System.out.println("");
				System.out.println("Pin nicht Korrekt!");
				break;

			}

		case READY:

			System.out.println("");
			System.out.println("Fehler keine Karte eingelesen!");

		}
	}

	public void accountStatement() {
		switch (eins) {
		case CARD_INSERTED:

			System.out.println("Ihre Aktuellen Kontodaten lauten : ");
			System.out.println();
			System.out.println("Kontonummer  : "
					+ inBearbeitung.getAccountNumber());
			System.out.println("Kontostand   : "
					+ inBearbeitung.getBankDeposit());
			System.out
					.println("Dispokredit  : " + inBearbeitung.getOverdraft());
			System.out.println("");
			eins = Zustand.READY;
			break;

		case READY:

			System.out.println("");
			System.out.println("Bitte erst Karte einlesen!");

		}
	}

	public void ejectCashCard() {
		switch (eins) {
		case CARD_INSERTED:

			cashCard = null;
			eins = Zustand.READY;
			status = "READY";
			System.out.println("Status : " + status);
			System.out.println("Auf Widersehen");
			break;

		case READY:

			System.out.println("");
			System.out
					.println("Fehler es befindet sich keine Karte im Automaten");
			break;

		}

	}

	public void enterPin(int pinEingabe) {
		boolean ok = false;

		while (ok != true) {

			System.out.println("");
			System.out.println("Bitte Pin eingeben: ");

			try {

				pinEingabe = enter.nextInt();

				if (enter.hasNextInt()) {
					ok = true;
				}

			}

			catch (InputMismatchException h) {
				System.out.println("");
				System.out
						.println("Fehler! Es wurde kein gültiger Pin eingegeben");
				System.out.println("");
				enter.next();

			}

		}

		if (inBearbeitung.getPin() == pinEingabe) {
			eins = Zustand.CARD_INSERTED;
			zwei = Zustand.PIN_CORRECT;

		} // end of if

		else {
			zwei = Zustand.PIN_WRONG;
		}

	}

}
