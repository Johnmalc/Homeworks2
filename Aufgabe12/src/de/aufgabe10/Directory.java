package de.aufgabe10;

import java.util.*;

public class Directory implements Entry {
	/*
	 * Component = manager
	 */
	String name;
	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}
	public Directory(String string) {
		this.name = string;
	}
	List<Entry> b = new LinkedList<Entry>();
	public void add(Entry en) {
		b.add(en);
	}

	@Override
	public void prinVerschachtelteStruktur() {
		System.out.println(name);
		for (Entry re : b) {
			re.prinVerschachtelteStruktur();
		}
	}

	@Override
	public int numberOfEntries() {
		return b.size();
	}

}
