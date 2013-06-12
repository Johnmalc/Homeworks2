package de.aufgabe11;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

public class TextEvent implements ActionListener {
	
	JLabel output;
	
	public TextEvent() {
		output = new JLabel();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		output.setText("Vysledek");

	}

}
