package de.university.andereVersion.bank_business;

public class WrongPinException extends Exception{

		public WrongPinException(String fault){
			super(fault);
		}
		
		public WrongPinException(){
			super("Eingegebener PIN ungueltig!");
		}
}
