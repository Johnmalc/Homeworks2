package de.notOurs;

public class Directory implements Entry {

	// Attribute
	private String name;
	private Entry[] list;
	private int numberOfEntries;

	// Konstruktor
	public Directory(String name, int maxEntries) {
		setName(name);
		numberOfEntries = 0;
		list = new Entry[maxEntries];
	}

	// Methoden
	public void addDirectory(Directory d) {
		list[numberOfEntries++] = d;
	}

	public void addFile(File f) {
		list[numberOfEntries++] = f;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void print() {
		System.out.println(name + ":");

		for (int i = 0; i < list.length; i++) {
			if (list[i] == null) {
				continue; // uberspringt bis zur naechsten Stelle}
			} else
				list[i].print();
		}
	}

	@Override
	public int numberOfEntries() {
		int sum = 1; // ausgewaehltes Verzeichnis wird mitgezaehlt und muss
						// wieder abgezogen

		for (int i = 0; i < list.length; i++) {
			if (list[i] == null) {
				break; // Bricht sofort ab
			} else
				sum += list[i].numberOfEntries();
		}
		return sum;
	}

}
