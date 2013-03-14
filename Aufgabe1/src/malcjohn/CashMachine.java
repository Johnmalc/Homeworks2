package malcjohn;

public class CashMachine extends Account  {
	
	
	public CashMachine(int accountNumberX, double bankDepostiX, int pinX) {
		super(accountNumberX, bankDepostiX, pinX);
		// TODO Auto-generated constructor stub
	}


	public CashMachine(Account account) {
		Account aw = new Account();
	}

	public CashCard cashCard;
	public Account[] accounts;

	
	/**
	 * Enumeration
	 * http://javarevisited.blogspot.cz/2011/08/enum-in-java-example-
	 * tutorial.html
	 */
	public enum Karte {
		READY, CARD_INSERTED, PIN_CORRECT, PIN_WRONG;
	}

	// methods
	public void setCashCard(CashCard value) {
		this.cashCard = value;
	}

	public CashCard getCashCard() {
		return this.cashCard;
	}

	public void setAccounts(Account[] value) {
		this.accounts = value;
	}

	public Account[] getAccounts() {
		return this.accounts;
	}

	/**
	 * <h2>Karteneingabe</h2> Nur im Zustand READY können die Informationen der
	 * eingegebenen Cashcard im Attribute cashCard abgespeichert werden. Bei
	 * erfolgreicher Eingabe wechselt der Zustand von READY auf CARD_INSERTED.
	 * Der Status des Automaten soll auf der Konsole protokolliert werden.
	 */
	public void insertCashCard(CashCard cashCard) {

	}

	/**
	 * <h2>Abheben</h2> Das Abheben kann nur erfolgen wenn der Geldautomat im
	 * Zustand CARD_INSERTED ist. Der angegebene Betrag kann vom Konto abgehoben
	 * werden, solange es den Dispokredit nicht überschreitet. Außerdem muss das
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
	 * der Konsole, nur möglich im Zustand CARD_INSERTED.
	 */
	public void accountStatement() {
		if (Karte.CARD_INSERTED != null) {
			System.out.println("Your account number is " + accountNumber + ".");
			System.out.println("Your pin is " + pin + ".");
			System.out.println("Your bank deposit is " + bankDeposit + ".");
		}
	}

	/**
	 * <h2>Kartenauswurf</h2> Der Geldautomat wird auf den Status READY gesetzt,
	 * das Attribute cashCard wird zur Nullreferenz. Das ist nur möglich im
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
	 */
	public void enterPin(int pind) {
		this.pin = pind;
	}

}
