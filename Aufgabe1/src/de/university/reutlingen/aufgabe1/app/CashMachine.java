package de.university.reutlingen.aufgabe1.app;

import de.university.reutlingen.aufgabe1.exceptions.AnyException;
import de.university.reutlingen.aufgabe1.exceptions.KarteAus;
import de.university.reutlingen.aufgabe1.exceptions.KeineKarte;
import de.university.reutlingen.aufgabe1.exceptions.PinFalsch;

/**
 * TODO
 * @author 
 * @author 
 */
public class CashMachine extends Account {
	Account[] accounts;
	int accountZumUberprufen;
	boolean warMethodeAusgefuhrt = false;
	CashCard cashCard;
	State state;
	
	public CashMachine(Account[] account1) {
		state = State.READY;
		//state = State.CARD_INSERTED;
		this.accounts = account1;
	}
	
	/**
	 * Enumeration
	 * http://javarevisited.blogspot.cz/2011/08/enum-in-java-example-
	 * tutorial.html
	 */
	public enum State {
		READY, CARD_INSERTED, PIN_CORRECT, PIN_WRONG;
	}

	public State stateReady = State.READY;
	public State stateCardInserted = State.CARD_INSERTED;
	public State statePinCorrect = State.PIN_CORRECT;
	public State statePinWrong = State.PIN_WRONG;

	/**
	 * 
	 * @return state
	 */
	public State getState() {
		return state;
	}

	/**
	 * <h2>Setzt den state des Emums</h2 Kopiert (Copyright - not mine) aus dem
	 * http://www.java-forum.org/java-basics-anfaenger-themen/87727-enum-dann-
	 * setter -setzen.html
	 */
	public void setState(State state) {
		if (state != null) {
			this.state = state;
		} else {
			throw new NullPointerException("state darf nicht null sein");
		}
	}
	/**
	 * <h2>Karteneingabe</h2> Nur im Zustand READY konnen die Informationen der
	 * eingegebenen Cashcard im Attribute cashCard abgespeichert werden. Bei
	 * erfolgreicher Eingabe wechselt der Zustand von READY auf CARD_INSERTED.
	 * Der state des Automaten soll auf der Konsole protokolliert werden.
	 * @throws AnyException 
	 * @throws KarteAus 
	 */
	public void insertCashCard(CashCard cashCard) throws AnyException, KarteAus {
		// gleicht ab, ob ich insertCashCard(null) nicht habe, wenn ja, dann ist die karte ausgemacht
		if (cashCard != null) {
			// wenn der state (aus dem Konstruktor ready ist, folge ... Aber wenn nicht dann ist die karte schon im automat
			switch (state) {
			
			case READY:
				// wenn staus im Konstruktor ready ist, dann setze ihn auf card-inserted
				setState(State.CARD_INSERTED);
				// setzet auf true, damit ich spater die methode abfragen kann, ob sie ausgefuhrt wurde (in enterPin)
				warMethodeAusgefuhrt = true;
				// zeige den staus
				System.out.println("----------------------------");				
				System.out.print("Sie haben jetzt ihre Karte im Automat. state ist auf ");
				System.out.print(getState());
				System.out.println(" gesetzt");
				// Speicherung der karte nummer und pins zum spaterem Uberprufen
				int accountZumUberprufen = cashCard.getAccountNumber();
				int pinZumUberprufen = cashCard.getPin();

				// fur testing purposes
				System.out.println("Ihren Pin auf der Karte: " + pinZumUberprufen);
				System.out.println("Ihren Account, der mit account verbindet wird: " + accountZumUberprufen);
				// Pruft die Gleichheit: ob der der gespeicherte account UNgleich mit dem eckarte account ist
				if (accountZumUberprufen != cashCard.getAccountNumber()) {
					/* Kann nie falsch sein,
					 * es kommt hier gar nicht, weil es wird eingegebene account number 
					 * in die karte nummber ubergeben
					 */
					System.out.println("Ihre account Nummer mit dem Karte nummer stimmt nicht uberein");
					System.out.println("Keine weitere methoden ausfuhrbar > Karte wird ausgeworfen");
					ejectCashCard();
				} else {
					// wenn beides accounts ubereinstimmen
					System.out.println("");
					System.out.println("Ihre account Nummer mit dem Karte nummer STIMMT uberein");
					// uberpruft wenn pin richtig/falsch
					if (pinZumUberprufen != cashCard.getPin()) {
						// wenn pins falsch sind, mache das und karte auswerfen
						setState(statePinWrong);
						System.out.println("Ihre Pin Nummer mit dem Pin der Karte stimmt nicht uberein");
						System.out.println("Keine weitere methoden ausfuhrbar (wegen"
										+ statePinWrong + " > Karte wird ausgeworfen");
						ejectCashCard();
					}else {
						// setze den state auf pin correct
						setState(statePinCorrect);
					}
				}
				break;
			case CARD_INSERTED:
				// wenn der state un ready ist, dann ist card inserted
				System.out.println("----------------------------");				
				setState(stateCardInserted);
				System.out.print("Ihre karte ist schon im Automat. state war schon auf ");
				System.out.print(getState());
				System.out.print(" gesetzt");
				System.out.println("");
				break;
			default:
				break;
			}
			
		} else {
			// karte: insertCashCard(null) ist, dann folgt diese 
			// Hier keine exceptionwerfen, wil ansonsten scanner closed, will nicht
			throw new AnyException();
		}
	}

