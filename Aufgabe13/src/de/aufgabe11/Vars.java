package de.aufgabe11;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public abstract class Vars {
	final JTextField txtKontoNummer = new JTextField();
	final JTextField txtPinEingabe = new JTextField();
	final JButton btnNewButton = new JButton("Karte eingeben");
	final JButton btnNewButton_1 = new JButton("Pin bestatigen");
	final JButton btnNewButton_2 = new JButton("Kontostand");
	final JButton btnNewButton_3 = new JButton("Geld abheben");
	final JButton btnNewButton_4 = new JButton("Karte ausgeben");
	JLabel infoPanel = new JLabel();
	final JLabel test4 = new JLabel("Test4 ist erfolgreich. Karte raus", SwingConstants.CENTER);
	final JLabel test4No = new JLabel("Test4 nicht bestanden. Keine Karte", SwingConstants.CENTER);
	final JDialog diaBu = new JDialog();

	final JComboBox<Integer> comboBox = new JComboBox<Integer>(
			new DefaultComboBoxModel<Integer>(new Integer[] { 50, 100, 200,
					500, 1000 }));
	
	CashMachine<Account> cashMaAccountList = new CashMachine<Account>();
}
