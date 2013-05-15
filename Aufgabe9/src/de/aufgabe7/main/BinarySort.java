package de.aufgabe7.main;

import java.util.ArrayList;
import java.util.*;
import java.util.List;

public class BinarySort {
	public static void main(String[] args) {
		
		int chose = Integer.parseInt(args[0]);
		int yourNumber = Integer.parseInt(args[1]);
		
		int zahlTausend = 10_000;
		int zahlHundert = 100_000;
		int million = 1_000_000;
		int zehnMil  = 10_000_000;

		List<Integer> ls = new ArrayList<Integer>();
		for (int n = 0; n <= zahlTausend; n++) {
			System.out.println(ls.add(n));
		}
		Collections.sort(ls);
		
		System.out.println(ls.toString());
		
		System.out.println(Collections.binarySearch(ls, 2545));
		System.out.println("          ");


	}
}
