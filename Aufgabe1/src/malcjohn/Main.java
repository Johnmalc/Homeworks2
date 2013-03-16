package malcjohn;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// Testing one account
		// List<Account> acounts = new ArrayList<Account>();

		Account account1 = new Account(123159147, 5616.61);
		Account account2 = new Account(123456789, 5616.67);

		account1.setPin(1234);
		account2.setPin(5678);

		CashCard card1 = new CashCard(123159147, 1234);
		CashCard card2 = new CashCard(123456789, 5678);

		CashMachine a = new CashMachine(account1);
		a.insertCashCard(card2);

		a.enterPin(1234);
		a.accountStatement();

		// acounts.add(account1);
		// acounts.add(account2);

		account1.setOverdraft(35000);
		account2.setOverdraft(35000);

		// System.out.println(acounts.add(account1));

		/**
		 * leeres Object fur Automat indem man alle accounts gespeicher werden
		 * und mit jeweilige card abgeglichen werden (auch dort gespeichert)
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

	}
}
