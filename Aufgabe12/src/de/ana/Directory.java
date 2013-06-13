package de.ana;

import java.util.*;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */
public class Directory implements Entry {

	public Directory(String name) {
		this.name = name;
	}

	String name;
	public int probel;
	int leer = 0;
	private List<Entry> eintraege = new LinkedList<Entry>();

	public void print() {
		for (int i = 0; i < leer; i++)
			System.out.print(" ");
		System.out.println(this.name);
		leer++;

		for (final Entry eintrag : eintraege) {
			if (eintrag instanceof Directory)
				((Directory) eintrag).leer += this.leer;
			else if (eintrag instanceof File) {
				for (int i = 0; i < leer; i++)
					System.out.print(" ");
			}
			eintrag.print();
		}
	}

	public int numberOfEntries() {
		int sum = eintraege.size();
		for (final Entry eintrag : eintraege) {
			if (eintrag instanceof Directory)
				sum += ((Directory) eintrag).eintraege.size();
		}
		return sum;
	}

	public void add(Entry entry) {
		eintraege.add(entry);
	}

	public void remove(Entry entry) {
		eintraege.remove(entry);
	}
}
