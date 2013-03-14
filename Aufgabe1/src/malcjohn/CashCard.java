package malcjohn;

public class CashCard {
	public CashCard() {
		// TODO Auto-generated constructor stub
	}

	// attributes
	private int accountNumber;

	// constructor
//	public CashCard(int accountNumberX) {
//		this.accountNumber = accountNumberX;
//	}

    // Methods
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
