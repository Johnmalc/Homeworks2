package de.ana.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.ana.exc.CardNotInsertedException;
import de.ana.main.Account;
import de.ana.main.CashMachine;
import de.ana.main.View;

public class KarteAusgeben implements ActionListener {
	// Model
	private CashMachine<Account> cashMachine;
	// View
	private View view;

	// Konstruktor
	public KarteAusgeben(CashMachine<Account> cashMachine) {
		this.cashMachine = cashMachine;
	}

	public void setView(View view) {
		this.view = view;
	}

	// Action
	public void actionPerformed(ActionEvent e) {
		try {
			cashMachine.ejectCashCard();// Ausgabe der Karte in CashMachien
			view.updateViewKarteAus();// Fuehrt die benoetigten Aenderungen in
										// View
		} catch (CardNotInsertedException e1) {
			view.InfoSchreiben(e1);
		}
	}
}
