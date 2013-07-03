package de.d.main;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */

public class CashCard {
	private int accountNumber;

	// Constructor
	public CashCard(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	// Methods for account (set and get)
	public void setAccountNumber(int value) {
		this.accountNumber = value;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
}
