package de.university.reutlingen.aufgabe1;
/**
 * TODO
 * 
 * @author
 * @author
 */

public class CashCard {
	public int accountNumber;
	public int pin;

	// Constructor
	public CashCard() {

	}

	// Methods for account and pin (both set and get)
	public void setAccountNumber(int value) {
		this.accountNumber = value;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setPin(int value) {
		this.pin = value;
	}

	public int getPin() {
		return pin;
	}
}
