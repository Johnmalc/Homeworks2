package de.aufgabe10;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */
public class App {

	/**
	 * Solution : > http://javapostsforlearning.blogspot.de/2012/09/composite
	 * -design-pattern-in-java.html
	 */
	public static void main(String[] args) {
		Directory di = new Directory("Main Dokument"); // verzeichniss

		File fi = new File("index.html"); // datei
		File fo = new File("sop.html"); // datei
		File fk = new File("stop.html"); // datei

		di.add(fo);
		di.add(fi);
		di.add(fk);

		Directory dp = new Directory("Privat"); // verzeichniss

		File fp = new File("SM"); // datei
		File fr = new File("WA"); // datei

		dp.add(fp);
		dp.add(fr);

		di.add(dp);
		
		di.prinVerschachtelteStruktur();
		System.out.println(di.getname() + "  " + di.numberOfEntries());

		System.out.println("  ");
		dp.prinVerschachtelteStruktur();
		System.out.println(dp.getname() + "  " + dp.numberOfEntries());

	}
}
