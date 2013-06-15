
public class CashMachine {

	private static Account[] accounts;
	private CashCard cashCard;
	
	private static Status status;
	
	
	
	
	
	public CashMachine(Account[] accounts)
	{
		this.accounts= accounts;
		this.status= Status.READY;
	}
	
	
	public void enterPin(String nr){
		
		int nummer = Integer.parseInt(nr);
		enterPin(nummer);
		
	}
	
	public void enterPin(int pin){
		
		if( checkPin(pin)){
			status= Status.PIN_CORRECT;
			Geldautomat.setInfoText("Pin akzeptiert");
		}
		else{
			status= Status.PIN_WRONG;
			Geldautomat.setInfoText("Falscher Pin!");
		}
		
	}
	public static Status getStatus() {
		return status;
	}

	private boolean checkPin(int pin){
		
		for(Account blubb: accounts){
			if(blubb.getAccountNumber() == cashCard.accountNumber && blubb.getPin()== pin){
				return true;
			}
			
		}
		return false;
	}
	
	private boolean checkCashCard(CashCard number){
		
		for(Account blubb: accounts){
			if(blubb.getAccountNumber() == number.accountNumber)
				return true;
		}
		return false;	
	}
	
	
	
	
	public void insertCashCard(String cashCardNumber){
		
		int nummer= Integer.parseInt(cashCardNumber);
		insertCashCard(new CashCard(nummer));
	}
	
	public void insertCashCard(CashCard cashCard)

	{ 
		try{
	
			if( status== Status.READY && checkCashCard(cashCard))
			{
				this.cashCard= cashCard;
				status= Status.CARD_INSERTED;
				Geldautomat.setInfoText("Karte befindet sich im Automaten");
			}
			else
			{
				Geldautomat.setInfoText("Karte nicht angenommen");
				throw new CashmachineException(status);
			}
		}
		catch(CashmachineException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void withdraw(String bob){
		
		double nummer= Double.parseDouble(bob);
		withdraw(nummer);
		
		
	}
	
	public void withdraw(double amount)

	{
		try{
			if(status == Status.PIN_CORRECT){
			
			for(Account bob: accounts){
				if(bob.getAccountNumber() == cashCard.accountNumber && bob.getOverdraft()>= amount){
					
					bob.setOverdraft(bob.getOverdraft()- amount);
					bob.setBankDeposit(bob.getBankDeposit()- amount);
					Geldautomat.setInfoText("Neuer Kontostand :"+bob.getBankDeposit());
					
				}
				
			}
			}
			else
			{
				throw new CashmachineException(status);
			}
			
		}
			catch(CashmachineException e){
				System.out.println(e.getMessage());
			}	
		
		
	}
	
	
	public void accountStatement()

	{
		try{
	
			if(status == Status.PIN_CORRECT){
			
				for(Account bob: accounts){
					if(bob.getAccountNumber() == cashCard.accountNumber){
						Geldautomat.setInfoText("Aktueller Kontostand :"+bob.getBankDeposit());
						Geldautomat.setInfoText("Aktueller Dispokredit :"+bob.getOverdraft());
						Geldautomat.setInfoText("Kontonummer :"+bob.getAccountNumber());		
					}
				}	}
			else
			{
				throw new CashmachineException(status);
			}
		}
		catch(CashmachineException e){
			System.out.println(e.getMessage());
		}
	}
	
	public void ejectCashCard()

	{
		try{
			if(status != Status.READY){
				cashCard = null;
				status = Status.READY;
				Geldautomat.setInfoText("Bitte entnehmen Sie ihre Karte.");
				Geldautomat.setInfoText("Automat bereit");
		}
			else
			{
				throw new CashmachineException(status);
			}
	
		}
	
		catch(CashmachineException e){
			System.out.println(e.getMessage());
		}
	
	
	}
	
	
	public double getAmount(){
		
		for(Account bob: accounts){
			if(bob.getAccountNumber() == cashCard.accountNumber)
				return bob.getBankDeposit();
		}
		
		return 0.0;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



}
