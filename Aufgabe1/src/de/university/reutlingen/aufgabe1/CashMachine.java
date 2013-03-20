package de.university.reutlingen.aufgabe1;

public class CashMachine extends Account {
	Account account;
	Karte status;
	int accountZumUberprufen;
	//int r = 0;
	CashCard cashCard;

	public CashMachine(Account account1) {
		status = Karte.READY;
		// status = Karte.CARD_INSERTED;
		this.account = account1;
	}

	/**
	 * Enumeration
	 * http://javarevisited.blogspot.cz/2011/08/enum-in-java-example-
	 * tutorial.html
	 */
	private enum Karte {
		READY, CARD_INSERTED, PIN_CORRECT, PIN_WRONG;
	}
	/**
	 * 
	 * @return status
	 */
	public Karte getStatus() {
		return status;
	}

	/**
	 * <h2>Setzt den Status des Emums</h2 Kopiert (Copyright - not mine) aus dem
	 * http://www.java-forum.org/java-basics-anfaenger-themen/87727-enum-dann-
	 * setter -setzen.html
	 */
	public void setStatus(Karte status) {
		if (status != null) {
			this.status = status;
		} else {
			throw new NullPointerException("status darf nicht null sein");
		}
	}

	private Karte statusReady = Karte.READY;
	private Karte statusCardInserted = Karte.CARD_INSERTED;
	private Karte statusPinCorrect = Karte.PIN_CORRECT;
	private Karte statusPinWrong = Karte.PIN_WRONG;

	/**
	 * <h2>Karteneingabe</h2> Nur im Zustand READY konnen die Informationen der
	 * eingegebenen Cashcard im Attribute cashCard abgespeichert werden. Bei
	 * erfolgreicher Eingabe wechselt der Zustand von READY auf CARD_INSERTED.
	 * Der Status des Automaten soll auf der Konsole protokolliert werden.
	 */
	public void insertCashCard(CashCard cashCard) {
		// gleicht ab, ob ich insertCashCard(null) nicht habe, wenn ja, dann ist die karte ausgemacht
		if (cashCard != null) {
			// wenn der status (aus dem Konstruktor ready ist, folge ... Aber wenn nicht dann ist die karte schon im automat
			if (status.equals(Karte.READY)) {
				// wenn staus im Konstruktor ready ist, dann setze ihn auf card-inserted
				setStatus(Karte.CARD_INSERTED);
				// zeige den staus
				System.out.print("Sie haben jetzt ihre Karte im Automat. Status ist auf ");
				System.out.print(getStatus());
				System.out.println(" gesetzt");
				// Speicherung der karte nummer und pins zum spaterem Uberprufen
				int accountZumUberprufen = cashCard.getAccountNumber();
				int pinZumUberprufen = cashCard.getPin();

				// fur testing purposes
				System.out.println("Ihren Pin von Karte ist "
						+ pinZumUberprufen);
				System.out.println("Ihren Account von Karte ist "
						+ accountZumUberprufen);
				// Pruft die Gleichheit: ob der der gespeicherte account UNgleich mit dem eckarte account ist
				if (accountZumUberprufen != cashCard.getAccountNumber()) {
					/* Kann nie falsch sein, TODO ana, nado dodelat
					 * es kommt hier gar nicht, weill es wird eingegebene account number 
					 * in die karte nummber ubergeben
					 * Ganz wichtig: Die karte account number wird immer das gleiche, der als account number eingegeben was
					 */
					System.out.println("Ihre account Nummer mit dem Karte nummer stimmt nicht uberein");
					System.out.println("Keine weitere methoden ausfuhrbar > Karte wird ausgeworfen");
					ejectCashCard();
				} else {
					System.out.println("Ihre account Nummer mit dem Karte nummer STIMMT uberein");
					if (pinZumUberprufen != cashCard.getPin()) {
						setStatus(statusPinWrong);
						System.out.println("Ihre Pin Nummer mit dem Pin der Karte stimmt nicht uberein");
						System.out.println("Keine weitere methoden ausfuhrbar (wegen"
										+ statusPinWrong
										+ "> Karte wird ausgeworfen");
						ejectCashCard();
					}
				}

				// int zea = accounts[0].getAccountNumber();
				// oder accounts.lenght
				// for (int b = 0; b < accounts.length; b++) {
				// if (accountZumUberprufen == account.getAccountNumber()
				// && account.getPin() == pinZumUberprufen) {
				// // Zum uberprufung welches nummer man zeigt
				// // System.out.println(accounts[0].getAccountNumber());
				// System.out.println("Account nummer und Pin SIND gleich ");
				// } else {
				// System.out.println("Account nummer sind und pin NICHT gleich ");
				// }
				// }

			} else {
				// wenn der status un ready ist, dann ist card inserted
				setStatus(statusCardInserted);
				System.out.print("Ihre karte ist schon im Automat. Status ist auf ");
				System.out.print(getStatus());
				System.out.print(" gesetzt");
				System.out.println("");
			}
		} else {
			// karte: insertCashCard(null) ist, dann folgt diese 
			System.out.println("Karte (Automat ist nicht ready) ist bereits ausgemacht");
		}
	}

