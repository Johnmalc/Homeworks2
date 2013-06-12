package de.aufgabe10;

import java.util.*;

/**
 * Dmitrij Petrov Anastasia Baron
 */
public class Directory implements Entry {
	/*
	 * Component = manager
	 */
	String name;

	public Directory(String string) {
		this.name = string;
	}

	public String getname() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	List<Entry> doc = new LinkedList<Entry>();

	public void add(Entry en) {
		doc.add(en);
	}

	@Override
	public void prinVerschachtelteStruktur() {
		System.out.println("." + name);
		for (Entry re : doc) {
			re.prinVerschachtelteStruktur();
		}
	}

	@Override
	public int numberOfEntries() {
		int sum = 1; // ausgewaehltes Verzeichnis wird mitgezaehlt und muss

		for (int i = 0; i < doc.size(); i++) {
			sum += doc.get(i).numberOfEntries();
		}
		return sum;
	}

}