	/**
	 * <h2>Abheben</h2> Das Abheben kann nur erfolgen wenn der Geldautomat im
	 * Zustand CARD_INSERTED ist. Der angegebene Betrag kann vom Konto abgehoben
	 * werden, solange es den Dispokredit nicht �berschreitet.Ausserdem muss das
	 * Kontoguthaben neu berechnet und auf der Konsole ausgegeben werden.
	 * 
	 * Beachten Sie, dass Geld nur noch abgehoben werden kann, wenn der Pin
	 * korrekt ist.
	 * 
	 */
	public void withdraw(double amount) {
		System.out.println("Sie wollen " + amount + " abheben");
		// wenn der Pin correct ist, setze auf card inserted
		if (state.equals(statePinCorrect)) {
			setState(stateCardInserted);
		}
		// wenn state cardinserted ist, dann prufe ob das was ich aus dem Automat will nicht grosser ist als mein Overdraft
		switch (state) {
		case CARD_INSERTED:
			if (amount > overdraft) {
				System.out.println("Sie wollen zu viel geld abheben und das konnen sie nicht. ");
			} else {
				// wenn amount kleiner ist als overdraft, dann speichere unter neuesBetrag der neue restbetrag
				double neuesBetrag = bankDeposit - amount;
				System.out.println("Ihres neuen zustand ist " + neuesBetrag);
			}
			break;
		default: 
			// wenn der state nicht card inserted ist , dann fuhre folgendes
			System.out.println("Sie konnen abheben nur im Zustand "
					+ stateCardInserted + " und " + statePinCorrect);
		}
	}

	/**
	 * <h2>Kontoinformationen</h2> Ausgabe der aktuellen Kontoinformationen auf
	 * der Konsole, nur moglich im Zustand CARD_INSERTED.
	 * 
	 * @param FINISHED
	 * @throws KeineKarte 
	 * @throws PinFalsch 
	 */

	public void accountStatement() throws KeineKarte, PinFalsch {
		// wenn der state NICHY pin wrong ist, fuhre aus
		if (getState() != statePinWrong) {
			// frage der state ab
			if (state == getState()) {
				// wenn der state pin correct ist, zeige die informationen
				// System.out.println(state); 
				System.out.println("Your account number is " + accountNumber + ".");
				System.out.println("Your pin is " + pin + ".");
				System.out.println("Your bank deposit is " + bankDeposit + ".");
				System.out.println("Your credit (overdraft) is " + overdraft + ".");
				System.out.println("");

			} else {
				throw new KeineKarte();
				
			}
		} else {
			throw new PinFalsch();
		}
	}

	/**
	 * <h2>Kartenauswurf</h2> Der Geldautomat wird auf den state READY gesetzt,
	 * das Attribute cashCard wird zur Nullreferenz. Das ist nur moglich im
	 * Zustand CARD_INSERTED. Der state des Automaten soll auf der Konsole
	 * protokolliert werden.
	 * @throws KarteAus 
	 * @throws AnyException 
	 * @state FINISHED
	 */
	public void ejectCashCard() throws KarteAus, AnyException {
		// System.out.println(getstate()); // pin wrong
		
		if (getState() != stateCardInserted) {
			// wenn state nicht cardinserted ist, mach dies
			System.out.println("");
		} else {
			// wenn state card ready ist dann setze den state karte ready + fuhre die methode mit null aus
			setState(stateReady);
			System.out.print("Sie haben der state (line 217) auf ");
			System.out.print(getState());
			System.out.println(" gesetzt");
			System.out.println("Sie haben ihre karte ausgemacht!");
			insertCashCard(null);
		}
	}

	/**
	 * <h2>Setzung des Pins (Abgleichung + state anderung)</h2> Die Methode
	 * gleicht die Eingabe des Pins mit dem Pin des gerade verwendeten Accounts
	 * ab. Bei korrekter Eingabe wechselt der Zustand des Geldautomaten in
	 * PIN_CORRECT. Bei Falscheingabe in PIN_WRONG. Der state des Automaten
	 * soll auf der Konsole protokolliert werden.
	 * 
	 * @param pin
	 * @throws KeineKarte 
	 * @throws KarteAus 
	 * @state FINISHED
	 */
	public void enterPin(int pin) throws AnyException, KeineKarte, KarteAus {
		// if method eject carte has been run, then you can do this, BUT if
		// not, you can not check the PIN (method will be not executed)
		if (warMethodeAusgefuhrt = true) {
			// war die methode eject cart ausgefuht ?
			if (getPin() == pin) {
				// war der pin correct > setze auf pincorrect
				setState(statePinCorrect);
				System.out.println("Sie haben folgenden Pin fur ihre karte eingegeben: "
								+ getPin());
				System.out.print("Sie haben RICHTIGEN pin eingegen. state wird auf ");
				System.out.print(getState());
				System.out.println(" gesetzt");
				System.out.println();

			} else {
				// anderseits ist pin falsch
				setState(statePinWrong);
				System.out.println("Der Richtige pin lautet: " + getPin());
				System.out.print("Sie haben Falschen pin eingegen. state wird auf ");
				System.out.print(getState());
				System.out.println(" gesetzt");
				if (getState() == statePinWrong) {
					// wenn der pin falsch war karte wird ausgemacht, und auf console geschrieben,dass das nicht geht
					System.out.println("Sie konnen keine weitere methodone ausfuhren");
					System.out.println("Ihre karte wird ausgeworfen");
					ejectCashCard();
				}
			}
		} else {
			// methode eject card war nicht ausgefuhr, deswegen kann man diese methode nicht ausfuhren
			throw new KeineKarte();
					//"Sie konnen diese methode nicht ausfuhren, weil sie haben die die karte nicht drin");
		}
	}// ende von methode enter Pin
}

