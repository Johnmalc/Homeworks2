package de.university.aufgabe4.main;

import de.university.aufgabe4.exc.*;

/** 
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */

public class CashMachine<K> {

	List<Account> accounts;
	private CashCard cashCard;
	private State state;
	private int zaehler;

	public CashMachine() {
		zaehler = 0;
		state = State.READY;
		// neu accounty erstellt.
		accounts = new List<Account>();
		accounts.insertFirst(new Account(12345678, 0.0, 5000, 0555));
		accounts.add(new Account(23456789, -100.0, 200, 2345)); //Verwendung der Klasse Account
		accounts.add(new Account(34567890, -200.0, 300, 3456));
	}

	/**
	 * 
	 * Nur im Zustand READY konnen die Informationen der eingegebenen Cashcard
	 * im Attribute cashCard abgespeichert werden. Bei erfolgreicher Eingabe
	 * wechselt der Zustand von READY auf CARD_INSERTED. Der Status des
	 * Automaten soll auf der Konsole protokolliert werden.
	 * 
	 * @param cashCardX
	 * @throws InvalidCardException
	 * @throws CardInsertedException
	 */
	public void insertCashCard(CashCard cashCardX) throws CardInsertedException, InvalidCardException {
		switch (state) {
		case READY:
			cashCard = cashCardX;
			state = State.CARD_INSERTED;
			/*
			 *  Sucht die passende Konto nach AccountNummer
			 *  muss man andern wegen Iterable > alte for loop
			 */
			for (int i =0 ; i<accounts.size();i++) {
				if ((accounts.get(i).getAccountNumber()) == (cashCard.getAccountNumber())) {
					/*
					 *  wenn account nummer und carten-account nummer entspricht > 
					 *  speichere index, damit man weiter mit dem richtigen 
					 *  (passenden) Account arbeiten kann
					 */
					this.zaehler = i;
					break;
				} else {
					zaehler++;
					if (zaehler >= accounts.size()) {
						state=State.READY;
							throw new InvalidCardException();
			  		}
				}
			}
			System.out.println("Automat ist auf Status " + state + " gesetzt.");
			break;
		default:
			throw new CardInsertedException();
		} // switch Ende
	}

	/**
	 * Die Methode gleicht die Eingabe des Pins mit dem Pin des gerade
	 * verwendeten Accounts ab. Bei korrekter Eingabe wechselt der Zustand des
	 * Geldautomaten in PIN_CORRECT. Bei Falscheingabe in PIN_WRONG. Der Status
	 * des Automaten soll auf der Konsole protokolliert werden Im Zustand
	 * PIN_WRONG, ist das Ausfuhren von weiteren Methoden nicht moglich.
	 * Beachten Sie, dass Geld nur noch abgehoben werden kann, wenn der Pin
	 * korrekt ist.
	 * 
	 * @param pinX
	 * @throws PinNotCorectException
	 * @throws CardNotInsertedException
	 * @throws InvalidCardException
	 */
	public void pinEingeben(int pinX) throws PinNotCorectException,
			CardNotInsertedException, InvalidCardException {
		switch (state) {
			case CARD_INSERTED :

				if (accounts.get(zaehler).getPin() == pinX) {
					state = State.PIN_CORRECT;
					System.out.println("Sie haben den richtigen Pin eingegeben.");
					System.out.println("Automat ist auf Status " + state + " gesetzt.");
				} else {
					throw new PinNotCorectException();
				} // end of if-else
				break;
			default :
				throw new CardNotInsertedException();
		} // end switch
	}

	/**
	 * 
	 * Das Abheben kann nur erfolgen wenn der Geldautomat im Zustand
	 * CARD_INSERTED ist. Der angegebene Betrag kann vom Konto abgehoben werden,
	 * solange es den Dispokredit nicht uberschreitet. Ausserdem muss das
	 * Kontoguthaben neu berechnet und auf der Konsole ausgegeben werden.
	 * 
	 * @param amount
	 * @throws PinNotCorectException
	 * @throws NotEnoughMoneyException
	 */
	public void withdraw(double amount) throws PinNotCorectException, NotEnoughMoneyException {
		switch (state) {
		case PIN_CORRECT:
			System.out.println("Ihr Kontoguthaben ist: " + accounts.get(zaehler).getBankDeposit() + " Euro.");
			if (accounts.get(zaehler).getBankDeposit() - amount >= accounts.get(zaehler).getOverdraft()) {
				accounts.get(zaehler).setBankDeposit(accounts.get(zaehler).getBankDeposit() - amount);
				System.out.println("Sie haben erfolgreich " + amount + " Euro abgehoben.");
				System.out.println("Ihr Kontoguthaben ist: " + accounts.get(zaehler).getBankDeposit() + " Euro.");
			} else {
				throw new NotEnoughMoneyException();
			}
			break;
		default:
			throw new PinNotCorectException();
		} // switch State Ende
	}

	/**
	 * Ausgabe der aktuellen Kontoinformationen auf der Konsole, nur moglich im
	 * Zustand CARD_INSERTED. Die Methode accountStatement() kann auch im
	 * Zustand PIN_CORRECT ausgefuhrt werden.
	 * 
	 * @throws CardNotInsertedException
	 */
	public void accountStatement() throws CardNotInsertedException {
		// prueft ob genug Geld ist
		if (state == State.CARD_INSERTED || state == State.PIN_CORRECT) {
			System.out.println("\n" + 
					"Account Statement: " + "\n" + 
					"Account Nr.: " + accounts.get(zaehler).getAccountNumber() + "\n" + 
					"Bank Deposit: " + accounts.get(zaehler).getBankDeposit() + "\n" + 
					"Overdraft: " + accounts.get(zaehler).getOverdraft());
		} else {
			throw new CardNotInsertedException();
		}
	}

	/**
	 * 
	 * Der Geldautomat wird auf den Status READY gesetzt, das Attribute cashCard
	 * wird zur Nullreferenz. Das ist nur moglich im Zustand CARD_INSERTED. Der
	 * Status des Automaten soll auf der Konsole protokolliert werden. Die
	 * Methode ejectCashCard() kann auch im Zustand PIN_CORRECT ausgefuhrt
	 * werden.
	 * 
	 * @throws CardNotInsertedException
	 * 
	 */
	public void ejectCashCard() throws CardNotInsertedException {
		if (state == State.CARD_INSERTED || state == State.PIN_CORRECT) {
			cashCard = null;
			zaehler = 0;
			state = State.READY;
			System.out.println("Ihr Karte ist entfenrt!");
			System.out.println("Automat ist auf Status " + state + " gesetzt.");
		} else {
			throw new CardNotInsertedException();
		} // If Ende
	}
}
