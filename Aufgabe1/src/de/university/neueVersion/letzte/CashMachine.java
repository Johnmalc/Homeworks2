package de.university.neueVersion.letzte;

public class CashMachine {

	State state;
	State statePIN;
	int zaehler;

	CashMachine() {
		accounts = new Account[100];
		zaehler = 0;
		state = State.READY;
		statePIN = State.PIN_WRONG;
	}

	private Account[] accounts = new Account[] {
			new Account(12345678, -1000.0, 2000, 1234),
			new Account(23456789, -100.0, 200, 2345),
			new Account(34567890, -200.0, 300, 3456),
			new Account(45678901, 0.0, 5000, 456), }; // Arrays von Accounts
														// wurde ausgefüllt

	private CashCard cashCardA = new CashCard(12345678);
	private CashCard cashCardB = new CashCard(90874561);
	private CashCard cashCardC = new CashCard(55487565);
	private CashCard cashCardD = new CashCard(12000002);
	private CashCard currentCard = null; // inserted Card

	public void insertCashCard(CashCard cashCardX) throws CardInsertedException// Karteneingabe
	{
		switch (state) {
		case READY: {
			currentCard = cashCardX;
			System.out.println(currentCard.getAccountNumber());// ZUM Prüfen
																// Anastasia
			// cashCard.setAccountNumber(cashCardX.getAccountNumber());

			state = State.CARD_INSERTED;
			System.out.println(state);

		}
			break;
		default:
			throw new CardInsertedException();

		} // switch Ende
	}// Karteneingabe Ende

	public void pinEingeben(Account accountX, int pinX)
			throws PinWrongException, CardNotInsertedException {
		switch (state) {
		case CARD_INSERTED: {
			if (accountX.getPin() == pinX) // Pin sollte fr�her in main mit der
											// Hilfe von setPin methode
											// geschpeichert werden
			{
				statePIN = State.PIN_CORRECT;
				accounts[zaehler] = accountX;
				System.out.println(accounts[zaehler].getBankDeposit());// zum
																		// Testen
				zaehler++;
			} // end of if
			else {
				throw new PinWrongException();

			} // end of if-else

		}
			break;
		default:
			throw new CardNotInsertedException();

		} // switch Ende

	}

	public void withdraw(Account accountX, double amount)
			throws PinWrongException, CardNotInsertedException,
			NotEnoughMoneyException // Abheben
	{

		switch (state) {
		case CARD_INSERTED: {
			switch (statePIN) {
			case PIN_CORRECT:  {
				if (accountX.bankDeposit > accountX.overdraft) {
					accountX.bankDeposit = accountX.bankDeposit - amount;
					System.out.println("Ihr Kontoguthaben ist: "
							+ accountX.getBankDeposit());
				} else {
					throw new NotEnoughMoneyException();
				}

			}
				break;
			default:
				throw new PinWrongException();
			}

		}
			break;
		default:
			throw new CardNotInsertedException();

		} // switch State Ende
	}// Abheben Ende

	public void accountStatement(Account accountX) throws PinWrongException,
			CardNotInsertedException // Kontoinformationen
	{
		switch (state) {
		case CARD_INSERTED:
			switch (statePIN) {
			case PIN_CORRECT:
				System.out.println("Account Statement: " + "\n"
						+ "Account Nr.: " + accountX.getAccountNumber() + "\n"
						+ "Bank Deposit: " + accountX.getBankDeposit() + "\n"
						+ "Overdraft: " + accountX.getOverdraft());
				break;
			default:
				throw new PinWrongException();
			}

			break;
		default:
			throw new CardNotInsertedException();

		} // switch
	} // Kontoinformationen Ende

	public void ejectCashCard(CashCard cashCardX)
			throws CardNotInsertedException // Kartenauswurf
	{
		switch (state) {
		case CARD_INSERTED:
			state = State.READY;
			System.out.println("Ready");

			break;
		default:
			throw new CardNotInsertedException();
		} // Switch State Ende
	} // Kartenauswurf Ende

}
