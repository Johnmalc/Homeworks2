package de.aufgabe10;
/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */
public class File implements Entry {
	/*
	 * Leaf = listek
	 */
	String name;

	public File(String string) {
		this.name = string;
	}

	@Override
	public void prinVerschachtelteStruktur() {
		System.out.println("..." + this.name);
	}

	@Override
	public int numberOfEntries() {
		return name.length();
	}

}
