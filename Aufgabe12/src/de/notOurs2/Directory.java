package de.notOurs2;

import java.util.ArrayList;

public class Directory implements Entry {
	private String name;

	public Directory(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	ArrayList<Entry> al = new ArrayList<Entry>();

	public void addInhalt(Entry entry) {
		al.add(entry);
	}

	public void print() {
		System.out.println(name + "----> Enth�lt " + numberOfEntries()
				+ " Eintr�ge:");
		for (Entry e : al) {
			e.print();
		}
	}

	public int numberOfEntries() {
		return al.size();
	}

}
