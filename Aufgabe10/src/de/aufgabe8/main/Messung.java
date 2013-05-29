package de.aufgabe8.main;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import de.aufgabe8.exc.CardInsertedException;
import de.aufgabe8.exc.InvalidCardException;

public class Messung {

	/**
	 * @param args
	 * @throws InvalidCardException
	 * @throws CardInsertedException
	 */
	public static void main(String[] args) throws CardInsertedException,
			InvalidCardException {
		// TODO Auto-generated method stub
		Map map = new TreeMap<Integer, String>();
		for (int i = 0; i < 10000000; i++) {
			map.put(i, "Wort" + "i");

		}
		long startM = System.nanoTime();
		map.containsValue(10000000);
		long stopM = System.nanoTime();
		System.out.printf("Elapsed time %1$10d ns\n", stopM - startM);

		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 10000000; i++) {
			list.add(i);
		}
		long startL = System.nanoTime();
		for (Integer s : list) {
			if (s == 10000000) {
				
			}
		}
		long stopL = System.nanoTime();
		System.out.printf("Elapsed time %1$10d ns\n", stopL - startL);

	}
}
