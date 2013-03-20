package de.university.reutlingen.aufgabe1;

public class Account {
	public int accountNumber;
	public double overdraft;
	public double bankDeposit;
	public int pin;

	// Constructor for this class
	public Account() {

	}

	/**
	 * Speicherung der Kontonummer
	 * 
	 * @param value
	 *            accountNumber
	 */
	public void setAccountNumber(int value) {
		this.accountNumber = value;
	}
	/**
	 * 
	 * @return accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Dispokredit des Kontos
	 * 
	 * @param value2
	 *            overdraft
	 */
	public void setOverdraft(double value2) {
		this.overdraft = value2;
	}
	/**
	 * 
	 * @return overdraft
	 */
	public double getOverdraft() {
		return overdraft;
	}

	/**
	 * die Hohe des Kontoguthabens
	 * 
	 * @param value3
	 *            bankDeposit
	 */
	public void setBankDeposit(double value3) {
		this.bankDeposit = value3;
	}
	/**
	 * @return bankDeposit
	 */
	public double getBankDeposit() {
		return bankDeposit;
	}

	/**
	 * Set pin for Account class Abgleicht auch ob der eingegebene Pin 4 stellig
	 * ist Taken from:
	 * http://stackoverflow.com/questions/1306727/way-to-get-number
	 * -of-digits-in-an-int
	 * 
	 * @param value4
	 *            PIN
	 */
	public void setPin(int value4) {
		int length = String.valueOf(value4).length();
		if (length == 4) {
			// dann speichere mir das
			this.pin = value4;
		} else {

			System.out.println("Sie mussen nur 4 stellige nummer eingeben");
			System.exit(0);
			// bricht ab jetzt (fehlermeldung is oben geschrieben)
		}
	}
	/**
	 * 
	 * @return pin
	 */
	public int getPin() {
		return pin;
	}
}
