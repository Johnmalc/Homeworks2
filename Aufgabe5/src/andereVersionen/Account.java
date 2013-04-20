package andereVersionen;

public class Account {

	private int accountNumber;
	private float overdraft; // Dispokredit des Kontos
	private float bankDeposit; // die Hohe des Kontoguthabens
	private int pin = 1234;

	public Account(int accNumber, float dispo, float guthaben) {
		accountNumber = accNumber;
		overdraft = dispo;
		bankDeposit = guthaben;

	}

	public float getoverdraft() {
		return overdraft;

	}

	public float getbankDeposit() {
		return bankDeposit;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setOverdraft(float dispo) {
		this.overdraft = dispo;

	}
	public void setBankDeposit(double d) {
		this.bankDeposit = (float) d;

	}

	public int getPin() {
		return pin;
	}

	@Override
	public String toString() {
		return ("Accountnummer:" + this.accountNumber + "        Guthaben:  "
				+ this.bankDeposit + "       Dispo:" + this.overdraft);
	}
}
