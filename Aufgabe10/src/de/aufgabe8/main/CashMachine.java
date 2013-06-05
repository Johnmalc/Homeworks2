package de.aufgabe8.main;

import java.util.*;
import de.aufgabe8.exc.*;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */
public class CashMachine<K> {

	Map<Integer, Account> map;
	private CashCard cashCard;
	private State state;
	private Integer key; //Nr des Accounts in der Map

	public CashMachine() {
		key = null;
		state = State.READY;

		map = new HashMap<Integer, Account>();
		// Erstellung der Accounts
		Account act1 = new Account(23456789, -100.0, 200, 1234);
		Account act2 = new Account(34567890, -200.0, 300, 2345);
		Account act3 = new Account(12345678, 0.0, 5000, 3456);
		// Speicherung der erstelleten Accounts in Map
		map.put(act1.getAccountNumber(), act1);
		map.put(act2.getAccountNumber(), act2);
		map.put(act3.getAccountNumber(), act3);
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
			/*
			 * Sucht die passende Konto nach AccountNummer
			 */
			if (map.containsKey(cashCard.getAccountNumber()) == true) {
				state = State.CARD_INSERTED;
				key = cashCard.getAccountNumber();
			} else {
				/*
				 * Gibt Exception, wenn die benoenigte Accountnummer nicht zu
				 * finden ist
				 */
				throw new InvalidCardException();
			}
			System.out.println("Automat ist auf Status " + state + " gesetzt.");
			break;
		default:
			throw new CardInsertedException();
		}
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
	public void pinEingeben(int pinX) throws PinNotCorectException, CardNotInsertedException, InvalidCardException {
		switch (state) {
		case CARD_INSERTED:
			if (map.get(key).getPin() == pinX) {
				state = State.PIN_CORRECT;
				System.out.println("Sie haben den richtigen Pin eingegeben.");
				System.out.println("Automat ist auf Status " + state
						+ " gesetzt.");
			} else {
				throw new PinNotCorectException();
			} // end of if-else
			break;
		default:
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
			System.out.println("Ihr Kontoguthaben ist: "
					+ map.get(key).getBankDeposit() + " Euro.");
			if (map.get(key).getBankDeposit() - amount >= map.get(key)
					.getOverdraft()) {
				map.get(key).setBankDeposit(
						map.get(key).getBankDeposit() - amount);
				System.out.println("Sie haben erfolgreich " + amount
						+ " Euro abgehoben.");
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
			System.out.println("\n" + "Account Statement: " + "\n"
					+ "Account Nr.: " + map.get(key).getAccountNumber()
					+ "\n" + "Bank Deposit: " + map.get(key).getBankDeposit()
					+ "\n" + "Overdraft: " + map.get(key).getOverdraft());
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
			key = 0;
			state = State.READY;
			System.out.println("Ihre Karte ist entfernt!");
			System.out.println("Automat ist auf Status " + state + " gesetzt.");
		} else {
			throw new CardNotInsertedException();
		} // If Ende
	}
}
