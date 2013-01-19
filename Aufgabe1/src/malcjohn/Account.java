package malcjohn;

public class Account {
	/*******************************************
	 * 
	 * Attributes
	 * 
	 * 
	 *******************************************/
	private int accountNumber;
	private double overdraft;
	private double bankDeposit;
	private int pin;
	
	/*
	 * Constructor for this class
	 */
	public Account (){
		
	}
	/*******************************************
	 * 
	 * Methods for AccountNumber,BankDeposit,Overdraft and Pin
	 * Always both, set and get methods.
	 * 
	 * 
	 *******************************************/
	

	public void setAccountNumber(int value) {
		this.accountNumber = value;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

	public void setOverdraft(double value) {
		this.overdraft = value;
	}

	public double getOverdraft() {
		return this.overdraft;
	}

	public void setBankDeposit(double value) {
		this.bankDeposit = value;
	}

	public double getBankDeposit() {
		return this.bankDeposit;
	}

	public void setPin(int value) {
		this.pin = value;
	}

	public int getPin() {
		return this.pin;
	}

}
