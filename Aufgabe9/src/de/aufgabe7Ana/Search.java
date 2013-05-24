package de.aufgabe7Ana;

import java.util.*;

public class Search {

	public static void main(String[] args) {

		List<Integer> linkedList = new LinkedList<Integer>();
		int anzahlZif = Integer.parseInt(args[0]);
		int suchArt = Integer.parseInt(args[1]);

		for (int i = 0; i < anzahlZif; i++) {
			linkedList.add(i);
		}

		Collections.sort(linkedList);

		if (suchArt == 0) {
			long startLinear = System.nanoTime();
			lineareSuche(linkedList, anzahlZif);
			long stopLinear = System.nanoTime();
			System.out.printf("Elapsed time %1$10d ns\n", stopLinear
					- startLinear);
		} else {
			long start = System.nanoTime();
			Collections.binarySearch(linkedList, anzahlZif);
			long stop = System.nanoTime();
			System.out.printf("Elapsed time %1$10d ns\n", stop - start);
		}
	}

	public static void lineareSuche(List<Integer> linkedList, Integer key) {
		for (Integer n : linkedList) {
			if (n == key) {
			}
		}
	}
}
