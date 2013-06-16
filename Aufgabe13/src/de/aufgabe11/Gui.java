package de.aufgabe11;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import de.aufgabe11.exc.*;

/*
 * Sources used
 * http://zetcode.com/tutorials/javaswingtutorial/swingevents/
 * http://stackoverflow.com/questions/10379527/trying-to-get-input-from-jtextfield-and-use-in-another-method
 * http://openbook.galileodesign.de/javainsel5/javainsel15_006.htm#Rxx747java150060400053E1F024100
 * 
 * We hate Swing. Yes, really. Who the fuck created it?
 */
public class Gui extends Vars {

	JFrame frame;

	public Gui(){

		frame = new JFrame("Unsere Swing Programma");
		frame.setPreferredSize(new Dimension(400, 300)); // size of the windows

		// where the window will be displayed
		frame.setBounds(690, 200, 500, 400);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(9, 1));

		txtKontoNummer.setText("Konto Nummer");
		txtKontoNummer.setColumns(10);
		frame.getContentPane().add(txtKontoNummer);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Konto Eingabe
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
		frame.getContentPane().add(btnNewButton);


		txtPinEingabe.setText("Pin eingabe");
		txtPinEingabe.setColumns(10);
		frame.getContentPane().add(txtPinEingabe);

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Pin Eingabe
				 */
				int pinNummer = Integer.parseInt(txtPinEingabe.getText());

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
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * Kontostand
				 */
				try {
					cashMaAccountList.accountStatement();
				} catch (CardNotInsertedException e) {

				}
			}
		});
		frame.getContentPane().add(btnNewButton_2);
		
		comboBox.setEnabled(true);
		frame.getContentPane().add(comboBox);

		btnNewButton_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				//TODO geld abheben
			}
		});
		frame.getContentPane().add(btnNewButton_3);
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Karte ausnehmen
				 */
				try {
					cashMaAccountList.ejectCashCard();
					diaBu.add(test4);
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
					diaBu.add(test4No);
					diaBu.pack();
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
				}
			}
		});
		frame.getContentPane().add(btnNewButton_4);
		
		infoPanel.setFont(new Font("Monospaced", Font.PLAIN, 13));
		frame.getContentPane().add(infoPanel);
		frame.pack();
		frame.setVisible(true);
	}
}
