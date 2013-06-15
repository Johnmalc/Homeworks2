import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Geldautomat {
	
		public CashMachine cashMachine;
		
		private  JFrame frame = new JFrame("Geldautomat");
		private  final JTextField nr = new JTextField();
		private  JTextField pinEingabe = new JTextField();
		private  JButton kAusgabe = new JButton("Karte ausgeben ");
		private  JButton pinBestätigen = new JButton(" PIN bestätigen");	
		private static  JLabel info = new JLabel("Informationstext");						
		private  JButton kEingabe = new JButton("Karte eingeben ");
		private  JButton kontostand = new JButton("Kontostand");
		private  JButton abheben = new JButton ("Geld abheben");
		private  JComboBox betrag = new JComboBox ();
		private  JPanel contentPane = new JPanel(new GridLayout(0,1));	
			
			
		public void fenster(final CashMachine cashMachine){
		
			setActiveComponents();
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			kEingabe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				cashMachine.insertCashCard(nr.getText());
				setActiveComponents();
				}
				});

			
			pinBestätigen.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
				cashMachine.enterPin(pinEingabe.getText());
				setActiveComponents();	
				}
			});
			
			
			
			
			kontostand.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
				
				String infoText="";
				
				infoText +="Kontostand: ";
				infoText +=cashMachine.getAmount();
				setInfoText(infoText);
					
				}
			});
			
			
			abheben.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					
				cashMachine.withdraw(betrag.getSelectedItem().toString())	;
				setActiveComponents();
				}
			});
			
			kAusgabe.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) {
					
				cashMachine.ejectCashCard();
				setActiveComponents();
				}
			});
			
			
			
			
			
			betrag.addItem(50);
			betrag.addItem(100);
			betrag.addItem(150);
			betrag.addItem(200);
			
			
			
			

			
			contentPane.setBorder(BorderFactory.createEmptyBorder(11,11,11,11));
			contentPane.add(nr);
			contentPane.add(kEingabe);
			contentPane.add(pinEingabe);
			contentPane.add(pinBestätigen);
			contentPane.add(kontostand);
			contentPane.add(betrag);
			contentPane.add(abheben);
			contentPane.add(kAusgabe);
			contentPane.add(info);
			
			
			
			
			frame.setContentPane(contentPane);		
			
			frame.pack();
			frame.setVisible(true);
			
		}
		
		public void setActiveComponents(){
				
				if(CashMachine.getStatus() == Status.READY){
					nr.setEnabled(true);
					kEingabe.setEnabled(true);
					
					pinEingabe.setEnabled(false);
					kAusgabe.setEnabled(false);
					pinBestätigen.setEnabled(false);
					kontostand.setEnabled(false);
					abheben.setEnabled(false);
					betrag.setEnabled(false);
				
				}
				else if(CashMachine.getStatus() == Status.CARD_INSERTED){
					
					pinEingabe.setEnabled(true);
					pinBestätigen.setEnabled(true);
					kAusgabe.setEnabled(true);
					
					nr.setEnabled(false);
					kEingabe.setEnabled(false);
					betrag.setEnabled(false);
					kontostand.setEnabled(false);
					abheben.setEnabled(false);
									
				}
				
				else if (CashMachine.getStatus() == Status.PIN_CORRECT){
					pinEingabe.setEnabled(false);
					pinBestätigen.setEnabled(false);
					nr.setEnabled(false);
					kEingabe.setEnabled(false);
					
					kAusgabe.setEnabled(true);
					kontostand.setEnabled(true);
					abheben.setEnabled(true);
					betrag.setEnabled(true);
					
					
				}
				else if (CashMachine.getStatus() == Status.PIN_WRONG){
					
					pinEingabe.setEnabled(true);
					pinBestätigen.setEnabled(true);
					kAusgabe.setEnabled(true);
					
					nr.setEnabled(false);
					kEingabe.setEnabled(false);
					betrag.setEnabled(false);
					kontostand.setEnabled(false);
					abheben.setEnabled(false);
					
				}
				
		}
	
				public static void setInfoText(String text){
					
					info.setText(text);
					
					
				}

}
