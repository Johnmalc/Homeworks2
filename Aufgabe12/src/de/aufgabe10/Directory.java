package de.aufgabe10;

import java.util.*;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */
public class Directory implements Entry {
	/*
	 * Composite = manager
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
		return doc.size();
	}

}
