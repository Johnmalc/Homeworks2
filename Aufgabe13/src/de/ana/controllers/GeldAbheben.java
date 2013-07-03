package de.ana.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.ana.exc.CardNotInsertedException;
import de.ana.exc.NotEnoughMoneyException;
import de.ana.exc.PinNotCorectException;
import de.ana.main.Account;
import de.ana.main.CashMachine;
import de.ana.main.View;

public class GeldAbheben implements ActionListener {
	// Model
	private CashMachine<Account> cashMachine;
	// View
	private View view;

	private double betragDouble;

	// Konstruktor
	public GeldAbheben(CashMachine<Account> cashMachine) {
		this.cashMachine = cashMachine;
	}

	public void setView(View view) {
		this.view = view;
	}

	// Action
	public void actionPerformed(ActionEvent e) {

		try {
			if (view.getFrei()) {
				betragDouble = view.getTextBetrag();
			} else {
				betragDouble = view.GetTextBetragWahl();
			}
			try {
				cashMachine.withdraw(betragDouble);
				view.updateViewGeldAbheben(betragDouble,
						cashMachine.accountStatementToString());
			} catch (PinNotCorectException e1) {
				view.InfoSchreiben(e1);
			} catch (NotEnoughMoneyException e1) {
				view.InfoSchreiben(e1);
			}
		} catch (NumberFormatException e1) {
			view.InfoSchreiben(e1);
		} catch (CardNotInsertedException e1) {
			view.InfoSchreiben(e1);
		}

	}
}
