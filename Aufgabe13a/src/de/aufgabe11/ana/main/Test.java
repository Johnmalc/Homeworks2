package de.aufgabe11.ana.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;
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
	private JLabel labelInfo = new JLabel("Geben Sie Ihre Kontonummer ein");
	// Elemenete fuer Betragauswahl und geldabheben
	private JRadioButton jaNein = new JRadioButton("Betrag frei eingegeben");
	private JTextField betrag = new JTextField();
	Double betragAuswahl[] = { 50., 100., 150., 200. };
	private JComboBox<Double> betragWahl = new JComboBox<Double>(betragAuswahl);
	private JButton geldAbheben = new JButton("Geldabheben");
	// Button fuer Karteasugabe
	private JButton karteAus = new JButton("Karte Ausgeben");

	// Element von CashMachine
	CashMachine<Account> cashMachine;

	// Methode, die den Text von Exception in Feld "labelInfo" schreibt
	public void InfoSchreiben(Exception e) {
		Test.this.labelInfo.setText(e.getLocalizedMessage());
	}

<<<<<<< HEAD
	public void addControllers(ActionListener karteEingeben,
			ActionListener pinEingeben, ActionListener kontoStand,
			ActionListener betragFrei, ActionListener geldAbheben,
			ActionListener karteAus) {
		buttonKN.addActionListener(karteEingeben);// Karte einfuegen
		buttonPin.addActionListener(pinEingeben);// PIN-Ueberpruefung
		buttonKS.addActionListener(kontoStand);// Kontostand zeigen
		jaNein.addActionListener(betragFrei);// Betrag muss frei eingegeben
												// werden
		this.geldAbheben.addActionListener(geldAbheben);
=======
	public void addControllers(ActionListener actionListenerKN,
			ActionListener actionListenerPIN) {
		buttonKN.addActionListener(actionListenerKN);// Karte einfuegen
		buttonPin.addActionListener(actionListenerPIN);// PIN-Ueberpruefung
>>>>>>> refs/remotes/origin/master
	}

	public int getTextKN() {
		return Integer.parseInt(textFeldKN.getText());
<<<<<<< HEAD
	}

	public int getTextPIN() {
		return Integer.parseInt(textFeldPin.getText());
	}

	public boolean getFrei() {
		return jaNein.isSelected();
	}

	public double getTextBetrag() {
		return Double.parseDouble(betrag.getText());
	}

	public double GetTextBetragWahl() {
		return (Double) betragWahl.getSelectedItem();
=======
	}

	public int getTextPIN() {
		return Integer.parseInt(textFeldPin.getText());
>>>>>>> refs/remotes/origin/master
	}

	public void updateViewKN() {
		Test.this.paneREST.setVisible(true);
		Test.this.frame.setMinimumSize(new Dimension(250, 400));
		Test.this.paneKN.setVisible(false);
		textFeldKN.setText("");
		Test.this.labelInfo.setText("<HTML><BODY>Automat ist auf Status<BR> "
				+ cashMachine.getState() + "  gesetzt.</BODY></HTML>");
		// countLabel.setText(prefix+counter.getCounter());

	}

	public void updateViewPin() {
		Test.this.labelInfo.setText("<HTML><BODY>Automat ist auf Status <BR>"
				+ Test.this.cashMachine.getState() + " gesetzt.</BODY></HTML>");
		textFeldPin.setText("");
	}

<<<<<<< HEAD
	public void updateViewKS(String text) {
		Test.this.labelInfo.setText(text);
	}

	public void updateViewBetragFrei() {
		paneREST.remove(betragWahl);
		labelInfo.setText("Nun koenen Sie den Betrag frei eingeben.");
		paneREST.add(betrag, 5);
		paneREST.updateUI();
	}

	public void updateViewBetragNichtFrei() {
		paneREST.remove(betrag);
		labelInfo.setText("Waehlen Sie bitte den gewuenschten Betrag. ");
		paneREST.add(betragWahl, 5);
		paneREST.updateUI();
	}

	public void updateViewGeldAbheben(Double betrag, String kontostand) {
		Test.this.labelInfo.setText("<HTML><BODY>Sie haben erfolgreich  <BR>"
				+ betrag + "0 Euro abgehoben.  <BR>" + kontostand
				+ "</BODY></HTML>");
		Test.this.betrag.setText("");
		Test.this.jaNein.setSelected(false);
	}

	public void updateViewKarteAus() {
		paneREST.setVisible(false);
		paneKN.setVisible(true);

		Test.this.labelInfo
				.setText("<HTML><BODY>Ihre Karte ist entfernt!<BR>Automat ist auf Status<BR>"
						+ cashMachine.getState() + " gesetzt.</BODY></HTML>");
=======
	// Konstruktor
	public Test(final CashMachine<Account> cashMachine) throws CardInsertedException,
			InvalidCardException {
		this.cashMachine = cashMachine;
		pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

		// Kontostand
		buttonKS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Test.this.labelInfo.setText(cashMachine.accountStatementToString());
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
					paneREST.remove(betragWahl);
					labelInfo.setText("Nun koenen Sie den Betrag frei eingeben.");
					// betragWahl.setVisible(false);
					paneREST.add(betrag, 5);
					paneREST.updateUI();

				} else {// falls Nein
					// betragWahl.setVisible(true);
					paneREST.remove(betrag);
					labelInfo.setText("Waehlen Sie bitte den gewuenschten Betrag. ");
					paneREST.add(betragWahl, 5);
					paneREST.updateUI();

				}
			}
		});
>>>>>>> refs/remotes/origin/master

	}

<<<<<<< HEAD
	// Konstruktor
	public Test(final CashMachine<Account> cashMachine)
			throws CardInsertedException, InvalidCardException {
		this.cashMachine = cashMachine;
		pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
=======
			public void actionPerformed(ActionEvent e) {
				double betragDouble;
				try {
					if (JaNein.isSelected()) {
						betragDouble = Double.parseDouble(betrag.getText());
						// TO DO Exception falls Buchstaben

					} else {
						betragDouble = (Double) betragWahl.getSelectedItem();
					}
					cashMachine.withdraw(betragDouble);
					try {
						Test.this.labelInfo
								.setText("<HTML><BODY>Sie haben erfolgreich  <BR>"
										+ betragDouble
										+ "0 Euro abgehoben.  <BR>"
										+ cashMachine.accountStatementToString()
										+ "</BODY></HTML>");
					} catch (CardNotInsertedException e1) {
						InfoSchreiben(e1);
					}
				} catch (NotEnoughMoneyException e1) {
					InfoSchreiben(e1);
				} catch (PinNotCorectException e1) {
					InfoSchreiben(e1);
				} catch (NumberFormatException e1) {
					InfoSchreiben(e1);
				}
			}
		});
>>>>>>> refs/remotes/origin/master

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
		jaNein.setSelected(false);
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
		paneREST.add(jaNein);
		paneREST.add(betragWahl);
		paneREST.add(geldAbheben);
		paneREST.add(karteAus);
		paneREST.setVisible(false);

		labelInfo.setPreferredSize(new Dimension(200, 100));
		frame.setPreferredSize(new Dimension(350, 250));
		frame.getContentPane().add(pane, BorderLayout.CENTER);
		frame.getContentPane().add(labelInfo, BorderLayout.SOUTH);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
}
