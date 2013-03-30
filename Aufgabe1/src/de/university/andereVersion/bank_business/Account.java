package de.university.andereVersion.bank_business;

public class Account {

	private int accountNumber;
	private double overdraft;
	private double bankDeposit;
	int pin;
	
	//Konstruktor
	
	public Account(int nr, double dispo, double guthaben, int swag)
	{
		accountNumber = nr;
		overdraft = dispo;
		bankDeposit = guthaben;
		pin = swag;
	}
	
	
	
	
	// Setter - und Getter - Methoden
	
	public int getaccountNumber()
	{
		return accountNumber;
	}
	
	public void setaccountNumber(int nrx)
	{
		accountNumber = nrx;
	}
	
	public double getoverdraft()
	{
		return overdraft;
	}
	
	public void setoverdraft(double zahlx)
	{
		overdraft = zahlx;
	}
	
	public double getbankDeposit()
	{
		return bankDeposit;
	}
	
	public void setbankDeposit(double zahlx)
	{
		bankDeposit = zahlx;
	}
	
	public int getpin()
	{
		return pin;
	}
	
	public void setpin(int yolo)
	{
		pin = yolo;
	}
}
