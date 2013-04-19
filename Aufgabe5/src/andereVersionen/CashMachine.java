package andereVersionen;

public class CashMachine<K> {

	List<Account> test;
	State zustand = State.READY;
	CashCard cashcard;
	private int i;

	/**/
	// public CashMachine(int kontonummer, double dispo, double guthaben,int
	// geheimzahl) {
	public CashMachine(List<Account> test) {
		this.test = test;
		/**/
		// for (int i = 0; i < accounts.length; i++) {
		// accounts[i] = new Account(kontonummer, dispo, guthaben, geheimzahl);
		// }
	}

	public void insertCashCard(CashCard cashCard) {

		try {
			if (zustand == State.CARD_INSERTED || zustand == State.PIN_WRONG
					|| zustand == State.PIN_CORRECT) {
				throw new MyException(
						"Achtung!!! Es ist ein Fehler aufgetreten. Bitte versuchen Sie es erneut");
			} else if (zustand.equals(State.READY)) {
				for (int j = 0; j < test.size(); j++) {
					if (test.get(j).getAccountNumber() == cashCard
							.getAccountNumber())
						this.i = j;

				}
				this.zustand = State.CARD_INSERTED;
				System.out.println(zustand + " :");
			}
		} catch (MyException e) {
			System.out.println(e.getMessage());
		}

	}

	public void enterPin(int pin) {
		try {
			if (zustand.equals(State.PIN_WRONG)) {
				throw new MyException("Pin ist falsch");
			}
			if (test.get(i).getPin() == pin) {
				zustand = State.PIN_CORRECT;
				System.out.println(zustand);
			} else {
				zustand = State.PIN_WRONG;
				throw new MyException(
						"Die Eingabe Ihrer Geheimzahl war nicht erfolgreich, bitte geben Sie Ihre Geheimzahl erneut ein.");
			}

		} catch (MyException msg) {
			System.out.println(msg.getMessage());
		}
	}

	/**/
	public void withdraw(double amount) {
		if (zustand.equals(State.PIN_CORRECT)) {
			if ((test.get(i).getbankDeposit() + test.get(i).getoverdraft()) < amount) {
				System.out
						.println("Ihr Guthaben reicht mit dem Dispo nicht aus!");
			}

			if ((test.get(i).getbankDeposit() + test.get(i).getoverdraft()) >= amount) {
				test.get(i).setBankDeposit(
						(test.get(i).getbankDeposit()) - amount);

				// Konto um Betrag verringern
				System.out.println("Ihr momentaner Kontostand beträgt:\t"
						+ test.get(i).getbankDeposit());
			}
		}
	}
	public void accountStatement() { // Will Enum Statement
		if (zustand.equals(State.PIN_CORRECT)) { // Wenn
													// CardInserted,
													// dann Ausgabe
													// neuer
													// Kontostand
			System.out.println("Ihr aktuelle Guthaben betregt "
					+ test.get(i).getbankDeposit());

		}
	}

	public void ejectCashCard() { // Kartenauswurf
		if (zustand.equals(State.CARD_INSERTED)
				|| zustand.equals(State.PIN_CORRECT)) { // Vergleich Zustand
			zustand = State.READY; // Wenn Zustand CARD_INSERTED,umschalten auf
									// READY
			System.out.println(" " + zustand + " :");
		}
	}

}
