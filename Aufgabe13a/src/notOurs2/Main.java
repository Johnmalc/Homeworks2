package notOurs2;

public class Main {
	public static void main(String[] args) {
		Account[] accounts = new Account[2];
		accounts[0] = new Account(12345, -2000, 10000, 1122);
		accounts[1] = new Account(98765, -5000, 50000, 2233);
		CashMachine cm1 = new CashMachine(accounts);
	}
}