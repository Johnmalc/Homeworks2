package de.reutlingen.aufgabe55;

/**
 * @author Bjoern Kraus(722630), Muhammet Karakus(722629), Ayten Yilmaz(731224)
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Queue<String> schlange = new Queue<String>();

		System.out
				.println("Ergebniss der Methode .isEmpty() vor einfuegen des ersten Elements : "
						+ schlange.isEmpty());
		System.out.println("Groesse : " + schlange.size());
		System.out.println("");

		schlange.push("Erstes Element");
		schlange.push("Zweites Element");
		schlange.push("Drittes Element");

		System.out.println("Ausgabe der Warteschlange :");
		System.out.println("-------------------------------");
		System.out.println("");
		System.out.println(schlange);
		System.out.println("");
		System.out.println("Groesse : " + schlange.size());
		System.out
				.println("Ergebniss der Methode .isEmpty() nach einfuegen von Elementen : "
						+ schlange.isEmpty());
		System.out.println("");
		System.out.println("-------------------------------");
		System.out.println("");
		System.out.println("");

		try {
			System.out.println("Rueckgabe der Methode .pull() : "
					+ schlange.pull());
		}

		catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("--------------------------------");
		System.out.println("");

		System.out.println("");
		System.out.println("");
		System.out
				.println("Erneute Ausgabe nach verwendung der Methode .pull() ");
		System.out.println("---------------------------------");
		System.out.println("");
		System.out.println(schlange);
		System.out.println();

	}

}
