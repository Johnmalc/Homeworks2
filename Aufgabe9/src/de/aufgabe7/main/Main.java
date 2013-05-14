package de.aufgabe7.main;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long start = System.nanoTime();
		for (int i = 0; i < 100000; i++) {
			System.out.print(".");
		}
		long stop = System.nanoTime();
		System.out.printf("Elapsed time %1$10d ns\n", stop - start);
	}
}
