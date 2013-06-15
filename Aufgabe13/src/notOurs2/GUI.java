import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI
{ 
	JFrame frame = new JFrame("Geldautomat");
	JPanel panel = new JPanel();
	JLabel infobox = new JLabel();

	JButton cardInsert = new JButton ("Karte eingeben");
	JButton pinbestaetigen = new JButton ("PIN Bestätigen");
	JButton kontostand = new JButton ("Kontostand");
	JButton abheben = new JButton ("Geld abheben");
	JButton ejectCard = new JButton ("Karte ausgeben");
	
	Integer [] betragstrings = {10, 20, 50, 100, 250, 500, 1000};
	JComboBox betraglist = new JComboBox (betragstrings);
	
	
	JTextField kNr = new JTextField ("Kontonummer");
	JTextField pineingabe = new JTextField ("Pin");
	
	CashMachine cm;
	private int amount;
	public GUI(CashMachine cm1)
	{
		
	 cm = cm1;
	 panel.setLayout(new GridLayout(10,1));
	 panel.add(kNr);
	 panel.add(cardInsert);
	 panel.add(pineingabe);
	 panel.add (pinbestaetigen);
	 panel.add(kontostand);
	 panel.add(betraglist);
	 panel.add(abheben);
	 panel.add(ejectCard);
	 panel.add(infobox);
	 
	 frame.getContentPane().add(panel);
	 frame.setSize(800, 640);
	 frame.setVisible(true);
	 
	 betraglist.setSelectedIndex(6);
	 
	  cardInsert.addActionListener (new ActionListener()
	  {
		  public void actionPerformed(ActionEvent e) {
		
			  int kartennummer = Integer.parseInt(kNr.getText());
			  cm.insertCashCard(kartennummer);
		  }
	  });
	  
	  pinbestaetigen.addActionListener(new ActionListener()
	  {
		  public void actionPerformed(ActionEvent e){
			  
			  int pin = Integer.parseInt (pineingabe.getText());
			  cm.enterPin(pin);
			  
		  }
	  });
	  
	  kontostand.addActionListener(new ActionListener()
	  {
		  public void actionPerformed (ActionEvent e){
			  
			  cm.accountStatement();
			  
		  }
	  });
	  
	  betraglist.addActionListener(new ActionListener()
	  {
		  public void actionPerformed (ActionEvent e){
		  }
	  });
	  
	  abheben.addActionListener (new ActionListener()
	  {
		  public void actionPerformed (ActionEvent e){
		  amount = (int) (betraglist.getSelectedItem());
		  cm.withdraw(amount);	  
		  }
	  });
	  
	  ejectCard.addActionListener(new ActionListener()
	  {
		  public void actionPerformed (ActionEvent e){
		  cm.ejectCashCard();  
		  }
	  });
	  
	  
	  
	  
	}
}
