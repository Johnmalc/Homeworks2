package malcjohn;

public class CashCard {
	public int accountNumber;
	public int pin;

	public CashCard(int accountNumberX, int pinX) {
		this.accountNumber = accountNumberX;
		this.pin = pinX;
	}

	public CashCard() {

	}

	// Methods
	public void setAccountNumber(int value) {
		this.accountNumber = value;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

}
