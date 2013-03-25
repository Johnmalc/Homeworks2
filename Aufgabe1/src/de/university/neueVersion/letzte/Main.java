package de.university.neueVersion.letzte;
import de.university.neueVersion.exceptions.CardInsertedException;
import de.university.neueVersion.exceptions.KarteAus;
import de.university.neueVersion.exceptions.PinFalsch;
import de.university.neueVersion.exceptions.NotEnoughMoneyException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws PinFalsch, KarteAus, NotEnoughMoneyException, CardInsertedException {
		// TODO Auto-generated method stub
CashMachine cashMachine=new CashMachine();
CashCard cashCard1 = new CashCard(12345678);
CashCard cashCard2 = new CashCard(23456789);
cashMachine.insertCashCard(cashCard1);
//cashMachine.withdraw(125);
//cashMachine.insertCashCard(cashCard);
cashMachine.pinEingeben(1234);
cashMachine.ejectCashCard(cashCard1);
cashMachine.insertCashCard(cashCard2);
//cashMachine.withdraw(125);
//cashMachine.insertCashCard(cashCard);
cashMachine.pinEingeben(2345);
cashMachine.accountStatement();
cashMachine.withdraw(200);

	}

}
