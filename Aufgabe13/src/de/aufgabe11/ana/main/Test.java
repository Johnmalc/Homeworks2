package de.aufgabe11.ana.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import de.aufgabe11.ana.exc.*;

public class Test {

	private JFrame frame = new JFrame("Geldautomat");
	private JPanel pane = new JPanel(new BorderLayout());// "Haupt"-Panel
	/*
	 * "Sub"-Panel, fuer Kontonummereingabe
	 */
	private JPanel paneKN = new JPanel(new GridLayout(0, 1));

	/*
	 * "Sub"-Panel fuer Pineingabe und andere Funktionen falls Kontonummer dem
	 * Accountnummer entspricht
	 */
	private JPanel paneREST = new JPanel(new GridLayout(0, 1));

	// Elemente fuer Karteeingabe
	private JLabel labelKN = new JLabel("Kontonummer: ");
	private JTextField textFeldKN = new JTextField();
	private JButton buttonKN = new JButton("Karte eingeben");
	// Elemenete fuer PIN-Eingabe
	private JLabel labelPin = new JLabel("PIN: ");
	private JTextField textFeldPin = new JTextField();
	private JButton buttonPin = new JButton("Pin bestaetigen");
	// Elemenete fuer Kontostand
	private JButton buttonKS = new JButton("Kontostand");
	// Info
	private JLabel labelInfo = new JLabel("Info");
	// Elemenete fuer Betragauswahl und geldabheben
	private JRadioButton JaNein = new JRadioButton("Betrag frei eingegeben");
	private JTextField betrag = new JTextField();
	Double betragAuswahl[] = { 50., 100., 150., 200. };
	private JComboBox<Double> betragWahl = new JComboBox<Double>(betragAuswahl);
	private JButton geldAbheben = new JButton("Geldabheben");
	// Button fuer Karteasugabe
	private JButton karteAus = new JButton("Karte Ausgeben");

	// Element von CashMachine
	CashMachine<Account> cashMachine = new CashMachine<Account>();

	// Methode, die den Text von Exception in Feld "labelInfo" schreibt
	private void InfoSchreiben(Exception e) {
		Test.this.labelInfo.setText(e.getLocalizedMessage());
	}

	// Konstruktor
	public Test() throws CardInsertedException, InvalidCardException {
		pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

		// Karte einfuegen
		buttonKN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					cashMachine.insertCashCard(new CashCard(Integer
							.parseInt(Test.this.textFeldKN.getText())));
					Test.this.paneREST.setVisible(true);
					Test.this.frame.setMinimumSize(new Dimension(250, 400));
					Test.this.paneKN.setVisible(false);
					textFeldKN.setText("");

					Test.this.labelInfo
							.setText("<HTML><BODY>Automat ist auf Status<BR> "
									+ cashMachine.getState()
									+ "  gesetzt.</BODY></HTML>");

				} catch (NumberFormatException e1) {
					InfoSchreiben(e1);
				} catch (CardInsertedException e1) {
					InfoSchreiben(e1);
				} catch (InvalidCardException e1) {
					InfoSchreiben(e1);
				}// end of Try/Catch
			}
		});

		// PIN-Ueberpruefung
		buttonPin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					cashMachine.pinEingeben(Integer
							.parseInt(Test.this.textFeldPin.getText()));
					Test.this.labelInfo
							.setText("<HTML><BODY>Automat ist auf Status <BR>"
									+ cashMachine.getState()
									+ " gesetzt.</BODY></HTML>");
					textFeldPin.setText("");
				} catch (NumberFormatException e1) {
					InfoSchreiben(e1);
				} catch (PinNotCorectException e1) {
					InfoSchreiben(e1);
				} catch (CardNotInsertedException e1) {
					InfoSchreiben(e1);
				}
			}
		});

		// Kontostand
		buttonKS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Test.this.labelInfo.setText(cashMachine
							.accountStatementToString());
				} catch (CardNotInsertedException e1) {
					InfoSchreiben(e1);
					System.out.println("yes");
				}
			}
		});

		// Betrag frei eingegeben
		JaNein.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (JaNein.isSelected()) {// falls Ja
					betragWahl.setVisible(false);
					paneREST.add(betrag, 5);
				} else {// falls Nein
					betragWahl.setVisible(true);
					paneREST.add(betrag, 5);
					paneREST.remove(betrag);
				}

			}

		});

		// Geldabheben
		geldAbheben.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				double betragDouble;
				try {
					if (JaNein.isSelected()) {
						betragDouble = Double.parseDouble(betrag.getText());
						//TO DO Exception falls Buchstaben
						
					} else {
						betragDouble=(Double)betragWahl.getSelectedItem();
					}
					cashMachine.withdraw(betragDouble);
					try {
						Test.this.labelInfo
								.setText("<HTML><BODY>Sie haben erfolgreich  <BR>"
										+ betragDouble
										+ "0 Euro abgehoben.  <BR>"
										+ cashMachine
												.accountStatementToString()
										+ "</BODY></HTML>");
					} catch (CardNotInsertedException e1) {
						InfoSchreiben(e1);
					}
				} catch (NotEnoughMoneyException e1) {
					InfoSchreiben(e1);
				} catch (PinNotCorectException e1) {
					InfoSchreiben(e1);
				}
				catch (NumberFormatException e1) {
					InfoSchreiben(e1);
					}
				}
		});

		// Karte ausgeben
		karteAus.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cashMachine.ejectCashCard();
					paneREST.setVisible(false);
					paneKN.setVisible(true);

					Test.this.labelInfo
							.setText("<HTML><BODY>Ihre Karte ist entfernt!<BR>Automat ist auf Status<BR>"
									+ cashMachine.getState()
									+ " gesetzt.</BODY></HTML>");

				} catch (CardNotInsertedException e1) {
					InfoSchreiben(e1);
				}
			}
		});
		labelInfo.setHorizontalAlignment(JLabel.CENTER);
		JaNein.setSelected(false);
		// Elemente fuer AccountNummer
		paneKN.add(labelKN);
		paneKN.add(textFeldKN);
		paneKN.add(buttonKN);

		// Elemente fuer Pin
		pane.add(paneKN, BorderLayout.NORTH);
		pane.add(paneREST, BorderLayout.CENTER);
		paneREST.add(labelPin);
		paneREST.add(textFeldPin);
		paneREST.add(buttonPin);
		paneREST.add(buttonKS);
		paneREST.add(JaNein);
		paneREST.add(betragWahl);
		paneREST.add(geldAbheben);
		paneREST.add(karteAus);
		paneREST.setVisible(false);

		labelInfo.setPreferredSize(new Dimension(200, 100));
		frame.setPreferredSize(new Dimension(250, 250));
		frame.getContentPane().add(pane, BorderLayout.CENTER);
		frame.getContentPane().add(labelInfo, BorderLayout.SOUTH);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
}
