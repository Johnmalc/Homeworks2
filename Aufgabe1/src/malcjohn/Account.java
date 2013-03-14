package malcjohn;

public class Account {
	public static int accountNumber;
	public static double overdraft;
	public static double bankDeposit;
	public static int pin;

	// Constructor for this class
	public Account(int accountNumberX, double bankDepostiX, int pinX) {
		Account.accountNumber = accountNumberX;
		Account.bankDeposit = bankDepostiX;
		Account.pin = pinX;
	}

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
		Account.accountNumber = value;
	}

	public int getAccountNumber() {
		return Account.accountNumber;
	}

	/**
	 * Dispokredit des Kontos
	 * 
	 * @param value2
	 */
	public void setOverdraft(double value2) {
		Account.overdraft = value2;
	}

	public double getOverdraft() {
		return Account.overdraft;
	}

	/**
	 * die Hohe des Kontoguthabens
	 * 
	 * @param value3
	 */
	public void setBankDeposit(double value3) {
		Account.bankDeposit = value3;
	}

	public double getBankDeposit() {
		return Account.bankDeposit;
	}

	/**
	 * Set pin for Account class
	 * 
	 * @param value4
	 */
	public void setPin(int value4) {
		Account.pin = value4;
	}

	public int getPin() {
		return Account.pin;
	}
}
