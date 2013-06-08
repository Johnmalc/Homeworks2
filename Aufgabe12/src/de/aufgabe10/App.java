package de.aufgabe10;

public class App {

	/**
	 * @param args
	 *            Solution : >
	 *            http://javapostsforlearning.blogspot.de/2012/09/composite
	 *            -design-pattern-in-java.html
	 */
	public static void main(String[] args) {
		Directory di = new Directory("C: User"); // verzeichniss
		
		Entry fi = new File("index.html"); // datei
		Entry fo = new File("index.html"); // datei

		di.add(fo);
		di.add(fi);

		di.prinVerschachtelteStruktur();
		System.out.println(di.numberOfEntries());

	}
}
