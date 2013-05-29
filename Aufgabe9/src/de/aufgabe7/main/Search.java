package de.aufgabe7.main;

import java.util.*;

public class Search {

	public static void main(String[] args) throws Exception{
		// Auswahr der Art der Suche 0=linear, 1=binare
		int choseSearch = Integer.parseInt(args[0]);

		/*
		 * Anzahl der Elementen, die in der Liste geschpeichert werden von 0 bis
		 * yourNumber-1
		 */
		int yourNumbers = Integer.parseInt(args[1]);

		List<Integer> ls = new ArrayList<Integer>();
		for (int n = 0; n < yourNumbers; n++) {
			ls.add(n); // fuegt Elemente in die Liste ein
		}

		// decision based on "choseSearch" var.
		if (choseSearch == 0) { // linear
			long start = System.nanoTime();
			System.out.println(Search.linear(ls, yourNumbers));
			long stop = System.nanoTime();
			System.out.printf("Elapsed time %1$1d ns\n", stop - start);
		} else if (choseSearch == 1) { // binar
			Collections.sort(ls);
			long start = System.nanoTime();
			System.out.println(Collections.binarySearch(ls, yourNumbers));
			long stop = System.nanoTime();
			System.out.printf("Elapsed time %1$1d ns\n", stop - start);
		} else {
			throw new Exception();
		}
	}

	/*
	 * Static methode for linear search. key - element to search starting from 0
	 * We should use always the worst case (e.g. element is not find)
	 * 
	 * @return -1 if not find otherwise the position where is located
	 */
	public static int linear(List<Integer> list, int key) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == key) {
				return i;
			}
		}
		return -1;
	}
}
