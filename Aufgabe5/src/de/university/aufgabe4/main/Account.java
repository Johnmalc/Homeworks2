package de.university.aufgabe4.main;

import de.university.aufgabe4.exc.*;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */

public class Account {
	private int accountNumber;
	private double overdraft;
	private double bankDeposit;
	private int pin;

	/**
	 * Dieser Konstruktor bittet uns schnelle Erstellung von accounts
	 * 
	 * @param accountNumber
	 * @param overdraft
	 * @param bankDeposit
	 * @param pin
	 */

	public Account(int accountNumber, double overdraft, double bankDeposit,
			int pin) {
		this.accountNumber = accountNumber;
		this.overdraft = overdraft;
		this.bankDeposit = bankDeposit;
		this.pin = pin;

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
	 * Taken from: http://stackoverflow.com/questions/1306727/way-to-get-number
	 * -of-digits-in-an-int 
	 * After teachers recommendation I have added an
	 * (another) Exception. Now he will like it !!!
	 * 
	 * @param value4
	 *            PIN
	 * @throws WrongQuantityOfDigits
	 */
	public void setPin(int value4) throws WrongQuantityOfDigits {
		// wenn die lange der value4 gleich 4 ist
		int length = String.valueOf(value4).length();
		if (length == 4) {
			// dann speichere mir das
			this.pin = value4;
		} else {
			throw new WrongQuantityOfDigits();
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
