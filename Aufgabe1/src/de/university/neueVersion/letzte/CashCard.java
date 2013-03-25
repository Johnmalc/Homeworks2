package de.university.neueVersion.letzte;

/**
 * TODO
 * 
 * @author An
 * @author
 */

public class CashCard {
	public int accountNumber;
	public int pin; // BRAUCHEN WIR DEN HIER?

	// Constructor
	public CashCard(int accountNumber) {
		this.accountNumber = accountNumber;
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
