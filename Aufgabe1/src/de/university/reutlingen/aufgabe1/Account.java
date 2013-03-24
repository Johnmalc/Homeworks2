package de.university.reutlingen.aufgabe1;

/**
 * TODO
 * 
 * @author
 * @author
 */

public class Account extends Karte {
	public static int accountNumber;
	public static double overdraft;
	public static double bankDeposit;
	public static int pin;
	public int positionOfAccount;

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
		Account.accountNumber = value;
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
		Account.overdraft = value2;
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
		Account.bankDeposit = value3;
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
			Account.pin = value4;
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
	/**
	 * 
	 * @param value5
	 * 			positionOfAccount
	 */
	public void setAccountPossition(int value5) {
		this.positionOfAccount = value5;
	}
	/**
	 * 
	 * @return positionOfAccount
	 */
	public int getAccountPosstion() {
		return positionOfAccount;
	}
}
