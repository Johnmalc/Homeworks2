package bjorn;

public class CashMachine {
	public enum Zustand {
		READY, CARD_INSERTED;
	}

	Zustand eins;
	// Account[] accounts = new Account[10];
	// CashCard[] cashCard = new CashCard[10];
	CashCard cashCard = new CashCard();
	public String status;
	Account aEins = new Account();
	Account aZwei = new Account();
	Account aDrei = new Account();
	Account aVier = new Account();
	Account aFuenf = new Account();
	Account aSechs = new Account();
	Account aSieben = new Account();
	Account aAcht = new Account();
	Account aNeun = new Account();
	Account aZehn = new Account();
	Account inBearbeitung = new Account();

	Account[] accounts = { aEins, aZwei, aDrei, aVier, aFuenf, aSechs, aSieben,
			aAcht, aNeun, aZehn };

	public CashMachine() {
		this.eins = eins.READY;
		status = "READY";
	}

	public void insertCashCard(CashCard cashCarde) {
		if (eins == eins.READY) {
			eins = eins.CARD_INSERTED;
			status = "CARD INSERTED";
			System.out.println("Status : " + status);
			System.out.println("Willkommen");
			cashCard = cashCarde;

			for (int i = 0; i < accounts.length; i++) {
				if (cashCard.getAccountNumber() == accounts[i]
						.getAccountNumber()) {
					inBearbeitung = accounts[i];

				} // end of if

			} // end of for

		}

		else {
			System.out.println("Kartenfehler! Automat nicht bereit");

		}
	}

	public void withdraw(double amount) {
		if (eins == eins.CARD_INSERTED) {
			if (amount <= inBearbeitung.getOverdraft()) {
				inBearbeitung.bankDeposit = (inBearbeitung.bankDeposit - amount);
				System.out.println("Ihr Neuer Kontostand betraegt : "
						+ inBearbeitung.getBankDeposit() + " EUR");

			}

			else {
				System.out
						.println("Der Angeforderte Betrag ueberschreitet ihr Dispolimit! Keine Auszahlung moeglich");

			} // end of if-else

		}
	}

	public void accountStatement() {
		if (eins == eins.CARD_INSERTED) {
			System.out.println("Ihre Aktuellen Kontodaten lauten : ");
			System.out.println();
			System.out.println("Kontonummer  : "
					+ inBearbeitung.getAccountNumber());
			System.out.println("Kontostand   : "
					+ inBearbeitung.getBankDeposit());
			System.out
					.println("Dispokredit  : " + inBearbeitung.getOverdraft());
		}
	}

	public void ejectCashCard() {
		if (eins == eins.CARD_INSERTED) {
			cashCard = null;
		}

		eins = eins.READY;
		status = "READY";
		System.out.println("Status : " + status);
		System.out.println("Auf Widersehen");

	}

}