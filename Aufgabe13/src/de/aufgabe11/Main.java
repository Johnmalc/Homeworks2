package de.aufgabe11;

import java.util.*;
import java.util.Map.Entry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */

public class Main {
	public static void main(String[] args) {

		JFrame frame = new JFrame();
		JTextField txtKontoNummer = new JTextField();
		JTextField txtPinEingabe;
		JButton btnNewButton_1;
		JButton btnNewButton_2;
		JComboBox<String> comboBox;
		JButton btnNewButton_3;
		JButton btnNewButton_4;
		JTextArea txtrInformationstext;
		
		frame.setPreferredSize(new Dimension(400, 300));

		//frame.setSize(300, 250); // TODO size ob windows
		// frame.setBounds(260, 200, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(9, 1));
		txtKontoNummer.setText("Konto Nummer");
		frame.getContentPane().add(txtKontoNummer);
		txtKontoNummer.setColumns(10);

		JButton btnNewButton = new JButton("Karte eingeben");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		frame.getContentPane().add(btnNewButton);

		txtPinEingabe = new JTextField();
		txtPinEingabe.setText("Pin eingabe");
		frame.getContentPane().add(txtPinEingabe);
		txtPinEingabe.setColumns(10);

		btnNewButton_1 = new JButton("Pin bestatigen");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frame.getContentPane().add(btnNewButton_1);

		btnNewButton_2 = new JButton("Kontostand");
		frame.getContentPane().add(btnNewButton_2);

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] { "50", "100",
				"200", "500", "1000" }));
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

		HashMap<Integer, Account> ac = new HashMap<Integer, Account>();
		/*
		 * Prufen Sie vor und nach dem Hinzufugen der Elemente den Ruckgabewert
		 * der Methode isEmpty(). Gibt true wenn leer - false wenn besetzt
		 */
		System.out.println("Ist die Set leer : " + ac.isEmpty());

		// erstellung account objekten, die danach in map kommen
		Account das = new Account(23456789, 465, 06541, 5465);
		Account das2 = new Account(32846519, 4965, 8576, 3122);
		Account das3 = new Account(123456, 465, 06541, 2135);

		// Element der Klasse Account in die Map einfuegen
		ac.put(das.getAccountNumber(), das);
		ac.put(das2.getAccountNumber(), das2);
		ac.put(das3.getAccountNumber(), das3);

		System.out.println("\n" + "----------- Ausgabe der Map: -----------");
		System.out.println(ac.toString());

		// Gibt false zurueck, wenn die Map nicht leer ist
		System.out.println("Ist die Map leer : " + ac.isEmpty());

		// Gibt die Anzahl der Elementen in die Map zurueck
		System.out.println("Grosse der Maps : " + ac.size());

		/*
		 * Ausgabe mit der Hilfe des Interfaces Entry
		 */
		System.out.println("\n"
				+ "-----Ausgabe der Schlussel-Wert-Paar (Iterator): ----");
		for (Entry<Integer, Account> entry : ac.entrySet()) {
			System.out.println(entry.getKey() + "/" + entry.getValue());
		}
	}
}
