package de.aufgabe11;

import java.util.*;

import javax.swing.*;

import de.aufgabe11.exc.CardInsertedException;
import de.aufgabe11.exc.CardNotInsertedException;
import de.aufgabe11.exc.InvalidCardException;
import de.aufgabe11.exc.PinNotCorectException;

import java.awt.*;
import java.awt.event.*;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 * http://zetcode.com/tutorials/javaswingtutorial/swingevents/
 * http://stackoverflow.com/questions/10379527/trying-to-get-input-from-jtextfield-and-use-in-another-method
 * http://openbook.galileodesign.de/javainsel5/javainsel15_006.htm#Rxx747java150060400053E1F024100
 * 
 * We hate Swing. Yes, really. Who the fuck created it?
 */

public class Main {
	public static void main(String[] args) {
		/*
		 * List of Account =  for iterators in the bottom
		 * CashMashine for its own class
		 */
		LinkedList<Account> linkedList = new LinkedList<Account>();
		final CashMachine<Account> cashMaAccountList = new CashMachine<Account>();

		JFrame frame;
		final JTextField txtKontoNummer;
		final JTextField txtPinEingabe;
		final JButton btnNewButton_1;
		final JButton btnNewButton_2;
		final JComboBox<String> comboBox;
		final JButton btnNewButton_3;
		final JButton btnNewButton_4;
		final JTextArea txtrInformationstext;

		frame = new JFrame("Unsere Swing Programma");
		frame.setPreferredSize(new Dimension(400, 300)); // size of the windows
		
		// where the window will be displayed
		frame.setBounds(690, 200, 500, 400);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(9, 1));
		
		/*
		 * 1. Konto nummer - TextField 
		 * 2. Karte eingeben - Button 
		 * 3. Pin eingabe - TextField 
		 * 4. Pin bestatigen - Button 
		 * 5. Kontostand - Button 
		 * 6. Choice - Combobox 
		 * 7. Geld abheben - Button 
		 * 8. Karte ausgeben - Button
		 * 9. info text > potreba vybrat
		 */
		txtKontoNummer = new JTextField();
		txtKontoNummer.setText("Konto Nummer");
		txtKontoNummer.setColumns(10);
		frame.getContentPane().add(txtKontoNummer);

/* --------------------------------- Jedem ------------------- */

		JButton btnNewButton = new JButton("Karte eingeben");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Asks for the input, which comes from JTetxField, parses to int and saves under karteNummer. 
				 * This then is saved & goes into the similar object
				 */
				int karteNummer = Integer.parseInt(txtKontoNummer.getText());
				CashCard kontoNummerObject = new CashCard(karteNummer);
				
				txtKontoNummer.setEditable(true);
//				txtKontoNummer.setText(" Schreiben sie jetzt ihre Pin ");

				try {
					cashMaAccountList.insertCashCard(kontoNummerObject);
				} catch (CardInsertedException CAI) {					
					JDialog diaBu = new JDialog();
					JLabel sj = new JLabel("Test2 ist erfolgreich. Sie konnen ihre pin setzen", SwingConstants.CENTER);
					diaBu.add(sj);
					diaBu.setSize(200, 250);
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
				
				} catch (InvalidCardException ICE) {
					JDialog diaBu = new JDialog();
					JLabel sj = new JLabel("Test2 ist nicht bestanden. Falsch.", SwingConstants.CENTER);
					diaBu.add(sj);
					diaBu.setSize(200, 250);
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
				}
				
				// TODO prove if pin from Account == pin from Scanner
//				JDialog diaBu = new JDialog();
//				JLabel sj = new JLabel("ds", SwingConstants.CENTER);
//				diaBu.add(sj);
//				diaBu.setSize(200, 250);
//				diaBu.setLocationRelativeTo(null);
//				diaBu.setVisible(true);

			}
		}); // button zeug ende
		frame.getContentPane().add(btnNewButton);

		/* -------------------- dalsi ------------- */

		txtPinEingabe = new JTextField();
		txtPinEingabe.setText("Pin eingabe");
		frame.getContentPane().add(txtPinEingabe);
		txtPinEingabe.setColumns(10);

		btnNewButton_1 = new JButton("Pin bestatigen");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Asks for the input, which comes from JTetxField, parses to
				 * int and saves under karteNummer. This then is saved & goes
				 * into the similar object
				 */
				int pinNummer = Integer.parseInt(txtKontoNummer.getText());

				txtKontoNummer.setEditable(true);
				txtKontoNummer.setText(" Schreiben sie jetzt ihre Pin ");

				try {
					cashMaAccountList.pinEingeben(pinNummer);
				} catch (PinNotCorectException PNC) {
					JDialog diaBu = new JDialog();
					JLabel sj = new JLabel("Test3 ist erfolgreich. Pin war richtig",SwingConstants.CENTER);
					diaBu.add(sj);
					diaBu.setSize(200, 250);
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
				} catch (CardNotInsertedException CNIE) {
					JDialog diaBu = new JDialog();
					JLabel sj = new JLabel("Test3 ist nicht bestanden. Pin ware falsch",SwingConstants.CENTER);
					diaBu.add(sj);
					diaBu.setSize(200, 250);
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
				} catch (InvalidCardException ICE) {
					JDialog diaBu = new JDialog();
					JLabel sj = new JLabel("Test3 ist nicht bestanden. Pin ware falsch",SwingConstants.CENTER);
					diaBu.add(sj);
					diaBu.setSize(200, 250);
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
				}
				//
				// JDialog diaBu = new JDialog();
				// JLabel sj = new JLabel("Richtig", SwingConstants.CENTER);
				// diaBu.add(sj);
				// diaBu.setSize(200, 250);
				// diaBu.setLocationRelativeTo(null);
				// diaBu.setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton_1); // button 2 zeug zu ende
		// TODO bude jeste vetsi prdel
		btnNewButton_2 = new JButton("Kontostand");
		frame.getContentPane().add(btnNewButton_2);

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[]{"50",
				"100", "200", "500", "1000"}));
		frame.getContentPane().add(comboBox);

		btnNewButton_3 = new JButton("Geld abheben");
		frame.getContentPane().add(btnNewButton_3);

		btnNewButton_4 = new JButton("Kate ausgeben");
		frame.getContentPane().add(btnNewButton_4);

		txtrInformationstext = new JTextArea();
		txtrInformationstext.setFont(new Font("Monospaced", Font.PLAIN, 13));
		txtrInformationstext.setText("Informationstext");
		frame.getContentPane().add(txtrInformationstext);

		frame.pack();
		frame.setVisible(true);

		/*
		 * Prufen Sie vor und nach dem Hinzufugen der Elemente den Ruckgabewert
		 * der Methode isEmpty(). Gibt true wenn leer - false wenn besetzt
		 */
		System.out.println("Ist die Set leer : " + linkedList.isEmpty());

		System.out.println("\n" + "----------- Ausgabe der Map: -----------");
		System.out.println(linkedList.toString());

		// Gibt false zurueck, wenn die Map nicht leer ist
		System.out.println("Ist die Map leer : " + linkedList.isEmpty());

		// Gibt die Anzahl der Elementen in die Map zurueck
		System.out.println("Grosse der Maps : " + linkedList.size());

	}
}
