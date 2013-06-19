package de.aufgabe11;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import de.aufgabe11.exc.*;

/*
 * Sources used
 * http://zetcode.com/tutorials/javaswingtutorial/swingevents/
 * http://stackoverflow.com/questions/10379527/trying-to-get-input-from-jtextfield-and-use-in-another-method
 * http://openbook.galileodesign.de/javainsel5/javainsel15_006.htm#Rxx747java150060400053E1F024100
 * 
 * We hate Swing. Yes, really. Who the fuck created it? In the future I will try to rewrite that in JavaFX. 
 * It will be in this package.
 */
public class Gui extends Vars {

	JFrame frame;

	public Gui() {

		frame = new JFrame("Unser Swing Bank Program");
		frame.setPreferredSize(new Dimension(500, 350)); // size of the windows
		frame.setBounds(250,0,200,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1));

		txtKontoNummer.setText("Konto Nummer");
		txtKontoNummer.setColumns(10);
		frame.getContentPane().add(txtKontoNummer);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Konto Eingabe
				 */
				try {
					int karteNummer = Integer.parseInt(txtKontoNummer.getText());
					CashCard kontoNummerObject = new CashCard(karteNummer);
					cashMaAccountList.insertCashCard(kontoNummerObject);
					txtKontoNummer.setEditable(false);
					btnNewButton.setEnabled(false);
					infoPanel.setText(" Karte eingegeben");
				} catch (CardInsertedException CAI) {
					diaBu.add(test2No);
					diaBu.pack();
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
				} catch (InvalidCardException ICE) {
					diaBu.add(test2No);
					diaBu.pack();
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
				} catch (NumberFormatException NFE) {
					infoPanel.setText(" fehler nur zahlen ");
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
				try {
					int pinNummer = Integer.parseInt(txtPinEingabe.getText());
					cashMaAccountList.pinEingeben(pinNummer);
					txtPinEingabe.setEditable(false);
					btnNewButton_1.setEnabled(false);
					infoPanel.setText(" Pin numer eingegeben");
				} catch (PinNotCorectException PNC) {
					diaBu.add(test3No);
					diaBu.pack();
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
				} catch (CardNotInsertedException CNIE) {
					diaBu.add(test3No);
					diaBu.pack();
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
				} catch (InvalidCardException ICE) {
					diaBu.add(test3No);
					diaBu.pack();
					diaBu.setLocationRelativeTo(null);
					diaBu.setVisible(true);
				} catch (NumberFormatException NFE) {
					System.out.println(" fehler nur zahlen ");
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

		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(freier);
		bgroup.add(auswahl);

		JPanel radioPanel = new JPanel();
		radioPanel.setLayout(new GridLayout(1,1));
		radioPanel.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(),
				"No = auswahl; Yes =  freier "));
		radioPanel.add(freier);
		radioPanel.add(auswahl);	
		frame.getContentPane().add(radioPanel);

		
		if (auswahl.isSelected()) {
			auswahl.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					final int zahl = (int) comboBox.getSelectedItem();
//				
					comboBox.setEnabled(true);
					frame.getContentPane().add(comboBox);
					System.out.println("kkkkkkkkkkkk");

//
//					btnNewButton_3.addActionListener(new ActionListener() {
//						public void actionPerformed(ActionEvent e) {
//							try {
//								cashMaAccountList.withdraw(zahl);
//							} catch (PinNotCorectException e1) {
//								diaBu.add(test3No);
//								diaBu.pack();
//								diaBu.setLocationRelativeTo(null);
//								diaBu.setVisible(true);
//							} catch (NotEnoughMoneyException e1) {
//								diaBu.add(test1No);
//								diaBu.pack();
//								diaBu.setLocationRelativeTo(null);
//								diaBu.setVisible(true);
//							}
//						}
//					});
//					frame.getContentPane().add(btnNewButton_3);
				}
			});
			frame.getContentPane().add(freier);
		} 
		
		if (freier.isSelected()) { //(freier.isSelected() == true) 
			freier.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					System.out.println("dsfffffffffff");
					eingabeBeitrags.setText("Eingabe beitrags");
					eingabeBeitrags.setEnabled(true);
					eingabeBeitrags.setColumns(10);
					final int freierBeitrag = Integer.parseInt(eingabeBeitrags.getText());
					frame.getContentPane().add(eingabeBeitrags);

//					btnNewButton_3.addActionListener(new ActionListener() {
//						public void actionPerformed(ActionEvent e) {
//							try {
//								cashMaAccountList.withdraw(freierBeitrag);
//							} catch (PinNotCorectException e1) {
//								diaBu.add(test3No);
//								diaBu.pack();
//								diaBu.setLocationRelativeTo(null);
//								diaBu.setVisible(true);
//							} catch (NotEnoughMoneyException e1) {
//								diaBu.add(test1No);
//								diaBu.pack();
//								diaBu.setLocationRelativeTo(null);
//								diaBu.setVisible(true);
//							}
//						}
//					});
//					frame.getContentPane().add(btnNewButton_3);
				}
			});
			frame.getContentPane().add(freier);
		}
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * Karte ausnehmen
				 */
				try {
					cashMaAccountList.ejectCashCard();
					btnNewButton.setEnabled(true);
					btnNewButton_1.setEnabled(true);
					btnNewButton_2.setEnabled(true);
					txtKontoNummer.setEditable(true);
					txtPinEingabe.setEditable(true);
				} catch (CardNotInsertedException e1) {
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
