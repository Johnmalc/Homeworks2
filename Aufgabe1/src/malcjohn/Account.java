package malcjohn;

public class Account {
	// attributes
	public int accountNumber;
	public double overdraft;
	public double bankDeposit;
	public int pin;

	// Constructor for this class
	public Account() {

	}

	// Methods for AccountNumber, BankDeposit, Overdraft and 
	// Pin Always both, set and get methods.
	
	/**
	 * Speicherung der Kontonummer
	 * 
	 * @param value
	 */
	public void setAccountNumber(int value) {
		this.accountNumber = value;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

	/**
	 * Dispokredit des Kontos
	 * 
	 * @param value2
	 */
	public void setOverdraft(double value2) {
		this.overdraft = value2;
	}

	public double getOverdraft() {
		return this.overdraft;
	}

	/**
	 * die Hohe des Kontoguthabens
	 * 
	 * @param value3
	 */
	public void setBankDeposit(double value3) {
		this.bankDeposit = value3;
	}

	public double getBankDeposit() {
		return this.bankDeposit;
	}
	/**
	 * Set pin for Account class
	 * @param value4
	 */
	public void setPin(int value4) {
		this.pin = value4;
	}

	public int getPin() {
		return this.pin;
	}

}
