package de.university.andereVersion.bank_business;

public class NoCardException extends Exception {

	public NoCardException(String fault){
		super(fault);
	}
	
	public NoCardException(){
		super("Bitte stecken Sie eine Karte ein!");
	}
}
