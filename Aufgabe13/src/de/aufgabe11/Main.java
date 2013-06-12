package de.aufgabe11;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 * http://zetcode.com/tutorials/javaswingtutorial/swingevents/
 * We hate Swing
 */

public class Main {
	public static void main(String[] args) {

		LinkedList<Account> ac = new LinkedList<Account>();

		JFrame frame;
		JTextField txtKontoNummer;
		JTextField txtPinEingabe;
		JButton btnNewButton_1;
		JButton btnNewButton_2;
		JComboBox<String> comboBox;
		JButton btnNewButton_3;
		JButton btnNewButton_4;
		JTextArea txtrInformationstext;

		frame = new JFrame();
		frame.setPreferredSize(new Dimension(400, 300)); // size of the windows
		/*
		 * where the window will be displayed
		 */
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

		// Account das2 = new Account(32846519, 4965, 8576, 3122);
		// Account das3 = new Account(123456, 465, 06541, 2135);
		//
		// // Element der Klasse Account in die Map einfuegen
		// ac.put(das2.getAccountNumber(), das2);
		// ac.put(das3.getAccountNumber(), das3);

		JButton btnNewButton = new JButton("Karte eingeben");
		frame.getContentPane().add(btnNewButton);
		/*
		 * http://openbook.galileodesign.de/javainsel5/javainsel15_006.htm#Rxx747java150060400053E1F024100
		 */
		btnNewButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		// TODO prove if pin from Account == pin from Scanner
				JDialog diaBu = new JDialog();
				JLabel sj = new JLabel("Richtig", SwingConstants.CENTER);
				diaBu.add(sj);
				diaBu.setSize(200, 250);
				diaBu.setLocationRelativeTo(null);
				diaBu.setVisible(true);
			}
		});
		
		txtPinEingabe = new JTextField();
		txtPinEingabe.setText("Pin eingabe");
		frame.getContentPane().add(txtPinEingabe);
		txtPinEingabe.setColumns(10);

		btnNewButton_1 = new JButton("Pin bestatigen");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog diaBu = new JDialog();
				JLabel sj = new JLabel("Richtig", SwingConstants.CENTER);
				diaBu.add(sj);
				diaBu.setSize(200, 250);
				diaBu.setLocationRelativeTo(null);
				diaBu.setVisible(true);
			}
		});
		frame.getContentPane().add(btnNewButton_1);

		btnNewButton_2 = new JButton("Kontostand");
		frame.getContentPane().add(btnNewButton_2);

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "50",
				"100", "200", "500", "1000" }));
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
		System.out.println("Ist die Set leer : " + ac.isEmpty());

		System.out.println("\n" + "----------- Ausgabe der Map: -----------");
		System.out.println(ac.toString());

		// Gibt false zurueck, wenn die Map nicht leer ist
		System.out.println("Ist die Map leer : " + ac.isEmpty());

		// Gibt die Anzahl der Elementen in die Map zurueck
		System.out.println("Grosse der Maps : " + ac.size());

	}
}
