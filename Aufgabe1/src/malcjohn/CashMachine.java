package malcjohn;

public class CashMachine {
	private CashCard cashCard;
	public Account[] accounts;

	public void setCashCard(CashCard value) {
		this.cashCard = value;
	}

	public CashCard getCashCard() {
		return this.cashCard;
	}

	public void setAccounts(Account[] value) {
		this.accounts = value;
	}

	public Account[] getAccounts() {
		return this.accounts;
	}

	public void insertCashCard(CashCard cashCard) {
		throw new UnsupportedOperationException("not implemented");
	}

	public void withdraw(double amount) {
		throw new UnsupportedOperationException("not implemented");
	}

	public void accountStatement() {
		throw new UnsupportedOperationException("not implemented");
	}

	public void ejectCashCard() {
		throw new UnsupportedOperationException("not implemented");
	}

	public void enterPin(int pin) {
		throw new UnsupportedOperationException("not implemented");
	}

}
