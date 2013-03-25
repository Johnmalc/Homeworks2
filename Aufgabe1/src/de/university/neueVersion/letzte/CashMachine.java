package de.university.neueVersion.letzte;

import de.university.neueVersion.exceptions.CardInsertedException;
import de.university.neueVersion.exceptions.KarteAus;
import de.university.neueVersion.exceptions.PinFalsch;
import de.university.neueVersion.exceptions.NotEnoughMoneyException;

public class CashMachine {

	Account[] accounts;
	CashCard cashCard;
	State state;
	State statePIN;
	int zaehler; // fuer Arrays

	CashMachine() {
		accounts = new Account[4];
		zaehler = 0;
		state = State.READY;
		statePIN = State.PIN_WRONG;
	
	accounts[0]=new Account(12345678, -1000.0, 2000, 1234);;
	accounts[1]=new Account(23456789, -100.0, 200, 2345);;
    accounts[2]=new Account(34567890, -200.0, 300, 3456);
    accounts[3]=new Account(45678901, 0.0, 5000, 4562); 

	}
	 /**private CashCard cashCardA = new CashCard(12345678);
	private CashCard cashCardB = new CashCard(23456789);
	private CashCard cashCardC = new CashCard(55487565);
	private CashCard cashCardD = new CashCard(12000002);
	private CashCard currentCard = null; // inserted Card 
	*/
	

	public void insertCashCard(CashCard cashCardX) throws CardInsertedException { // Karteneingabe
	
		switch (state) {
		case READY: {
			cashCard = cashCardX;
			System.out.println(cashCard.getAccountNumber());// ZUM Pruefen
																// Anastasia
			//cashCard.setAccountNumber(cashCardX.getAccountNumber()); ZUM Pruefen LOESCHEN

			state = State.CARD_INSERTED;
			System.out.println(state);	}
			break;
		default:
			throw new CardInsertedException();

		} // switch Ende
	}// Karteneingabe Ende

	/**
	 * Die Methode gleicht die Eingabe des Pins mit dem Pin 
	 * des gerade verwendeten Accounts ab. 
	 * @param pinX
	 * @throws PinFalsch
	 * @throws KarteAus
	 */
	public void pinEingeben(int pinX) throws PinFalsch, KarteAus {
		switch (state) {
		case CARD_INSERTED: {
			for (int i=0; i<accounts.length; i++) {
				if ((accounts[i].getAccountNumber())==(cashCard.getAccountNumber())) {
				//System.out.println(accounts[i].getAccountNumber()+" "+i+" "+cashCard.getAccountNumber() );
				zaehler=i;
				i=accounts.length;
			}
			}
				
			if (accounts[zaehler].getPin() == pinX) 
			{
				statePIN = State.PIN_CORRECT;
				System.out.println(statePIN);
																	 
			} // end of if
			else {
				throw new PinFalsch();

			} // end of if-else

		}
			break;
		default:
			throw new KarteAus();

		} // switch Ende

	} // pinEingeben Ende

	public void withdraw(double amount)
			throws PinFalsch, KarteAus, NotEnoughMoneyException { // Abheben

		switch (state) {
		case CARD_INSERTED: {
			switch (statePIN) {
			case PIN_CORRECT:  {
				if (accounts[zaehler].getBankDeposit() > accounts[zaehler].getOverdraft() ) {
					accounts[zaehler].setBankDeposit(accounts[zaehler].getBankDeposit() - amount);
					System.out.println("Ihr Kontoguthaben ist: "
							+ accounts[zaehler].getBankDeposit());
				} else {
					throw new NotEnoughMoneyException();
				}

			}
				break;
			default:
				throw new PinFalsch();
			}

		}
			break;
		default:
			throw new KarteAus();

		} // switch State Ende
	}// Abheben Ende

	public void accountStatement() throws PinFalsch,
			KarteAus // Kontoinformationen
	{
		switch (state) {
		case CARD_INSERTED:
			switch (statePIN) {
			case PIN_CORRECT:
				System.out.println("Account Statement: " + "\n"
						+ "Account Nr.: " + accounts[zaehler].getAccountNumber() + "\n"
						+ "Bank Deposit: " + accounts[zaehler].getBankDeposit() + "\n"
						+ "Overdraft: " + accounts[zaehler].getOverdraft());
				break;
			default:
				throw new PinFalsch();
			}

			break;
		default:
			throw new KarteAus();

		} // switch
	} // Kontoinformationen Ende

	public void ejectCashCard(CashCard cashCardX)
			throws KarteAus // Kartenauswurf
	{
		switch (state) {
		case CARD_INSERTED:
			cashCard=null;
			state = State.READY;
			System.out.println("Ihr Karte ist entfenrt!"+"\n"+"Ready");

			break;
		default:
			throw new KarteAus();
		} // Switch State Ende
	} // Kartenauswurf Ende

}
