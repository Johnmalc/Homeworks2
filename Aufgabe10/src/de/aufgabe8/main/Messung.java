package de.aufgabe8.main;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */
import java.util.*;

public class Messung {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		int anzahlElement = Integer.parseInt(args[0]);
		if (anzahlElement >= 1) {
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int i = 0; i < anzahlElement; i++) {
				map.put(i, "Wort " + i);
			}
			long startM = System.nanoTime();
			map.containsValue(anzahlElement);
			long stopM = System.nanoTime();
			System.out.printf("Elapsed time %1$10d ns\n", stopM - startM);
		} else {
			throw new Exception();
		}
	}
}
