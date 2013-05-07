package de.aufgabe6.mengen;

import java.util.HashSet;
import java.util.Set;

public class FindDups {

	/*
	 * Schreiben Sie ein Programm, das die eingegebenen Kommandozeilenargumente
	 * (String args[]) daraufhin uberpruft, ob sie mehrfach oder einfach
	 * vorkommen. Dabei soll das Programm zwei Mengen (Set<T>) bestimmen, wobei
	 * die eine der Menge der Duplikate und die andere der Menge der Unikate
	 * entspricht. Das Programm soll am Ende die Menge der Duplikate und die
	 * Menge der Unikate ausgeben.
	 */

	public static void main(String[] args) {
		Set<String> duplikate = new HashSet<String>();
		Set<String> uni = new HashSet<String>();

		// for each string in a array args prove if uni cannt add a word,
		// if so add word to duplikate.
		for (String word : args) {
			if (!uni.add(word)) {
				duplikate.add(word);
			}
		}

		// diskrete mathe = bombastic !
		uni.removeAll(duplikate);

		System.out.println(uni);
		System.out.println(duplikate);

	}

}
