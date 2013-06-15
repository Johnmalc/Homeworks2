public class CashmachineException extends IllegalStateException {

	
	
	public CashmachineException(Status state){
		
		super(fehlermeldung(state));
	}

   private static String fehlermeldung(Status state){
	   
	  if(state == Status.READY)  
		  return "Fehlermeldung 1";
	  
	  else if(state == Status.CARD_INSERTED)
	  {
		  
	  	return "Fehlermeldung 2";
	  	
	  }
	  
	  if(state==Status.PIN_CORRECT)
	  {
		  
		  return "Fehlermeldung 3";
		  
	  }
	  else if(state == Status.PIN_WRONG){
		  
	  	return "Fehlermeldung 4";
	  	
	  }
	  
	  return " Unbekannter Fehler";
	  
   }

}
