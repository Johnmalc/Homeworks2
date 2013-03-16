package malcjohn;

import java.util.ArrayList;
import java.util.List;

public class CashMachine<K> {
	List<Account> account;

	int r = 0;

	public CashMachine(List<Account> accountX) {
		this.account = accountX;
	}

	public CashMachine() {
		// TODO Auto-generated constructor stub
	}

	CashCard cashCard;
	//Account[] accounts = new Account[5];

	/**
	 * Enumeration
	 * http://javarevisited.blogspot.cz/2011/08/enum-in-java-example-
	 * tutorial.html
	 */
	public enum Karte {
		READY, CARD_INSERTED, PIN_CORRECT, PIN_WRONG;
	}

	private Karte status = Karte.READY;
	private Karte status2 = Karte.PIN_CORRECT;
	private Karte status3 = Karte.CARD_INSERTED;

	public Karte getStatus() {
		return status;
	}

	public void setAccounts(List<Account> accountX) {
		this.account = accountX;
	}

	/**
	 * <h2>Karteneingabe</h2> Nur im Zustand READY konnen die Informationen der
	 * eingegebenen Cashcard im Attribute cashCard abgespeichert werden. Bei
	 * erfolgreicher Eingabe wechselt der Zustand von READY auf CARD_INSERTED.
	 * Der Status des Automaten soll auf der Konsole protokolliert werden.
	 */
	public void insertCashCard(CashCard cashCard) {
		if (status.equals(Karte.READY)) {
			setStatus(status);
			System.out
					.println("Sie haben jetzt ihre Karte im Automat. Status ist auf "
							+ status + " gesetzt.");

			int accountZumUberprufen = cashCard.getAccountNumber();
			int pinZumUberprufen = cashCard.getPin();
			System.out.println(pinZumUberprufen);
			// int zea = accounts[0].getAccountNumber();
			// oder accounts.lenght
			for (int b = 0; b < account.size(); b++) {
				if (accountZumUberprufen == ((Account) account).getAccountNumber()
						&& ((Account) account).getPin() == pinZumUberprufen) {
					// Zum uberprufung welches nummer man zeigt
					// System.out.println(accounts[0].getAccountNumber());
					System.out.println("Account nummer und Pin SIND gleich ");
				} else {
					System.out.println("Account nummer sind und pin NICHT gleich ");
				}
			}

		} else {
			setStatus(status2);
			System.out.println("Ihre karte ist schon im Automat. Status ist"
					+ status2 + " gesetzt.");
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

	}

	/**
	 * <h2>Kontoinformationen</h2> Ausgabe der aktuellen Kontoinformationen auf
	 * der Konsole, nur moglich im Zustand CARD_INSERTED.
	 */
	public void accountStatement() {
		if (Karte.CARD_INSERTED != null) {
			System.out.println("Your account number is "
					+ Account.accountNumber + ".");
			System.out.println("Your pin is " + Account.pin + ".");
			System.out.println("Your bank deposit is " + Account.bankDeposit
					+ ".");
		} else {
			System.out.println("Sie konnen nicht die einformationnen kriegen.");
		}
	}

	/**
	 * <h2>Kartenauswurf</h2> Der Geldautomat wird auf den Status READY gesetzt,
	 * das Attribute cashCard wird zur Nullreferenz. Das ist nur moglich im
	 * Zustand CARD_INSERTED. Der Status des Automaten soll auf der Konsole
	 * protokolliert werden.
	 */
	public void ejectCashCard() {

	}

	/**
	 * Die Methode gleicht die Eingabe des Pins mit dem Pin des gerade
	 * verwendeten Accounts ab. Bei korrekter Eingabe wechselt der Zustand des
	 * Geldautomaten in PIN_CORRECT. Bei Falscheingabe in PIN_WRONG. Der Status
	 * des Automaten soll auf der Konsole protokolliert werden.
	 * 
	 * @param pin
	 */
	public void enterPin(int pin) {
		if (((Account) account).getPin() == pin) {
			setStatus(status2);
			System.out.println("Sie haben RICHTIGEN pin eingegen. Status wird auf " + status2 + " gesetzt.");
		} else {
			setStatus(status3);
			System.out.println("Sie haben Falschen pin eingegen. Status wird auf " + status3 + " gesetzt.");
		}
	}

	/**
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
}
