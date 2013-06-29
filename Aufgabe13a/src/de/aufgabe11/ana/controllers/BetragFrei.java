package de.aufgabe11.ana.controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import de.aufgabe11.ana.main.*;

public class BetragFrei implements ActionListener {
	
	private Test test;
	public void setView(Test test) {
		this.test = test;
	}
	
	// private Counter counter;
	// private CounterView view;

		public void actionPerformed(ActionEvent arg0) {
			if (test.getFrei()) {// falls Ja
			test.updateViewBetragFrei();

			} else {// falls Nein
			test.updateViewBetragNichtFrei();
			
			}

		}
}
