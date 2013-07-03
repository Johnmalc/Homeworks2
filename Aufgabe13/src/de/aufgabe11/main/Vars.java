package de.aufgabe11.main;

import javax.swing.*;

public abstract class Vars {
	JTextField txtKontoNummer = new JTextField();
	JTextField txtPinEingabe = new JTextField();
	JTextField eingabeBeitrags = new JTextField();
	JButton btnNewButton = new JButton("Karte eingeben");
	JButton btnNewButton_1 = new JButton("Pin bestatigen");
	JButton btnNewButton_2 = new JButton("Kontostand");
	JButton btnNewButton_3 = new JButton("Geld abheben");
	JButton btnNewButton_4 = new JButton("Karte ausgeben");
	JButton btnNewButton_5 = new JButton("Geld ab");

	JLabel infoPanel = new JLabel();
	JLabel test4 = new JLabel("Test4 ist erfolgreich. Karte raus",SwingConstants.CENTER);
	JLabel test4No = new JLabel("Test4 nicht bestanden. Keine Karte",SwingConstants.CENTER);
	JLabel test3 = new JLabel("Test3 ist erfolgreich. Pin war richtig",	SwingConstants.CENTER);
	JLabel test3No = new JLabel("Test3 ist nicht bestanden. Pin ware falsch",SwingConstants.CENTER);
	JLabel test2 = new JLabel("Test2 ist erfolgreich. Sie konnen ihren Pin setzen",SwingConstants.CENTER);
	JLabel test2No = new JLabel("Test2 ist nicht bestanden. falsch",SwingConstants.CENTER);
	JLabel test1No = new JLabel("Test1 ist nicht bestanden. Wenig geld auf dem Konto",SwingConstants.CENTER);
	
	JDialog diaBu = new JDialog();
	ButtonGroup bgroup = new ButtonGroup();
	JPanel radioPanel = new JPanel();
	JRadioButton auswahl = new JRadioButton("Auswahl");
	JRadioButton freier = new JRadioButton("Freier");
	JFrame frame = new JFrame("Unser Swing Bank Program");

	JComboBox<Integer> comboBox = new JComboBox<Integer>(
			new DefaultComboBoxModel<Integer>(new Integer[] { 50, 100, 200,
					500, 1000 }));

	CashMachine<Account> cashMaAccountList = new CashMachine<Account>();
}
