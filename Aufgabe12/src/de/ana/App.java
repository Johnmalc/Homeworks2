package de.ana;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Directory documente = new Directory("Documents");
		Directory kuendigung = new Directory("Kuendigungen");
		Directory haushalt = new Directory("Haushalt");
		Directory privat = new Directory("Privat");
		Directory sommer = new Directory("Sommer");
		Directory kuendigung1 = new Directory("K1");
		Directory kuendigung2 = new Directory("K2");

		File fileUrlaub = new File("Urlaub");
		File fileHochzeit = new File("Hochzeit");

		documente.add(kuendigung);
		documente.add(haushalt);
		privat.add(fileUrlaub);
		documente.add(privat);
		privat.add(fileHochzeit);
		kuendigung.add(kuendigung1);
		kuendigung.add(kuendigung2);
		privat.add(sommer);

		documente.print(); // Ausgabe der verschachtelten Struktur
		System.out.println(documente.numberOfEntries());// die Anzahl der
														// Eintraege
														// in dem jeweiligen
														// Teilbaum
		System.out.println(fileUrlaub.numberOfEntries());
	}
}
