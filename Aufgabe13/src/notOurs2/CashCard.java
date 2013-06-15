public class CashCard
{
             //Attribut der Klasse
 private int accountNumber;
 
             //Kostruktor
 public CashCard (int nu)
 {
   this.accountNumber=nu;
 }
//==============================================================================
             //Set-Methode
   public void setAccountNumber (int accountNumber)
  {
    this.accountNumber = accountNumber;
  }

//==============================================================================
            //Get-Methode
  public int getAccountNumber ()
  {
   return accountNumber;
  }
}