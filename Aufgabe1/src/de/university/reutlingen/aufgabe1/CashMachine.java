package de.university.reutlingen.aufgabe1;

public class CashMachine extends Account {
	Account account;
	Karte status;
	int accountZumUberprufen;
	//int r = 0;
	boolean warMethodeAusgefuhrt = false;
	CashCard cashCard;

	public CashMachine(Account account1) {
		status = Karte.READY;
		//status = Karte.CARD_INSERTED;
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
				// setzet auf true, damit ich spater die methode abfragen kann, ob sie ausgefuhrt wurde (in enterPin)
				warMethodeAusgefuhrt = true;
				// zeige den staus
				System.out.println("----------------------------");
				System.out.print("Sie haben jetzt ihre Karte im Automat. Status ist auf ");
				System.out.print(getStatus());
				System.out.println(" gesetzt");
				// Speicherung der karte nummer und pins zum spaterem Uberprufen
				int accountZumUberprufen = cashCard.getAccountNumber();
				int pinZumUberprufen = cashCard.getPin();

				// fur testing purposes
				System.out.println("Ihren Pin von Karte ist " + pinZumUberprufen);
				System.out.println("Ihren Account von Karte ist " + accountZumUberprufen);
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
					// wenn beides accounts ubereinstimmen
					System.out.println("");
					System.out.println("Ihre account Nummer mit dem Karte nummer STIMMT uberein");
					if (pinZumUberprufen != cashCard.getPin()) {
						// wenn pins falsch sind, mache das und karte auswerfen
						setStatus(statusPinWrong);
						System.out.println("Ihre Pin Nummer mit dem Pin der Karte stimmt nicht uberein");
						System.out.println("Keine weitere methoden ausfuhrbar (wegen"
										+ statusPinWrong + "> Karte wird ausgeworfen");
						ejectCashCard();
					}else {
						// setze den status auf pin correct
						setStatus(statusPinCorrect);
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
				System.out.println("");
				System.out.println("Entweder wollen sie zu viel geld abheben und das konnen sie nicht. ");
				System.out.println("Oder sie haben schon ihre Karte ausgemacht ");
			} else {
				// wenn amount kleiner ist als overdraft, dann speichere unter neuesBetrag der neue restbetrag
				double neuesBetrag = bankDeposit - amount;
				System.out.println("Ihres neuen zustand ist " + neuesBetrag);
			}
		} else {
			// wenn der status nicht card inserted ist , dann fuhre folgendes
			System.out.println("Sie konnen abheben nur im Zustand "
					+ statusCardInserted + " und " + statusPinCorrect);
		}
	}

	/**
	 * <h2>Kontoinformationen</h2> Ausgabe der aktuellen Kontoinformationen auf
	 * der Konsole, nur moglich im Zustand CARD_INSERTED.
	 * 
	 * @param FINISHED
	 */

	public void accountStatement() {
		// wenn der status NICHY pin wrong ist, fuhre aus
		if (getStatus() != statusPinWrong) {
			// frage der status ab
			if (status == getStatus()) {
				// wenn der status pin correct ist, zeige die informationen
				// System.out.println(status); test
				System.out.println("Your account number is " + accountNumber + ".");
				System.out.println("Your pin is " + pin + ".");
				System.out.println("Your bank deposit is " + bankDeposit + ".");
				System.out.println("Your credit (overdraft) is " + overdraft + ".");
				System.out.println("");

			} else {
				System.out.println("");
				System.out.println("Sie konnen KEINE Informationnen kriegen, weil sie keine Karte im Automat haben");
				
			}
		} else {
			System.out.println("Sie konnen die Informationen nicht kriegen, weil der Pin falsch ist");
		}
	}

	/**
	 * <h2>Kartenauswurf</h2> Der Geldautomat wird auf den Status READY gesetzt,
	 * das Attribute cashCard wird zur Nullreferenz. Das ist nur moglich im
	 * Zustand CARD_INSERTED. Der Status des Automaten soll auf der Konsole
	 * protokolliert werden.
	 * @status FINISHED
	 */
	public void ejectCashCard() {
		// System.out.println(getStatus()); // pin wrong
		
		if (getStatus() != statusCardInserted) {
			// wenn status nicht cardinserted ist, mach dies
			System.out.println("");
		} else {
			// wenn status card ready ist dann setze den status karte ready + fuhre die methode mit null aus
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
	 * @status FINISHED
	 */
	public void enterPin(int pin) {
		//if method was eject carte has been run, then you can do this, BUT if
		// not, you can not check the PIN (method will be not executed)
		if (warMethodeAusgefuhrt = true) {
			// war die methode eject cart ausgefuht ?
			if (account.getPin() == pin) {
				// war der pin correct > setze auf pincorrect
				setStatus(statusPinCorrect);
				System.out.println("Sie haben folgenden Pin fur ihre karte eingegeben: "
								+ account.getPin());
				System.out.print("Sie haben RICHTIGEN pin eingegen. Status wird auf ");
				System.out.print(getStatus());
				System.out.println(" gesetzt");
				System.out.println();

			} else {
				// anderseits ist pin falsch
				setStatus(statusPinWrong);
				System.out.println("Der Richtige pin lautet: " + account.getPin());
				System.out.print("Sie haben Falschen pin eingegen. Status wird auf ");
				System.out.print(getStatus());
				System.out.println(" gesetzt");
				if (getStatus() == statusPinWrong) {
					// wenn der pin falsch war karte wird ausgemacht, und auf console geschrieben,dass das nicht geht
					System.out.println("sie konnen keine weitere methodone ausfuhren");
					System.out.println("Ihre karte wird ausgeworfen");
					ejectCashCard();
				}
			}
		} else {
			// methode eject card war nicht ausgefuhr, deswegen kann man diese methode nicht ausfuhren
			System.out.println("Sie konnen diese methode nicht ausfuhren, weil sie haben die die karte nicht drin");
		}
	}// ende von methode enter Pin
}

