package malcjohn;

public class Main {

	public static void main(String[] args) {
		// Testing one account

		Account acount1 = new Account(516516, 5616.61, 1321);
		CashCard card = new CashCard(123456, 123);

		CashMachine sc = new CashMachine();

		sc.setAccounts(acount1);

		sc.insertCashCard(card);

		System.out.println(acount1.getBankDeposit());
		System.out.println(acount1.getPin());
		System.out.println("You are now in the account");
		sc.accountStatement();

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
