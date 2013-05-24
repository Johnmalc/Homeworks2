package de.notours.main;

import java.util.*;

public class testLine {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> da = new ArrayList<Integer>();
		da.add(10);
		da.add(5);
		da.add(54);
		da.add(3);
		lineareSuche(da, 11);
		System.out.println(linear(da, 11));
	}

	public static void lineareSuche(List<Integer> linkedList, Integer key) {
		for (Integer n : linkedList) {
			if (n == key) { // Suspicious comparison of Integer references in
							// de.notours.main.testLine.lineareSuche(List,
							// Integer)
				System.out.println("found");
			} else {
				System.out.println("niot");
			}
		}
	}

	public static int linear(List<Integer> list, int key) {
		for (Integer n : list) {
			if (list.get(n) == key) {
				return n;
			}
		}
		return -1;
	}

}
