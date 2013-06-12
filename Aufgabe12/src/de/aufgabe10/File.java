package de.aufgabe10;

import java.util.LinkedList;
import java.util.List;

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
