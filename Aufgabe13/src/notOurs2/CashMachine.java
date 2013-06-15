public class CashMachine
{
 private State status;
 
             //Array als Speicherplatz für die späteren Accounts
  private Account[] accounts;
  
            //weiteres Attribut CashCard
  private CashCard cashCard;
           //Enum Konstanten werden erstellt
  
  private GUI myGui;
  
  private Account benuezterAccount;
  public enum State
  {
    READY,CARD_INSERTED, PIN_CORRECT, PIN_WRONG;
  }
 //=================Konstruktoren==============================
  public CashMachine()
         {
           accounts = null;
           cashCard = null;
           status = State.READY;
           myGui = new GUI(this);
         }
         
  public CashMachine (Account[] acc)
         {
           //Ruft den oberen Konstruktor auf (bzw. sich selbst
          this();
          this.accounts = acc;
         }
 //============================================================================= 
 public void insertCashCard(int knr)
 {
 if(status == State.READY)
 {
	 boolean accexistenz = false;
	 
	 for(Account a:accounts)
	 {
		 if(a.getAccountNumber() == knr)
		 {
			 benuezterAccount = a;
			 accexistenz = true;
			 myGui.infobox.setText("Karte wurde akzeptiert!");
			 status = State.CARD_INSERTED;
		 }
	 }
	 
	 if (accexistenz == false)
	 {
		myGui.infobox.setText("Falsche Karte im Geldautomat!");
		status = State.READY;
	 }
 }
} 
//==============================================================================
   public void withdraw(int amount)
   {
     if (status ==State.PIN_CORRECT)
     {                                               
          if(benuezterAccount.getOverdraft()+ benuezterAccount.getBankDeposit() >= amount)
          {
        	benuezterAccount.setBankDeposit((benuezterAccount.getBankDeposit()- amount));
            myGui.infobox.setText("Neuer Kontobetrag=" + benuezterAccount.getBankDeposit());
          }
          
          else
          {
           myGui.infobox.setText("Sie haben zu wenig Geld!");
          }
        }
     
     else
     {
      myGui.infobox.setText("Fehler! bitte zuerst pin korrekt eingeben");
     }

    }
//==============================================================================
   public void accountStatement()
   {
     if (status ==(State.PIN_CORRECT))
     {
       myGui.infobox.setText("Kontonummer: " + benuezterAccount.getAccountNumber());
       myGui.infobox.setText("<html>" + myGui.infobox.getText() + "<br/>" + "Dispokredit des Kontos: "+ benuezterAccount.getOverdraft());
       myGui.infobox.setText(myGui.infobox.getText() + "<br/>" + "Kontoguthaben: " + benuezterAccount.getBankDeposit() +"</html>");
     }
   }
//==============================================================================
 public void ejectCashCard()
 {
     if ((status == State.CARD_INSERTED) || status ==(State.PIN_CORRECT))
     {
      cashCard = null;
      status = State.READY;
      myGui.infobox.setText("Entnehmen Sie Ihre Karte....Automat ist Ready");
     }
 }
//==============================================================================
  public void enterPin(int pin)
  {
	boolean pinexistenz = false;
    if (status == State.CARD_INSERTED)
    {
        if (benuezterAccount.getPin() == pin)
        {
     	 pinexistenz = true;
         myGui.infobox.setText("Pin wurde korrekt eingegeben");
         status = State.PIN_CORRECT;
        } 
      

        if(pinexistenz == false)
        {
         myGui.infobox.setText("Pin ist nicht korrekt");
         status = State.PIN_WRONG;
        } 
    }
  }    
}
    