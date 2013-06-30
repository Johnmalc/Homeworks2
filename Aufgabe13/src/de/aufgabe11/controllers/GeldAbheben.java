package de.aufgabe11.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.aufgabe11.exc.CardNotInsertedException;
import de.aufgabe11.exc.NotEnoughMoneyException;
import de.aufgabe11.exc.PinNotCorectException;
import de.aufgabe11.main.Account;
import de.aufgabe11.main.CashMachine;
import de.aufgabe11.main.View;

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
