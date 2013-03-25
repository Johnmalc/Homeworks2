package de.university.andereVersion.bjorn;

public class Main {
	public static void main(String[] args) {

		CashMachine automat = new CashMachine();
		CashCard karte = new CashCard();

		karte.setAccountNumber(20012);
		automat.aSechs.setAccountNumber(20012);
		automat.aSechs.setBankDeposit(5000);
		automat.aSechs.setOverdraft(2000);

		automat.insertCashCard(karte);
		automat.accountStatement();
		automat.withdraw(322.44);
		automat.accountStatement();
		automat.ejectCashCard();

	}
}