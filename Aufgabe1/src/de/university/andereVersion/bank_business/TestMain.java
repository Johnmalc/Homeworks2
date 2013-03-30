package de.university.andereVersion.bank_business;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		CashMachine bob = new CashMachine(10, CashMachine.State.READY);

		// Die zu verwaltenden Accounts
		bob.accounts[0] = new Account(123456, 500, 2000, 1244); // (Kontonummer,
																// Kreditlimit,
																// Guthaben,
																// PIN)
		bob.accounts[1] = new Account(123556, 500, 1000, 1254);
		bob.accounts[2] = new Account(125456, 500, 1000, 1264);
		bob.accounts[3] = new Account(123457, 500, 1000, 1274);
		bob.accounts[4] = new Account(123458, 500, 1000, 1284);
		bob.accounts[5] = new Account(123459, 500, 1000, 1294);
		bob.accounts[6] = new Account(123450, 500, 1000, 1294);
		bob.accounts[7] = new Account(123451, 500, 1000, 1204);
		bob.accounts[8] = new Account(123452, 500, 1000, 1224);
		bob.accounts[9] = new Account(123453, 500, 1000, 1254);

		CashCard card1 = new CashCard(123456);
		CashCard card2 = new CashCard(123132); // Karte mit unbekannter Nummer

		// TEST aller Methoden ohne Karte
		try {
			// bob.insertCashCard(card2);
			bob.insertCashCard(card1);
			bob.enterPin(1244);
			bob.withdraw(200);
			bob.accountStatement();
			bob.ejectCashCard();

		} catch (NoAccountException e) {
			System.out.println(e.getMessage());
		} catch (CardInsertedException e) {
			System.out.println(e.getMessage());
		} catch (NoCoverException e) {
			System.out.println(e.getMessage());
		} catch (WrongPinException e) {
			System.out.println(e.getMessage());
		} catch (NoPinException e) {
			System.out.println(e.getMessage());
		} catch (NoCardException e) {
			System.out.println(e.getMessage());
		}
	}
}
