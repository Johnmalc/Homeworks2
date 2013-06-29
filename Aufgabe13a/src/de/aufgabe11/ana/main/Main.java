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
		KontoStand kontoStand=new KontoStand(cashMachine);
		BetragFrei betragFrei =new BetragFrei();
		GeldAbheben geldAbheben=new GeldAbheben(cashMachine);
		KarteAusgeben karteAus=new KarteAusgeben(cashMachine);
		
		//CounterController controller = new CounterController(counter);
		
		/*Relate View and Controller*/
		test.addControllers(karteEingeben, pinEingeben, kontoStand,betragFrei,geldAbheben,karteAus);
		karteEingeben.setView(test);
		pinEingeben.setView(test);
		kontoStand.setView(test);
		betragFrei.setView(test);
		geldAbheben.setView(test);
		karteAus.setView(test);
		//view.addClickListener(controller);
		//controller.setView(view);

	}
}
