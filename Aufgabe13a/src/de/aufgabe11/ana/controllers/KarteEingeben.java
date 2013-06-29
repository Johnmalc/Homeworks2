package de.aufgabe11.ana.controllers;

import java.awt.event.*;
import de.aufgabe11.ana.exc.*;
import de.aufgabe11.ana.main.*;

public class KarteEingeben implements ActionListener {

	// Model
	private CashMachine<Account> cashMachine;
	// View
	private View view;

	// Konstruktor
	public KarteEingeben(CashMachine<Account> cashMachine) {
		this.cashMachine = cashMachine;
	}

	public void setView(View view) {
		this.view = view;
	}

	// Action
	public void actionPerformed(ActionEvent e) {
		try {
			cashMachine.insertCashCard(new CashCard(view.getTextKN()));
			view.updateViewKN();

		} catch (NumberFormatException e1) {
			view.InfoSchreiben(e1);
		} catch (CardInsertedException e1) {
			view.InfoSchreiben(e1);
		} catch (InvalidCardException e1) {
			view.InfoSchreiben(e1);
		}// end of Catch

	}

}
