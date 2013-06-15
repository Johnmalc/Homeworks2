package de.aufgabe11;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import sun.applet.Main;

import de.aufgabe11.exc.*;

/*
 * Sources used
 * http://zetcode.com/tutorials/javaswingtutorial/swingevents/
 * http://stackoverflow.com/questions/10379527/trying-to-get-input-from-jtextfield-and-use-in-another-method
 * http://openbook.galileodesign.de/javainsel5/javainsel15_006.htm#Rxx747java150060400053E1F024100
 * 
 * We hate Swing. Yes, really. Who the fuck created it?
 */
public class Gui {

	/*
	 * List of Account = for iterators in the bottom CashMashine for its own
	 * class
	 */
	LinkedList<Account> linkedList = new LinkedList<Account>();
	CashMachine<Account> cashMaAccountList = new CashMachine<Account>();

	JFrame frame;
	final JTextField txtKontoNummer = new JTextField();
	final JTextField txtPinEingabe = new JTextField();
	final JButton btnNewButton_1 = new JButton("Pin bestatigen");
	final JButton btnNewButton_2;
	final JComboBox<Integer> comboBox;
	final JButton btnNewButton_3 = new JButton("Geld abheben");
	final JButton btnNewButton_4 = new JButton("Karte ausgeben");
	final JLabel txtrInformationstext;
	
	public Gui() {
		frame = new JFrame("Unsere Swing Programma");
		frame.setPreferredSize(new Dimension(400, 300)); // size of the windows

		// where the window will be displayed
		frame.setBounds(690, 200, 500, 400);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(9, 1));

		txtKontoNummer.setText("Konto Nummer");
		txtKontoNummer.setColumns(10);
		frame.getContentPane().add(txtKontoNummer);

		/* --------------------------------- Jedem ------------------- */

		final JButton btnNewButton = new JButton("Karte eingeben");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Asks for the input, which comes from JTetxField, parses to
				 * int and saves under karteNummer. This then is saved & goes
				 * into the similar object
				 */
				int karteNummer = 0;
				try {
					karteNummer = Integer.parseInt(txtKontoNummer.getText());
				} catch (InputMismatchException r) {

				}
				CashCard kontoNummerObject = new CashCard(karteNummer);

				try {
					cashMaAccountList.insertCashCard(kontoNummerObject);
					JDialog diaBu = new JDialog();
					JLabel sj = new JLabel(
							"Test2 ist erfolgreich. Sie konnen ihre pin setzen",
							SwingConstants.CENTER);
					diaBu.add(sj);
					diaBu.pack();
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
					txtKontoNummer.setEditable(false);
					btnNewButton.setEnabled(false);
				} catch (CardInsertedException CAI) {
					JDialog diaBu = new JDialog();
					JLabel sj = new JLabel(
							"Test2 ist nicht bestanden. Falsch.",
							SwingConstants.CENTER);
					diaBu.add(sj);
					diaBu.pack();
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
				} catch (InvalidCardException ICE) {
					JDialog diaBu = new JDialog();
					JLabel sj = new JLabel(
							"Test2 ist nicht bestanden. Falsch. 2",
							SwingConstants.CENTER);
					diaBu.add(sj);
					diaBu.pack();
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
				}
			}
		});
		// button zeug ende
		frame.getContentPane().add(btnNewButton);

		/* -------------------- dalsi ------------- */

		txtPinEingabe.setText("Pin eingabe");
		frame.getContentPane().add(txtPinEingabe);
		txtPinEingabe.setColumns(10);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Asks for the input, which comes from JTetxField, parses to
				 * int and saves under karteNummer. This then is saved & goes
				 * into the similar object
				 */
				int pinNummer = 0;
				try {
					pinNummer = Integer.parseInt(txtPinEingabe.getText());
				} catch (InputMismatchException r) {

				}
				try {
					cashMaAccountList.pinEingeben(pinNummer);
					JDialog diaBu = new JDialog();
					JLabel sj = new JLabel(
							"Test3 ist erfolgreich. Pin war richtig",
							SwingConstants.CENTER);
					diaBu.add(sj);
					diaBu.pack();
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
					txtPinEingabe.setEditable(false);
					btnNewButton_1.setEnabled(false);
				} catch (PinNotCorectException PNC) {
					JDialog diaBu = new JDialog();
					JLabel sj = new JLabel("Test3 ist falsch. Noch einmal",
							SwingConstants.CENTER);
					diaBu.add(sj);
					diaBu.pack();
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
				} catch (CardNotInsertedException CNIE) {
					JDialog diaBu = new JDialog();
					JLabel sj = new JLabel(
							"Test3 ist nicht bestanden. Pin ware falsch",
							SwingConstants.CENTER);
					diaBu.add(sj);
					diaBu.pack();
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
				} catch (InvalidCardException ICE) {
					JDialog diaBu = new JDialog();
					JLabel sj = new JLabel(
							"Test3 ist nicht bestanden. Pin ware falsch",
							SwingConstants.CENTER);
					diaBu.add(sj);
					diaBu.pack();
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
				}
			}
		});
		frame.getContentPane().add(btnNewButton_1); // button 2 zeug zu ende
		btnNewButton_2 = new JButton("Kontostand");
		frame.getContentPane().add(btnNewButton_2);

		comboBox = new JComboBox<Integer>();
		comboBox.setModel(new DefaultComboBoxModel<Integer>(new Integer[] { 50,
				100, 200, 500, 1000 }));

		comboBox.setEnabled(true);
		frame.getContentPane().add(comboBox);

		frame.getContentPane().add(btnNewButton_3);

		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Asks for the input, which comes from JTetxField, parses to
				 * int and saves under karteNummer. This then is saved & goes
				 * into the similar object
				 */
				try {
					cashMaAccountList.ejectCashCard();
					JDialog diaBu = new JDialog();
					JLabel sj = new JLabel("Test4 ist erfolgreich. Karte raus",
							SwingConstants.CENTER);
					diaBu.add(sj);
					diaBu.pack();
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
					btnNewButton.setEnabled(true);
					btnNewButton_1.setEnabled(true);
					btnNewButton_2.setEnabled(true);
					txtKontoNummer.setEditable(true);
					txtPinEingabe.setEditable(true);
					
				} catch (CardNotInsertedException e1) {
					JDialog diaBu = new JDialog();
					JLabel sj = new JLabel(
							"Test4 nicht bestanden. Keine Karte",
							SwingConstants.CENTER);
					diaBu.add(sj);
					diaBu.pack();
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
				}
			}
		});
		frame.getContentPane().add(btnNewButton_4); // button 2 zeug zu ende

		txtrInformationstext = new JLabel();
		txtrInformationstext.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrInformationstext.setText("Informationstext");
		frame.getContentPane().add(txtrInformationstext);

		frame.pack();
		frame.setVisible(true);

	}

	// TODO
	public void setTextInformation(String text) {
		txtrInformationstext.setText(text);
	}

	public String getTextInformation() {
		return txtrInformationstext.getText();
	}
}
