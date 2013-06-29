package de.aufgabe11.ana.main;

/**
 * @author Dmitry Petrov
 * @author Anastasia Baron
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import de.aufgabe11.ana.exc.*;

public class View {

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
	private JPanel paneNachKN = new JPanel(new GridLayout(0, 1));

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
	// Infofeld
	private JLabel labelInfo = new JLabel("Geben Sie Ihre Kontonummer ein");
	// Elemenete fuer Betragauswahl und geldabheben
	private JRadioButton jaNein = new JRadioButton("Betrag frei eingegeben");// Betrag
																				// frei
																				// eingeben
																				// oder
																				// auswahl
	private JTextField betrag = new JTextField();// hier soll den gewuenschten
													// Betrag frei eingegeben
													// werden
	Double betragAuswahl[] = { 50., 100., 150., 200. };
	private JComboBox<Double> betragWahl = new JComboBox<Double>(betragAuswahl);
	private JButton geldAbheben = new JButton("Geldabheben");
	// Button fuer Karteausgabe
	private JButton karteAus = new JButton("Karte Ausgeben");

	// Element von CashMachine
	CashMachine<Account> cashMachine;

	// Methode, die den Text von Exception in Feld "labelInfo" schreibt
	public void InfoSchreiben(Exception e) {
		View.this.labelInfo.setText(e.getLocalizedMessage());
	}

	// Zuweisen allen Componenten benoetigte Actionen
	public void addControllers(ActionListener karteEingeben,
			ActionListener pinEingeben, ActionListener kontoStand,
			ActionListener betragFrei, ActionListener geldAbheben,
			ActionListener karteAus) {
		buttonKN.addActionListener(karteEingeben);// Karte einfuegen
		buttonPin.addActionListener(pinEingeben);// PIN-Ueberpruefung
		buttonKS.addActionListener(kontoStand);// Kontostand zeigen
		jaNein.addActionListener(betragFrei);// Betrag muss frei eingegeben
												// werden
		this.geldAbheben.addActionListener(geldAbheben);// Gedl abheben
		this.karteAus.addActionListener(karteAus);// Karte vom Automat ausgeben
	}

	public int getTextKN() {// Liefert die eingetragene Kontonummer zurueck
		return Integer.parseInt(textFeldKN.getText());
	}

	public int getTextPIN() {// Liefert die eingetragene Pin zurueck
		return Integer.parseInt(textFeldPin.getText());
	}

	public boolean getFrei() {// Liefert den Boolean-Wert von RadioButton
								// "Betrag frei eingeben" zurueck
		return jaNein.isSelected();
	}

	public double getTextBetrag() {// Liefert den frei eingegebenen Betrag
									// zurueck
		return Double.parseDouble(betrag.getText());
	}

	public double GetTextBetragWahl() {//Liefert den ausgewaelten Betrag
										// zurueck
		return (Double) betragWahl.getSelectedItem();
	}

	/*
	 * Fuehrt die benoetigten Aenderungen in View 
	 * nach Action "Kontonummer eingeben"
	 */
	public void updateViewKN() { 
		View.this.paneNachKN.setVisible(true);
		View.this.frame.setMinimumSize(new Dimension(250, 400));
		View.this.paneKN.setVisible(false);
		textFeldKN.setText("");
		View.this.labelInfo.setText("<HTML><BODY>Automat ist auf Status<BR> "
				+ cashMachine.getState() + "  gesetzt.</BODY></HTML>");
	}

	/*
	 * Fuehrt die benoetigten Aenderungen in View 
	 * nach Action "Kontonummer eingeben"
	 */
	public void updateViewPin() {
		View.this.labelInfo.setText("<HTML><BODY>Automat ist auf Status <BR>"
				+ View.this.cashMachine.getState() + " gesetzt.</BODY></HTML>");
		textFeldPin.setText("");
	}
	
	/*
	 * Fuehrt die benoetigten Aenderungen in View 
	 * nach Action "Kontostand anzeigen"
	 */
	public void updateViewKS(String text) {
		View.this.labelInfo.setText(text);
	}

	/*
	 * Fuehrt die benoetigten Aenderungen in View, 
	 * wenn es gewuenscht war,den Betrag frei einzugeben
	 */
	public void updateViewBetragFrei() {
		paneNachKN.remove(betragWahl);
		labelInfo.setText("Nun koenen Sie den Betrag frei eingeben.");
		paneNachKN.add(betrag, 5);
		paneNachKN.updateUI();
	}

	/*
	 * Fuehrt die benoetigten Aenderungen in View, 
	 * wenn es nicht gewuenscht war, den Betrag frei einzugeben
	 */
	public void updateViewBetragNichtFrei() {
		paneNachKN.remove(betrag);
		labelInfo.setText("Waehlen Sie bitte den gewuenschten Betrag. ");
		paneNachKN.add(betragWahl, 5);
		paneNachKN.updateUI();
	}
	
	/*
	 * Fuehrt die benoetigten Aenderungen in View, 
	 * nach der Action "Geld abheben"
	 */
	public void updateViewGeldAbheben(Double betrag, String kontostand) {
		View.this.labelInfo.setText("<HTML><BODY>Sie haben erfolgreich  <BR>"
				+ betrag + "0 Euro abgehoben.  <BR>" + kontostand
				+ "</BODY></HTML>");
		View.this.betrag.setText("");
		View.this.jaNein.setSelected(false);
	}

	/*
	 * Fuehrt die benoetigten Aenderungen in View, 
	 * nach der Action "Karte asgeben"
	 */
	public void updateViewKarteAus() {
		paneNachKN.setVisible(false);
		paneKN.setVisible(true);
		View.this.labelInfo
				.setText("<HTML><BODY>Ihre Karte ist entfernt!<BR>Automat ist auf Status<BR>"
						+ cashMachine.getState() + " gesetzt.</BODY></HTML>");
	}

	// Konstruktor
	public View(final CashMachine<Account> cashMachine)
			throws CardInsertedException, InvalidCardException {
		this.cashMachine = cashMachine;
		pane.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
		labelInfo.setHorizontalAlignment(JLabel.CENTER);
		pane.add(paneKN, BorderLayout.NORTH);
		pane.add(paneNachKN, BorderLayout.CENTER);
		// Elemente fuer AccountNummer
		paneKN.add(labelKN);
		paneKN.add(textFeldKN);
		paneKN.add(buttonKN);

		// Elemente fuer Pin
		paneNachKN.add(labelPin);
		paneNachKN.add(textFeldPin);
		paneNachKN.add(buttonPin);
		
		paneNachKN.add(buttonKS);
		paneNachKN.add(jaNein);
		jaNein.setSelected(false);
		paneNachKN.add(betragWahl);
		paneNachKN.add(geldAbheben);
		paneNachKN.add(karteAus);
		paneNachKN.setVisible(false);

		labelInfo.setPreferredSize(new Dimension(200, 100));
		frame.setPreferredSize(new Dimension(350, 250));
		frame.getContentPane().add(pane, BorderLayout.CENTER);
		frame.getContentPane().add(labelInfo, BorderLayout.SOUTH);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
}
