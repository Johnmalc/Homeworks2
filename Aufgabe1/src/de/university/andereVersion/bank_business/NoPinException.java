package de.university.andereVersion.bank_business;

public class NoPinException extends Exception {


	public NoPinException(String fault){
		super(fault);
	}
	
	public NoPinException(){
		super("Bitte geben Sie zuerst einen Pin ein!");
	}
}

