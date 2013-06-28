package de.aufgabe11.ana.main;

import de.aufgabe11.ana.controllers.*;
import de.aufgabe11.ana.exc.*;

public class Main {

	public static void main(String[] args) throws CardInsertedException, InvalidCardException  {
		//new Test();	
		
		CashMachine<Account> cashMachine = new CashMachine<Account>();
		Test test=new Test(cashMachine);
		
		KarteEingeben karteEingeben=new KarteEingeben(cashMachine);
		PinEingeben pinEingeben=new PinEingeben(cashMachine);
		//CounterController controller = new CounterController(counter);
		
		/*Relate View and Controller*/
		test.addControllers(karteEingeben, pinEingeben);
		karteEingeben.setView(test);
		pinEingeben.setView(test);
		
		//view.addClickListener(controller);
		//controller.setView(view);

	}
}
