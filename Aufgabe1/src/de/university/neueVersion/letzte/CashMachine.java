package de.university.neueVersion.letzte;

import de.university.neueVersion.exceptions.*;


public class CashMachine {

	Account[] accounts;
	CashCard cashCard;
	State state;
	int zaehler; // fuer Arrays

	public CashMachine() {
		accounts = new Account[4];
		zaehler = 0;
		state = State.READY;
		
		// hier wurden die accounts gescpeichert
		accounts[0] = new Account(12345678, 0.0, 2000, 1234);
		accounts[1] = new Account(23456789, -100.0, 200, 2345);
		accounts[2] = new Account(34567890, -200.0, 300, 3456);
		accounts[3] = new Account(45678901, 0.0, 5000, 4567);
	}
	/**
	 * 
	 * Nur im Zustand READY können die Informationen der eingegebenen
	 * Cashcard im Attribute cashCard abgespeichert werden.
	 * Bei erfolgreicher Eingabe wechselt der Zustand von READY auf CARD_INSERTED. 
	 * Der Status des Automaten soll auf der Konsole protokolliert werden.
	 * 
	 * @param cashCardX
	 * @throws  
	 * @throws KarteIn 
	 */
	public void insertCashCard(CashCard cashCardX) throws CardInsertedException, InvalidCardException {

		switch (state) {
		case READY:
			cashCard = cashCardX;
			state = State.CARD_INSERTED;
			//Sucht die passende Konto nach AccountNummer
			for (Account test : accounts ) {
						if ((test.getAccountNumber()) == (cashCard.getAccountNumber())) {
							break;	
						} //if Ende
						else{
							zaehler++;
							if (zaehler>= accounts.length){ 
								try{ ejectCashCard();} 
								finally {throw new InvalidCardException();
							}//finally Ende
							}//if Ende	
						}//else ende
						
					} // for Ende
					
			System.out.println("Automat ist auf Status " + state + " gesetzt.");

			break;
		default:
			throw new CardInsertedException();

		} // switch Ende
	}

	/**
	 * Die Methode gleicht die Eingabe des Pins mit dem Pin des gerade
	 * verwendeten Accounts ab.
	 * Bei korrekter Eingabe wechselt der Zustand des Geldautomaten in PIN_CORRECT. 
	 * Bei Falscheingabe in PIN_WRONG. 
	 * Der Status des Automaten soll auf der Konsole protokolliert werden
	 * Im Zustand PIN_WRONG, ist das Ausfuhren von weiteren Methoden nicht moglich. 
	 * Beachten Sie, dass Geld nur noch abgehoben werden kann, wenn der Pin korrekt ist.
	 * 
	 * @param pinX
	 * @throws PinFalsch
	 * @throws KarteAus
	 */
	public void pinEingeben(int pinX) throws PinNotCorectException, CardNotInsertedException, InvalidCardException {
		switch (state) {
		case CARD_INSERTED:
			

			if (accounts[zaehler].getPin() == pinX) {
				state = State.PIN_CORRECT;
				System.out.println("Sie haben den richtigen Pin eingegeben.");
				System.out.println("Automat ist auf Status " + state
						+ " gesetzt.");
			} // end of if
			else {
				// TODO hier muss noch statepin> wrong gewechselt sein
			throw new PinNotCorectException();
			} // end of if-else

			break;
		default:
			System.out.println("hier");
			throw new CardNotInsertedException();

		} // switch Ende

	}
	
	/**
	 * 
	 * Das Abheben kann nur erfolgen wenn der Geldautomat im Zustand CARD_INSERTED ist. 
	 * Der angegebene Betrag kann vom Konto abgehoben werden, solange es den Dispokredit nicht uberschreitet.
	 * Außerdem muss das Kontoguthaben neu berechnet und auf der Konsole ausgegeben werden.
	 * 
	 * @param amount
	 * @throws PinFalsch
	 * @throws KarteAus
	 * @throws NIchtGenugGeld
	 * 
	 */
	public void withdraw(double amount) throws PinNotCorectException, NotEnoughMoneyException {
		switch (state) {
		case PIN_CORRECT:
			
				System.out.println("Ihr Kontoguthaben ist: "
						+ accounts[zaehler].getBankDeposit() + " Euro.");
				if (accounts[zaehler].getBankDeposit() - amount >= accounts[zaehler]
						.getOverdraft()) {
					accounts[zaehler].setBankDeposit(accounts[zaehler]
							.getBankDeposit() - amount);
					System.out.println("Sie haben erfolgreich " + amount
							+ " Euro abgehoben.");
					System.out.println("Ihr Kontoguthaben ist: "
							+ accounts[zaehler].getBankDeposit() + " Euro.");
				} else {
					// TODO: nicht genug depostit-geld 
					throw new NotEnoughMoneyException();
				}

				
			break;
		default:
			throw new PinNotCorectException();

		} // switch State Ende
	}
	
	/**
	 * Ausgabe der aktuellen Kontoinformationen auf der Konsole, nur moglich im Zustand CARD_INSERTED.
	 * Die Methode accountStatement() kann auch im Zustand PIN_CORRECT ausgefuhrt werden.
	 * 
	 * @throws PinFalsch
	 * @throws KarteAus
	 */	
	public void accountStatement() throws CardNotInsertedException {
		if  (state==State.CARD_INSERTED || state==State.PIN_CORRECT )
		{//prueft ob genug Geld ist
			System.out.println("\n" + "Account Statement: " + "\n" 
					+ "Account Nr.: " + accounts[zaehler].getAccountNumber() + "\n"
					+ "Bank Deposit: " + accounts[zaehler].getBankDeposit()	+ "\n" 
					+ "Overdraft: " + accounts[zaehler].getOverdraft());
		}			
				
		else{
			throw new CardNotInsertedException();

		}
	} 
	
	/**
	 * 
	 * Der Geldautomat wird auf den Status READY gesetzt, das Attribute cashCard wird zur Nullreferenz.
	 * Das ist nur moglich im Zustand CARD_INSERTED.
	 * Der Status des Automaten soll auf der Konsole protokolliert werden.
	 * Die Methode ejectCashCard() kann auch im Zustand PIN_CORRECT ausgefuhrt werden.
	 * 
	 * @throws KarteAus
	 * 
	 */
	public void ejectCashCard() throws CardNotInsertedException {
		if  (state==State.CARD_INSERTED || state==State.PIN_CORRECT )
		{
			
				cashCard = null;
				zaehler=0;
				state = State.READY;
				System.out.println("Ihr Karte ist entfenrt!");
				System.out.println("Automat ist auf Status " + state + " gesetzt.");
		}			
				else {
			throw new CardNotInsertedException();
		} // If Ende
	} 
}
