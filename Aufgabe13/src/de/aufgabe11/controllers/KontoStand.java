package de.aufgabe11.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.aufgabe11.exc.CardNotInsertedException;
import de.aufgabe11.main.Account;
import de.aufgabe11.main.CashMachine;
import de.aufgabe11.main.View;

public class KontoStand implements ActionListener {
	// Model
	private CashMachine<Account> cashMachine;
	// View
	private View view;

	// Konstruktor
	public KontoStand(CashMachine<Account> cashMachine) {
		this.cashMachine = cashMachine;
	}

	public void setView(View view) {
		this.view = view;
	}

	// Action
	public void actionPerformed(ActionEvent e) {

		try {
			/*
			 * Fuehr die benoetigten Aenderungen in View
			 */
			view.updateViewKS(cashMachine.accountStatementToString());
		} catch (CardNotInsertedException e1) {
			view.InfoSchreiben(e1);
		}
	}
}
