package de.university.andereVersion.bank_business;

public class CardInsertedException extends Exception {


	public CardInsertedException(String fault){
		super(fault);
	}
	
	public CardInsertedException(){
		super("Eingegebener PIN ungueltig!");
	}
}
