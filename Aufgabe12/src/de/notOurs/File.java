package de.notOurs;

public class File implements Entry {

	// Attribute
	private String name;

	// Konstruktor
	public File(String name) {
		setName(name);
	}

	// Methode
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public void print() {
		System.out.println(":::" + name);
	}

	@Override
	public int numberOfEntries() {
		return 1;
	}
}
