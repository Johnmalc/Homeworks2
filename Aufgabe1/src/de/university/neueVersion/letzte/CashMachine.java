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
	/**
	 * 
	 * Nur im Zustand READY können die Informationen der eingegebenen
	 * Cashcard im Attribute cashCard abgespeichert werden.
	 * Bei erfolgreicher Eingabe wechselt der Zustand von READY auf CARD_INSERTED. 
	 * Der Status des Automaten soll auf der Konsole protokolliert werden.
	 * 
	 * @param cashCardX
	 * @throws KarteIn 
	 */
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
	}

	/**
	 * Die Methode gleicht die Eingabe des Pins mit dem Pin des gerade
	 * verwendeten Accounts ab.
	 * Bei korrekter Eingabe wechselt der Zustand des Geldautomaten in PIN_CORRECT. 
	 * Bei Falscheingabe in PIN_WRONG. 
	 * Der Status des Automaten soll auf der Konsole protokolliert werden
	 * Im Zustand PIN_WRONG, ist das Ausfuhren von weiteren Methoden nicht moglich. 
	 * Beachten Sie, dass Geld nur noch abgehoben werden kann, wenn der Pin korrekt ist.
	 * 
	 * @param pinX
	 * @throws PinFalsch
	 * @throws KarteAus
	 */
	public void pinEingeben(int pinX) throws PinFalsch, KarteAus {
		switch (state) {
		case CARD_INSERTED:
			//TODO wir brauchen hier kommentare > wozu
			// Maybe the new for loop
			for (int i = 0; i < accounts.length; i++) {
			// for (int acc : accounts ) { will not work
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
				// TODO hier muss noch statepin> wrong gewechselt sein
				statePIN = State.PIN_WRONG;
				throw new PinFalsch();
			} // end of if-else

			break;
		default:
			throw new KarteAus();

		} // switch Ende

	}
	
	/**
	 * 
	 * Das Abheben kann nur erfolgen wenn der Geldautomat im Zustand CARD_INSERTED ist. 
	 * Der angegebene Betrag kann vom Konto abgehoben werden, solange es den Dispokredit nicht uberschreitet.
	 * Außerdem muss das Kontoguthaben neu berechnet und auf der Konsole ausgegeben werden.
	 * 
	 * @param amount
	 * @throws PinFalsch
	 * @throws KarteAus
	 * @throws NIchtGenugGeld
	 * 
	 */
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
					// TODO: nicht genug depostit-geld 
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
	}
	
	/**
	 * Ausgabe der aktuellen Kontoinformationen auf der Konsole, nur moglich im Zustand CARD_INSERTED.
	 * Die Methode accountStatement() kann auch im Zustand PIN_CORRECT ausgefuhrt werden.
	 * 
	 * @throws PinFalsch
	 * @throws KarteAus
	 */	
	public void accountStatement() throws PinFalsch, KarteAus {
		switch (state) {
			// TODO und was z.B case inserted: case pinCoorect
		case CARD_INSERTED:
			switch (statePIN) {
			case PIN_CORRECT:
				// automatisch klarer
				System.out.println("\n" + "Account Statement: " + "\n" 
						+ "Account Nr.: " + accounts[zaehler].getAccountNumber() + "\n"
						+ "Bank Deposit: " + accounts[zaehler].getBankDeposit()	+ "\n" 
						+ "Overdraft: " + accounts[zaehler].getOverdraft());
				break;
			default:
				throw new PinFalsch();
			}

			break;
		default:
			throw new KarteAus();

		} // switch
	} 
	
	/**
	 * 
	 * Der Geldautomat wird auf den Status READY gesetzt, das Attribute cashCard wird zur Nullreferenz.
	 * Das ist nur moglich im Zustand CARD_INSERTED.
	 * Der Status des Automaten soll auf der Konsole protokolliert werden.
	 * Die Methode ejectCashCard() kann auch im Zustand PIN_CORRECT ausgefuhrt werden.
	 * 
	 * @throws KarteAus
	 * 
	 */
	public void ejectCashCard() throws KarteAus {
		switch (state) {
		case CARD_INSERTED:
			switch (statePIN) {
			case PIN_CORRECT:
				cashCard = null;
				state = State.READY;
				System.out.println("Ihr Karte ist entfenrt!");
				System.out.println("Automat ist auf Status " + state + " gesetzt.");
				break;
			}
			break;
		default:
			throw new KarteAus();
		} // Switch State Ende
	} 
}
