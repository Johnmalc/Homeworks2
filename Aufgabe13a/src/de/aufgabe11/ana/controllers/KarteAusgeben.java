package de.aufgabe11.ana.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.aufgabe11.ana.exc.CardNotInsertedException;
import de.aufgabe11.ana.main.Account;
import de.aufgabe11.ana.main.CashMachine;
import de.aufgabe11.ana.main.Test;

public class KarteAusgeben implements ActionListener {
	private CashMachine<Account> cashMachine;
	private Test test;

	public KarteAusgeben (CashMachine<Account> cashMachine) {
		this.cashMachine = cashMachine;
		}
	public void setView(Test test) {
		this.test = test;
	}
		public void actionPerformed(ActionEvent e) {
			try {
				cashMachine.ejectCashCard();
				test.updateViewKarteAus();
			} catch (CardNotInsertedException e1) {
				test.InfoSchreiben(e1);
			}
		}
	}
