public class Account
{
             //Attribute der Klasse
  protected int accountNumber;
  protected double overdraft;
  protected double bankDeposit;
  protected int pin;
//==============================================================================
             //Konstruktor
  public Account (int nu, double over, double bankdepo, int pin)
  {
    this.accountNumber=nu;
    this.overdraft=over;
    this.bankDeposit=bankdepo;
    this.pin = pin;
  }
//==============================================================================
            //Set-Methoden der Klasse
   public void setAccountNumber (int accountNumber)
   {
     this.accountNumber = accountNumber;
   }
  
   public void setOverdraft (double overdraft)
   {
     this.overdraft = overdraft;
   }
  
   public void setBankDeposit (double bankDeposit)
   {
     this.bankDeposit = bankDeposit;
   }
   
   public void setPin (int pin)
   {
     this.pin = pin;
   }
//==============================================================================
          //Get-Methode der Klasse
   public int getAccountNumber ()
   {
    return accountNumber;
   }
  
   public double getOverdraft ()
   {
     return overdraft;
   }
  
   public double getBankDeposit ()
   {
     return bankDeposit;
   }
   
   public int getPin ()
   {
     return pin;
   }
}