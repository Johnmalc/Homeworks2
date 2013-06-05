package de.notOurs;

public class App {

	public static void main(String[] args) {
		// Root verzeichnis
		Directory Wurzel = new Directory("Wurzel", 3);

		// Unterverzeichnis erstellen
		Directory second = new Directory("1.Ast", 4);
		Directory third = new Directory("2.Ast", 2);

		// Unterverzeichnis zu Root hinzufuegen
		Wurzel.addDirectory(second);
		Wurzel.addDirectory(third);

		// Files zum Unterverzeichnis hinzufuegen
		second.addFile(new File("null"));
		second.addFile(new File("eins"));
		second.addFile(new File("zwei"));
		second.addFile(new File("drei"));
		third.addFile(new File("eins"));

		// Ausgabe
		Wurzel.print();
		System.out.println("Sum Entries " + Wurzel.numberOfEntries());

	}
}
