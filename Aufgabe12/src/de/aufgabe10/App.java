package de.aufgabe10;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Directory di = new Directory("C: User"); //verzeichniss
		File fi = new File("index.html"); // datei
		
		di.prinVerschachtelteStruktur();
		di.numberOfEntries();
		
		fi.prinVerschachtelteStruktur();
		fi.numberOfEntries();
	}

}
