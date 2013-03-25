package de.university.neueVersion.exceptions;

public class NotEnoughMoneyException extends Exception {

	static String text="-= Not enough Money on your account. =-";
	public NotEnoughMoneyException() {
	 super(text);

	}
	
}
