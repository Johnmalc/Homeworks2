package de.university.neueVersion.letzte;

import de.university.neueVersion.exceptions.*;

public class Main {

	public static void main(String[] args)  {
		
		CashMachine cashMachine = new CashMachine();
		CashCard cashCard1 = new CashCard(12345678);
		CashCard cashCard2 = new CashCard(23456789);
		
		// Test 1 um CardNotInsertedException zu pruefen
		try {cashMachine.accountStatement();}
		catch (CardNotInsertedException e)
		{ System.out.println("Test1 Erfolgreich"+"\n");
			
		} 
		
		
		// Test 2 um CardInsertedException zu pruefen
		try {
		cashMachine.insertCashCard(cashCard1);
		cashMachine.insertCashCard(cashCard2);
		}
		catch (CardInsertedException e) {
			System.out.println("Test2 Erfolgreich"+"\n");
			
				} catch (InvalidCardException e) {
		   System.out.println("Test2 ist nicht bestanden.");
		} 
		
		// Test 3 um PinNotCorectException zu pruefen; CardNotInsertedException sollte in dem Fall nicht aufgetreten werden!
				try {
				cashMachine.pinEingeben(1254);
				}
				catch (PinNotCorectException e) {
					System.out.println("Test3 Erfolgreich"+"\n");
					
						} catch (CardNotInsertedException e) {
					System.out.println("Test3 nicht bestanden"+"\n");
				} catch (InvalidCardException e) {
					System.out.println("Test3 nicht bestanden"+"\n");
						} 
				
								
				// Test 4 um NotEnoughMoneyException zu pruefen; PinNotCorectException und CardNotInsertedException sollten hier nicht getroffen werden
				try {
				cashMachine.pinEingeben(1234);
				cashMachine.withdraw(12000);
				}
				catch (PinNotCorectException e) {
					System.out.println("Test4 ist nicht bestanden"+"\n");} 
				catch (CardNotInsertedException e) {
					System.out.println("Test4 ist nicht bestanden"+"\n");
				} 
				catch (NotEnoughMoneyException e) {
					System.out.println("Test4 ist erfolgreich!"+"\n");
						} catch (InvalidCardException e) {
							System.out.println("Test4 ist nicht bestanden"+"\n");
				} 
				
				
				// Test 5 prueft, ob InvalidCardException funktioniert
				try {
					cashMachine.ejectCashCard();
					cashMachine.insertCashCard(new CashCard(11111111));
					
				}
				
				
				catch (CardNotInsertedException e) {
					System.out.println("Test5 ist nict bestanden!"+"\n");
					} catch (CardInsertedException e) {
					System.out.println("Test5 ist nict bestanden!"+"\n");
				} catch (InvalidCardException e) {
					System.out.println("Test5 ist erfolgreich!"+"\n");
				} 
				
		}

}
