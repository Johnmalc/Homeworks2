package de.notOurs2;

public class File implements Entry {

	private String name;

	public File(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void print() {
		System.out.println(this.name);
	}

	public int numberOfEntries() {
		return 0;
	}

}
