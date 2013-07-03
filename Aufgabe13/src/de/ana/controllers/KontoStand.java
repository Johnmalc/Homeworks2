package de.ana.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.ana.exc.CardNotInsertedException;
import de.ana.main.Account;
import de.ana.main.CashMachine;
import de.ana.main.View;

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
