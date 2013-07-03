package de.ana.controllers;

import java.awt.event.*;

import de.ana.main.*;

/*Controller Logic*/
public class BetragFrei implements ActionListener {
	private View view;

	public void setView(View view) {
		this.view = view;
	}

	public void actionPerformed(ActionEvent arg0) {
		if (view.getFrei()) {// falls Ja
			view.updateViewBetragFrei();

		} else {// falls Nein
			view.updateViewBetragNichtFrei();
		}

	}
}
