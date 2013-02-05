package malcjohn;

public class CashCard extends Account {
	/**********************
	 * 
	 * Attribute
	 * 
	 **********************/
	public int accountNumber;

	/**********************
	 * 
	 * Constructor
	 * 
	 **********************/
	public CashCard(int accountNumberX) {
		this.accountNumber = accountNumberX;
	}

	/**********************
	 * 
	 * Methods
	 * 
	 **********************/
	public void setAccountNumber(int value) {
		this.accountNumber = value;
	}

	public int getAccountNumber() {
		return this.accountNumber;
	}

	public CashCard toString2() {
		return this;
	}

}
