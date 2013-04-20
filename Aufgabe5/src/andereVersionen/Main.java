package andereVersionen;

public class Main {

	public static void main(String[] args) throws NullPointerException {

		Account acc1 = new Account(5, 1.22f, 4.55f);
		Account acc2 = new Account(9, 7.66f, 9.44f);
		Account acc3 = new Account(10, 8.66f, 11.44f);

		try {
			List<Account> test = new List<Account>();
			System.out.println("Insert First Aufruf");
			test.insertFirst(acc3); // Account 3 als erstes Element
			System.out.println(test.get(0)); // printen von Account 3
			System.out.println();
			System.out.println("add aufruf:");
			test.add(acc2); // Adden von Account 1
			// False da kein Account hinzugefegt
			System.out.println(test.isEmpty()); // False, da nicht leer

			System.out.println();
			System.out.println("size aufruf:");
			System.out.println(test.size()); // R�ckgabe 2, da 2 Accounts
			System.out.println();

			System.out.println("get(1) aufruf:");
			test.add(acc1);
			System.out.println(test.get(1)); // Ausgabe Account 2

			System.out.println();

			System.out.println("get(2) aufruf:");
			test.add(acc2);
			System.out.println(test.get(2));

			System.out.println();

			System.out.println("Account 3");
			// test.add(acc3);
			System.out.println(test.get(3));

			System.out.println();
			System.out.println("Erneuter size Aufruf");
			System.out.println(test.size());

		} catch (NullPointerException exc) {

			System.out.println("Fehler");

		}

	}
}
