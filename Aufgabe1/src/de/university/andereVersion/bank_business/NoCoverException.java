package de.university.andereVersion.bank_business;

public class NoCoverException extends Exception{


	public NoCoverException(String fault){
		super(fault);
	}
	
	public NoCoverException(){
		super("Unzureichende Deckung!");
	}
}
