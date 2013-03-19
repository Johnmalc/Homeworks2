package malcjohn;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			// Testing one account
			// List<Account> acounts = new ArrayList<Account>();

			/*
			 * Erstellung eines accounts. Und auch eine Karte. Wenn sie bei
			 * card1.setPin() falsches pin eingeben, dann wie nach der aufgabe,
			 * kriegen sie scheiss
			 */
			Scanner scanYourNumber = new Scanner(System.in);

			Account account1 = new Account();
			System.out.println("Geben sie ihren account nummer");
			account1.setAccountNumber(scanYourNumber.nextInt());
			System.out.println("Geben sie ihren bank deposit");
			account1.setBankDeposit(scanYourNumber.nextInt());
			System.out.println("Geben sie dispo Kredit (overdraft) deposit");
			account1.setOverdraft(scanYourNumber.nextInt());
			System.out.println("Geben sie ihres Pin. Es muss 4 stellig sein");
			account1.setPin(scanYourNumber.nextInt());

			CashCard card1 = new CashCard();
			int cardNumber = account1.getAccountNumber();
			card1.setAccountNumber(cardNumber);
			System.out.println("Geben sie ihres Pin fur die Karte. Es muss 4 stellig sein");
			card1.setPin(scanYourNumber.nextInt());
			int card1Pin = card1.getPin();

			/**
			 * Fur zweiten Account Don't touch
			 */
			// Account account2 = new Account();
			// account2.setAccountNumber(123456789);
			// account2.setBankDeposit(54444000);
			// account2.setPin(5678);
			// CashCard card2 = new CashCard();
			// card2.setAccountNumber(123159147);
			// card2.setPin(1234);

			CashMachine a = new CashMachine(account1);
			/*
			 * Wenn diese Methode auskommentiert wird, dann informationen
			 * angezeigt Und pin uberpruft
			 */
			a.insertCashCard(card1);

			/**
			 * <b>Weitere Moglichkeit zum andern</b> Wenn diese methode enterPin
			 * kommentiert wird, dann keine karte im Automat und keine
			 * Informationen angezeigt werden Wenn card inserted,dann werden nur
			 * information angezeigt. Die Uberprufung wird nicht statfinden. Sie
			 * konnen auch hier die withdraw nicht nutzen Am besten testen mit
			 * mehr als 1000000 oder 10, sieht man ergebniss ?tested? withdraw -
			 * ja beides ?tested? statement - ja beides ?tested? pin -
			 */
			a.enterPin(card1Pin);
			a.accountStatement();
			a.withdraw(10000);
			a.ejectCashCard();

			// acounts.add(account1);
			// acounts.add(account2);

			// System.out.println(acounts.add(account1));

			/**
			 * leeres Object fur Automat indem man alle accounts gespeicher
			 * werden und mit jeweilige card abgeglichen werden (auch dort
			 * gespeichert)
			 */

			// CashMachine sc = new CashMachine();

			/**
			 * Speicherung account und eckarte im Automat (CM)
			 */
			// sc.setAccounts(account1);
			// sc.insertCashCard(card1);
			// sc.accountStatement();

			// try {
			// throw new Exception();
			// }catch (){
			//
			// }
			// Account info1 = new Account();
			// info1.setAccountNumber(54894651);
			// info1.setPin(4587);
			// info1.setBankDeposit(50000);
			// info1.setOverdraft(20000);
			//
			// Account info2 = new Account();
			// info2.setAccountNumber(54894651);
			// info2.setPin(4587);
			// info2.setBankDeposit(50000);
			// info2.setOverdraft(20000);
			//
			// ArrayList<Account> ac = new ArrayList<Account>();
			// ac.add(info1);
			// ac.add(info2);
			//
			//
			// System.out.println(info1.toString());
			// CashCard d = new CashCard(569788);
			//
			// // int r = d.getAccountNumber();
			// // System.out.println(r);
			//
			// CashMachine acc1 = new CashMachine(d);
			// CashCard a = acc1.getCashCard();
			// System.out.println(a);
			scanYourNumber.close();

		} catch (Exception msg) {
			System.out.println("Fehler, etwas is passiert");
			System.out.println(msg.getMessage());
		} catch (Error msg) {
			System.err.println(msg.getMessage());
		}
	}
}
