package de.aufgabe7.main;

import java.util.*;

public class Search {

	public static void main(String[] args) {

		int choseSearch = Integer.parseInt(args[0]);
		int yourNumbers = Integer.parseInt(args[1]);

		List<Integer> ls = new ArrayList<Integer>();
		for (int n = 0; n <= yourNumbers; n++) {
			ls.add(n);
		}

		// decision based on "choseSearch" var.
		if (choseSearch == 0) { // linear
			long start = System.nanoTime();
			System.out.println(Search.linear(ls, yourNumbers + 1));
			long stop = System.nanoTime();
			System.out.printf("Elapsed time %1$1d ns\n", stop - start);
		} else { // binar
			Collections.sort(ls);
			long start = System.nanoTime();
			System.out.println(Collections.binarySearch(ls, yourNumbers + 1));
			long stop = System.nanoTime();
			System.out.printf("Elapsed time %1$1d ns\n", stop - start);
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
