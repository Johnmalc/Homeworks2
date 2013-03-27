package de.university.neueVersion.letzte;

import de.university.neueVersion.exceptions.KarteAus;
import de.university.neueVersion.exceptions.KarteIn;
import de.university.neueVersion.exceptions.NichtGenugGeld;
import de.university.neueVersion.exceptions.PinFalsch;

public class Main {

	public static void main(String[] args) throws PinFalsch, KarteAus, NichtGenugGeld, KarteIn {
		
		CashMachine cashMachine = new CashMachine();
		
		CashCard cashCard1 = new CashCard(12345678);
		cashMachine.insertCashCard(cashCard1);
		cashMachine.pinEingeben(1234);
		cashMachine.withdraw(125);
		cashMachine.accountStatement();
		cashMachine.ejectCashCard();
		
		/**
		 * Bitte ausklammen, um Die Exception zu kriegen.
		 * ctrl+shift+c (fur ana-odnovremenno)
		 */
		 
//		CashCard cashCard2 = new CashCard(23456789);
//		cashMachine.ejectCashCard();
//		cashMachine.insertCashCard(cashCard2);
//		cashMachine.withdraw(125);
//		cashMachine.insertCashCard(cashCard2);
//
//		cashMachine.pinEingeben(2345);
//		cashMachine.accountStatement();
//		cashMachine.withdraw(100);
        
	}

}