	/**
	 * <h2>Abheben</h2> Das Abheben kann nur erfolgen wenn der Geldautomat im
	 * Zustand CARD_INSERTED ist. Der angegebene Betrag kann vom Konto abgehoben
	 * werden, solange es den Dispokredit nicht überschreitet.Ausserdem muss das
	 * Kontoguthaben neu berechnet und auf der Konsole ausgegeben werden.
	 * 
	 * Beachten Sie, dass Geld nur noch abgehoben werden kann, wenn der Pin
	 * korrekt ist.
	 * 
	 */
	public void withdraw(double amount) {
		// wenn der Pin correct ist, setze auf card inserted
		if (status.equals(statusPinCorrect)) {
			setStatus(statusCardInserted);
		}
		// wenn status cardinserted ist, dann prufe ob das was ich aus dem Automat will nicht grosser ist als mein Overdraft
		if (status.equals(statusCardInserted)) {
			if (amount > overdraft) {
				System.err.println("Entweder wollen sie zu viel geld abheben und das konnen sie nicht. ");
				System.err.println("Oder sie haben schon ihre Karte ausgemacht ");
			} else {
				// wenn amount kleiner ist als overdraft, dann speichere unter neuesBetrag der neue restbetrag
				double neuesBetrag = bankDeposit - amount;
				System.out.println("Ihres neuen zustand ist " + neuesBetrag);
			}
		} else {
			// wenn der status nicht card inserted ist , dann fuhre folgendes
			System.out.println("Sie konnen abheben nur im Zustand "
					+ statusCardInserted);
		}
	}

	/**
	 * <h2>Kontoinformationen</h2> Ausgabe der aktuellen Kontoinformationen auf
	 * der Konsole, nur moglich im Zustand CARD_INSERTED.
	 * 
	 * @param FINISHED
	 */

	public void accountStatement() {
		if (getStatus() != statusPinWrong) {

			if (status == getStatus()) {
				System.out.println("Your account number is " + accountNumber
						+ ".");
				System.out.println("Your pin is " + pin + ".");
				System.out.println("Your bank deposit is " + bankDeposit + ".");
				System.out.println("Your credit is " + overdraft + ".");
			} else {
				try {
					System.out.println("");
				} finally { // finally = always
					System.out
							.println("Sie konnen KEINE Informationnen kriegen, weil sie keine Karte im Automat haben");
				}
			}
		} else {
			System.out
					.println("Sie konnen die Informationen nicht kriegen, weil der Pin falsch ist");
		}
	}

	/**
	 * <h2>Kartenauswurf</h2> Der Geldautomat wird auf den Status READY gesetzt,
	 * das Attribute cashCard wird zur Nullreferenz. Das ist nur moglich im
	 * Zustand CARD_INSERTED. Der Status des Automaten soll auf der Konsole
	 * protokolliert werden.
	 */
	public void ejectCashCard() {

		// System.out.println(getStatus()); // pin wrong

		if (getStatus() != statusCardInserted) {
			System.out.println("");
		} else {
			// nur statuse wurde jetzt geandert
			setStatus(statusReady);
			System.out.print("Sie haben d status auf ");
			System.out.print(getStatus());
			System.out.println(" gesetzt");
			System.out.println("Sie haben ihre karte ausgemacht!");

			insertCashCard(null);
		}
	}

	/**
	 * <h2>Setzung des Pins (Abgleichung + status anderung)</h2> Die Methode
	 * gleicht die Eingabe des Pins mit dem Pin des gerade verwendeten Accounts
	 * ab. Bei korrekter Eingabe wechselt der Zustand des Geldautomaten in
	 * PIN_CORRECT. Bei Falscheingabe in PIN_WRONG. Der Status des Automaten
	 * soll auf der Konsole protokolliert werden.
	 * 
	 * @param pin
	 * @param FINISHED
	 */
	public void enterPin(int pin) {
		if (account.getPin() == pin) {
			setStatus(statusPinCorrect);
			System.out
					.println("Sie haben folgenden Pin fur ihre karte eingegeben:"
							+ account.getPin());
			System.out
					.print("Sie haben RICHTIGEN pin eingegen. Status wird auf ");
			System.out.print(getStatus());
			System.out.println(" gesetzt");
		} else {
			setStatus(statusPinWrong);
			System.out.println("Der Richtige pin lautet:" + account.getPin());
			System.out
					.print("Sie haben Falschen pin eingegen. Status wird auf ");
			System.out.print(getStatus());
			System.out.println(" gesetzt");
			if (getStatus() == statusPinWrong) {

				System.out
						.println("sie konnen keine weitere methodone ausfuhren");
				System.out.println("Ihre karte word ausgeworfen");
				ejectCashCard();

			}
		}
	}
}
