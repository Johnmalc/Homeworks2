package de.university.andereVersion.bjorn;

public class Account {
	public int accountNumber;
	public double overdraft;
	public double bankDeposit;
	public int pin;

	public Account() {
		accountNumber = 0;
		overdraft = 0.0;
		bankDeposit = 0.0;
		pin = 0;
	}

	// Get Methoden
	public int getAccountNumber() {
		return this.accountNumber;
	}

	public double getOverdraft() {
		return this.overdraft;
	}

	public double getBankDeposit() {
		return this.bankDeposit;
	}

	public int getPin() {
		return this.pin;
	}

	// Set Methoden
	public void setAccountNumber(int newAccountNumber) {
		this.accountNumber = newAccountNumber;
	}

	public void setOverdraft(double newOverdraft) {
		this.overdraft = newOverdraft;
	}

	public void setBankDeposit(double newBankDeposit) {
		this.bankDeposit = newBankDeposit;
	}

	public void setPin(int newPin) {
		this.pin = newPin;
	}
}
