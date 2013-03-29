package de.university.andereVersion.bank_business;

public class CashMachine {

	Account temp;
	Account accounts[];
	CashCard cashCard;

	public enum State {
		READY, CARD_INSERTED, PIN_CORRECT, PIN_WRONG
	}

	State state;

	// -- METHODEN --

	// KONSTRUKTOR

	public CashMachine(int anzahl, State statex) {
		accounts = new Account[anzahl];
		this.state = statex;
	}

	// KARTENEINGABE

	public void insertCashCard(CashCard cashCardx) throws NoAccountException,
			CardInsertedException {
		switch (state) {
		case READY:
			state = State.CARD_INSERTED;
			cashCard = cashCardx;

			for (Account acc : accounts) {
				if (acc.getaccountNumber() == cashCardx.getaccountNumber()) {
					temp = acc;
					System.out.println("Karte akzeptiert! Kartennummer: "
							+ cashCard.getaccountNumber() + "\n");
					break;
				} else
					throw new NoAccountException();
			}
			break;

		case CARD_INSERTED:
		case PIN_WRONG:
		case PIN_CORRECT:
			throw new CardInsertedException();
		}
	}

	// EINGABE / PRUEFUNG DES PIN

	public void enterPin(int pinx) throws NoCardException, WrongPinException {
		switch (state) {
		case READY:
			throw new NoCardException();

		case CARD_INSERTED:
		case PIN_CORRECT:
		case PIN_WRONG:
			if (temp.getpin() == pinx) {
				state = State.PIN_CORRECT;
				System.out.println("PIN korrekt. Fahre fort.");
			} else {
				state = State.PIN_WRONG;
				throw new WrongPinException();
			}
		}
	}

	// ABHEBEN

	public void withdraw(double amount) throws NoCardException, NoPinException,
			WrongPinException, NoCoverException {
		switch (state) {
		case READY:
			throw new NoCardException();
		case CARD_INSERTED:
			throw new NoPinException();
		case PIN_WRONG:
			throw new WrongPinException();
		case PIN_CORRECT:
			if (temp.getbankDeposit() + temp.getoverdraft() >= amount) {
				temp.setbankDeposit(temp.getbankDeposit() - amount);
				System.out.println("Neuer Betrag: " + temp.getbankDeposit()
						+ " €.");
			} else {
				throw new NoCoverException();
			}
			break;
		}
	}

	// KONTOAUSZUG ANFORDERN

	public void accountStatement() throws NoCardException, WrongPinException,
			NoPinException {
		switch (state) {
		case READY:
			throw new NoCardException();
		case PIN_WRONG:
			throw new WrongPinException();
		case CARD_INSERTED:
			throw new NoPinException();
		case PIN_CORRECT:
			System.out.println("KONTOINFORMATION:");
			System.out.println("Kartennummer: \t" + temp.getaccountNumber());
			System.out.println("Guthaben: \t"
					+ String.format("%,.2f €.", temp.getbankDeposit()));
			System.out.println("Kreditgrenze: \t"
					+ String.format("%,.2f €.", temp.getoverdraft()));
			break;
		}
	}

	// KARTENAUSGABE

	public void ejectCashCard() throws NoCardException {
		switch (state) {
		case READY:
			throw new NoCardException();
		case CARD_INSERTED:
		case PIN_WRONG:
		case PIN_CORRECT:
			state = State.READY;
			for (Account acc : accounts) {
				if (acc.getaccountNumber() == temp.getaccountNumber()) {
					acc = temp;
				}
			}
			System.out.println("Danke fur Ihren Besuch!");
			cashCard = null;
			break;
		}
	}
}
