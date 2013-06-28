package de.aufgabe11.ana.controllers;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.text.JTextComponent;

import de.aufgabe11.ana.exc.CardInsertedException;
import de.aufgabe11.ana.exc.InvalidCardException;
import de.aufgabe11.ana.main.Account;
import de.aufgabe11.ana.main.CashCard;
import de.aufgabe11.ana.main.CashMachine;
import de.aufgabe11.ana.main.Test;

public class KarteEingeben implements ActionListener {

	// Element von CashMachine
	private CashMachine<Account> cashMachine = new CashMachine<Account>();
	private Test test;
	private int nummer;

	// private Counter counter;
	// private CounterView view;

	public KarteEingeben(CashMachine<Account> cashMachine) {
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
			cashMachine.insertCashCard(new CashCard(test.getTextKN()));
			test.updateViewKN();
			
		} catch (NumberFormatException e1) {
			test.InfoSchreiben(e1);
		} catch (CardInsertedException e1) {
			test.InfoSchreiben(e1);
		} catch (InvalidCardException e1) {
			test.InfoSchreiben(e1);
		}// end of Try/Catch

	}

}
