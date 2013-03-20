package de.university.reutlingen.aufgabe1;

public class CashCard {
	public int accountNumber;
	public int pin;

	public CashCard() {
		
	}

	// Methods
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
