package de.aufgabe11.ana.controllers;

<<<<<<< HEAD
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import de.aufgabe11.ana.exc.CardNotInsertedException;
import de.aufgabe11.ana.exc.PinNotCorectException;
import de.aufgabe11.ana.main.Account;
import de.aufgabe11.ana.main.CashMachine;
import de.aufgabe11.ana.main.Test;

	public class PinEingeben implements ActionListener {

		// Element von CashMachine
		private CashMachine<Account> cashMachine;
		private Test test;
	

		// private Counter counter;
		// private CounterView view;

		public PinEingeben(CashMachine<Account> cashMachine) {
			this.cashMachine = cashMachine;
			// nummer=Integer.parseInt(c.getText());
			// nummer=Integer.parseInt(test.Textliefern(c));
		}
=======
import java.awt.event.*;
import de.aufgabe11.ana.exc.*;
import de.aufgabe11.ana.main.*;
>>>>>>> refs/remotes/origin/master

public class PinEingeben implements ActionListener {

	// Element von CashMachine
	private CashMachine<Account> cashMachine = new CashMachine<Account>();
	private Test test;

	// private Counter counter;
	// private CounterView view;

	public PinEingeben(CashMachine<Account> cashMachine) {
		this.cashMachine = cashMachine;
		// nummer=Integer.parseInt(c.getText());
		// nummer=Integer.parseInt(test.Textliefern(c));
	}

	public void setView(Test test) {
		this.test = test;
	}

	public void setNebenKomponenet() {

	}

	public void actionPerformed(ActionEvent e) {// SAMa Action
		// counter.inc();//CASHMACHINe
		// view.updateView();//mitTEXTEN
		try {
			// cashMachine.pinEingeben(1234);
			cashMachine.pinEingeben(test.getTextPIN());
			test.updateViewPin();
		} catch (NumberFormatException e1) {
			test.InfoSchreiben(e1);
		} catch (PinNotCorectException e1) {
			test.InfoSchreiben(e1);
		} catch (CardNotInsertedException e1) {
			test.InfoSchreiben(e1);
		}
	}

}
