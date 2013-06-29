package de.aufgabe11.ana.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.aufgabe11.ana.exc.CardNotInsertedException;
import de.aufgabe11.ana.main.Account;
import de.aufgabe11.ana.main.CashMachine;
import de.aufgabe11.ana.main.View;

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
			view.updateViewKS(cashMachine.accountStatementToString());// Fuehrt
																		// die
																		// benoetigten
																		// Aenderungen
																		// in
																		// View
		} catch (CardNotInsertedException e1) {
			view.InfoSchreiben(e1);
		}
	}
}
