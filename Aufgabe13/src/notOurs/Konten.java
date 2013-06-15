package notOurs;

public class Konten {

	private Account[] accounts;

	public Konten() {

		accounts = new Account[2];

		accounts[0] = new Account(123456, 5500, 1234, 25600);
		accounts[1] = new Account(654321, 8000, 4321, 12500);

	}

	public Account[] getKonten() {

		return accounts;

	}

}