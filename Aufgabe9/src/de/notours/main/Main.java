package de.notours.main;

import java.util.*;

public class Main {

	public static void linearsuche(List<Integer> list, int suchzahl) {
		for (int O : list) {
			if (O == suchzahl)
				return;
		}
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 1000000; i++) {
			list.add(i);
		}
		int find = 500000;
		int durchschnittsgenauigkeit = 500;
		// Binary Search
		long start = System.nanoTime();
		Collections.binarySearch(list, find);

		long stop = System.nanoTime();
		System.out.println("Binary-BINARY");
		System.out.printf("Elapsed time %1$10d ns\n", stop - start);
		// Lineare Suche
		long start2 = System.nanoTime();
		linearsuche(list, find);
		long stop2 = System.nanoTime();
		System.out.println("::::::::::::::::::::::::");
		System.out.println("Linear");
		System.out.printf("Elapsed time %1$10d ns\n", stop2 - start2);

		// Durchschnitt berechnen
		long start3 = System.nanoTime();
		for (int c = 0; c < durchschnittsgenauigkeit; c++) {
			Collections.binarySearch(list, find);
		}
		long stop3 = System.nanoTime();
		System.out.println("average::::::::::::::::");
		System.out.println("Binary");
		System.out.printf("Elapsed time %1$10d ns\n", (stop3 - start3)
				/ durchschnittsgenauigkeit);

		// Durchschnitt berechnen
		long start31 = System.nanoTime();
		for (int c = 0; c < durchschnittsgenauigkeit; c++) {
			Collections.binarySearch(list, find);
		}
		long stop31 = System.nanoTime();
		System.out.println("average::::::::::::::::");
		System.out.println("Binary");
		System.out.printf("Elapsed time %1$10d ns\n", (stop31 - start31)
				/ durchschnittsgenauigkeit);
	}

}