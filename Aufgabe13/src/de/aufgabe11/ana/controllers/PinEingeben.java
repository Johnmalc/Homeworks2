package de.aufgabe11.ana.controllers;

import java.awt.event.*;
import de.aufgabe11.ana.exc.*;
import de.aufgabe11.ana.main.*;

public class PinEingeben implements ActionListener {

	// Model
	private CashMachine<Account> cashMachine = new CashMachine<Account>();
	// View
	private View view;

	// Konstruktor
	public PinEingeben(CashMachine<Account> cashMachine) {
		this.cashMachine = cashMachine;
	}

	public void setView(View view) {
		this.view = view;
	}

	// Action
	public void actionPerformed(ActionEvent e) {

		try {
			/*
			 * Eingabe von Pin in Cashmachine
			 */
			cashMachine.pinEingeben(view.getTextPIN());
			view.updateViewPin();// Fuehrt die benoetigten Aenderungen in View
		} catch (NumberFormatException e1) {
			view.InfoSchreiben(e1);
		} catch (PinNotCorectException e1) {
			view.InfoSchreiben(e1);
		} catch (CardNotInsertedException e1) {
			view.InfoSchreiben(e1);
		}
	}

}
