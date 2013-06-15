
public class Account {


private int accountNumber;
private double overdraft;
private double bankDeposit;
private int pin;

public Account(int nummer, int over, int pin, int depo)
{

	accountNumber = nummer;
	
	overdraft = over;
	this.pin= pin;
	bankDeposit = depo;
} 





public void setOverdraft(double overdraft) {
	this.overdraft = overdraft;
}





public int getAccountNumber()
{
	return accountNumber;
}

public double getOverdraft()
{
	return overdraft;
}

public double getBankDeposit()
{
	return bankDeposit;
}





public int getPin() {
	return pin;
}





public void setBankDeposit(double bankDeposit) {
	this.bankDeposit = bankDeposit;
}
















}
