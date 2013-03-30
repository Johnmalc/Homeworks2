package de.university.andereVersion.bank_business;

public class NoAccountException extends Exception {


	public NoAccountException(String fault){
		super(fault);
	}
	
	public NoAccountException(){
		super("Konto nicht registriert!");
	}
}
