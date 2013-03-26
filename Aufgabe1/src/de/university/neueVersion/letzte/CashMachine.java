package de.university.neueVersion.letzte;

import de.university.neueVersion.exceptions.KarteAus;
import de.university.neueVersion.exceptions.KarteIn;
import de.university.neueVersion.exceptions.NichtGenugGeld;
import de.university.neueVersion.exceptions.PinFalsch;

public class CashMachine {

	Account[] accounts;
	CashCard cashCard;
	State state;
	State statePIN;
	int zaehler; // fuer Arrays

	public CashMachine() {
		accounts = new Account[4];
		zaehler = 0;
		state = State.READY;
		statePIN = State.PIN_WRONG;
		// fur main
		accounts[0] = new Account(12345678, 0.0, 2000, 1234);
		accounts[1] = new Account(23456789, -100.0, 200, 2345);
		accounts[2] = new Account(34567890, -200.0, 300, 3456);
		accounts[3] = new Account(45678901, 0.0, 5000, 4567);

	}

	public void insertCashCard(CashCard cashCardX) throws KarteIn {

		switch (state) {
		case READY:
			cashCard = cashCardX;
			state = State.CARD_INSERTED;
			System.out.println("Automat ist auf Status " + state + " gesetzt.");

			break;
		default:
			throw new KarteIn();

		} // switch Ende
	}// Karteneingabe Ende

	/**
	 * Die Methode gleicht die Eingabe des Pins mit dem Pin des gerade
	 * verwendeten Accounts ab.
	 * 
	 * @param pinX
	 * @throws PinFalsch
	 * @throws KarteAus
	 */
	public void pinEingeben(int pinX) throws PinFalsch, KarteAus {
		switch (state) {
		case CARD_INSERTED:
			for (int acc : accounts ) {
				if ((accounts[i].getAccountNumber()) == (cashCard.getAccountNumber())) {
					zaehler = i;
					i = accounts.length;
				}
			}

			if (accounts[zaehler].getPin() == pinX) {
				statePIN = State.PIN_CORRECT;
				System.out.println("Sie haben den richtigen Pin eingegeben.");
				System.out.println("Automat ist auf Status " + statePIN
						+ " gesetzt.");
			} // end of if
			else {
				throw new PinFalsch();
			} // end of if-else

			break;
		default:
			throw new KarteAus();

		} // switch Ende

	} // pinEingeben Ende

	public void withdraw(double amount) throws PinFalsch, KarteAus, NichtGenugGeld {
		switch (state) {
		case CARD_INSERTED:
			switch (statePIN) {
			case PIN_CORRECT:
				System.out.println("Ihr Kontoguthaben ist: "
						+ accounts[zaehler].getBankDeposit() + " Euro.");
				if (accounts[zaehler].getBankDeposit() > accounts[zaehler]
						.getOverdraft()) {
					accounts[zaehler].setBankDeposit(accounts[zaehler]
							.getBankDeposit() - amount);
					System.out.println("Sie haben erfolgreich " + amount
							+ " Euro abgehoben.");
					System.out.println("Ihr Kontoguthaben ist: "
							+ accounts[zaehler].getBankDeposit() + " Euro.");
				} else {
					throw new NichtGenugGeld();
				}

				break;
			default:
				throw new PinFalsch();
			}

			break;
		default:
			throw new KarteAus();

		} // switch State Ende
	}// Abheben Ende

	public void accountStatement() throws PinFalsch, KarteAus {
		switch (state) {
		case CARD_INSERTED:
			switch (statePIN) {
			case PIN_CORRECT:
				System.out.println("\n" + "Account Statement: " + "\n"
						+ "Account Nr.: "
						+ accounts[zaehler].getAccountNumber() + "\n"
						+ "Bank Deposit: " + accounts[zaehler].getBankDeposit()
						+ "\n" + "Overdraft: "
						+ accounts[zaehler].getOverdraft());
				break;
			default:
				throw new PinFalsch();
			}

			break;
		default:
			throw new KarteAus();

		} // switch
	} // Kontoinformationen Ende

	public void ejectCashCard() throws KarteAus {
		switch (state) {
		case CARD_INSERTED:
			cashCard = null;
			state = State.READY;
			System.out.println("Ihr Karte ist entfenrt!");
			System.out.println("Automat ist auf Status " + state + " gesetzt.");
			break;
		default:
			throw new KarteAus();
		} // Switch State Ende
	} // Kartenauswurf Ende

}
