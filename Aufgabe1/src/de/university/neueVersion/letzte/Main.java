package de.university.neueVersion.letzte;

import de.university.neueVersion.exceptions.KarteAus;
import de.university.neueVersion.exceptions.KarteIn;
import de.university.neueVersion.exceptions.NichtGenugGeld;
import de.university.neueVersion.exceptions.PinFalsch;

public class Main {

	public static void main(String[] args) throws PinFalsch, KarteAus, NichtGenugGeld, KarteIn {
		
		CashMachine cashMachine = new CashMachine();
		
		CashCard cashCard1 = new CashCard(12345678);
		CashCard cashCard2 = new CashCard(23456789);
		
		cashMachine.insertCashCard(cashCard1);
		// cashMachine.withdraw(125);
		// cashMachine.insertCashCard(cashCard);
		cashMachine.pinEingeben(1234);
		cashMachine.ejectCashCard(cashCard1);
		cashMachine.insertCashCard(cashCard2);
		// cashMachine.withdraw(125);
		// cashMachine.insertCashCard(cashCard);
		cashMachine.pinEingeben(2345);
		cashMachine.accountStatement();
		cashMachine.withdraw(100);

	}

}
