package de.notOurs2;

public class App {
	public static void main(String[] args) {
		Directory d1 = new Directory("Verzeichnis 1");
		Directory d2 = new Directory("Verzeichnis 2");
		Directory d3 = new Directory("Verzeichnis 3");

		File f1 = new File("File 1");
		File f2 = new File("File 2");
		File f3 = new File("File 3");
		File f4 = new File("File 4");

		d1.addInhalt(f1);
		d1.addInhalt(d2);
		d2.addInhalt(f2);
		d2.addInhalt(f3);
		d2.addInhalt(d3);
		d3.addInhalt(f4);

		d1.print();
	}
}
