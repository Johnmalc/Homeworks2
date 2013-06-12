package de.aufgabe10;

/**
 * Dmitrij Petrov Anastasia Baron
 */
public class App {

	/**
	 * Solution : > http://javapostsforlearning.blogspot.de/2012/09/composite
	 * -design-pattern-in-java.html
	 */
	public static void main(String[] args) {
		Directory di = new Directory("Main Dokument"); // verzeichniss
		Directory dp = new Directory("Privat"); // verzeichniss

		File fi = new File("index.html"); // datei
		File fo = new File("index.html"); // datei

		File fp = new File("SM"); // datei
		File fr = new File("WA"); // datei
		
		di.add(fo);
		di.add(fi);

		dp.add(fp);
		dp.add(fr);
		
		di.add(dp);

		di.prinVerschachtelteStruktur();
		dp.prinVerschachtelteStruktur();
		System.out.println(di.numberOfEntries());

	}
}
