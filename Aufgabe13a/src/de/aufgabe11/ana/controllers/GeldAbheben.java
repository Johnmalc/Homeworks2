package de.aufgabe11.ana.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.aufgabe11.ana.exc.CardNotInsertedException;
import de.aufgabe11.ana.exc.NotEnoughMoneyException;
import de.aufgabe11.ana.exc.PinNotCorectException;
import de.aufgabe11.ana.main.Account;
import de.aufgabe11.ana.main.CashMachine;
import de.aufgabe11.ana.main.Test;

public class GeldAbheben implements ActionListener {
	private CashMachine<Account> cashMachine;
	private Test test;
	double betragDouble;

	// private Counter counter;
	// private CounterView view;

	public GeldAbheben(CashMachine<Account> cashMachine) {
		this.cashMachine = cashMachine;
		// nummer=Integer.parseInt(c.getText());
		// nummer=Integer.parseInt(test.Textliefern(c));
	}

	public void setView(Test test) {
		this.test = test;
	}

	public void actionPerformed(ActionEvent e) {

		try {
			if (test.getFrei()) {
				betragDouble = test.getTextBetrag();
			} else {
				betragDouble = test.GetTextBetragWahl();
			}
			try {
				cashMachine.withdraw(betragDouble);
				test.updateViewGeldAbheben(betragDouble, cashMachine.accountStatementToString());
			} catch (PinNotCorectException e1) {
				test.InfoSchreiben(e1);
			} catch (NotEnoughMoneyException e1) {
				test.InfoSchreiben(e1);
			}
			} catch (NumberFormatException e1) {
			test.InfoSchreiben(e1);
		} catch (CardNotInsertedException e1) {
			test.InfoSchreiben(e1);
		}

	}
}
