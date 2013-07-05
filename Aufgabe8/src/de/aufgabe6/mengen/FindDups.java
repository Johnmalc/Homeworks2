package de.aufgabe6.mengen;

import java.util.*;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 */
public class FindDups {

	/*
	 * Schreiben Sie ein Programm, das die eingegebenen Kommandozeilenargumente
	 * (String args[]) daraufhin uberpruft, ob sie mehrfach oder einfach
	 * vorkommen. Dabei soll das Programm zwei Mengen (Set<T>) bestimmen, wobei
	 * die eine der Menge der Duplikate und die andere der Menge der Unikate
	 * entspricht. Das Programm soll am Ende die Menge der Duplikate und die
	 * Menge der Unikate ausgeben.
	 * 
	 * Man sollte List nutzen, nicht set, ware besser. Kein Abzug
	 */

	public static void main(String[] args) {
		Set<String> duplikate = new TreeSet<String>();
		Set<String> uni = new TreeSet<String>();

		// for each string in a array args prove if uni cant add a word,
		// if so add word to duplikate.
		for (String word : args) {
			if (!uni.add(word)) {
				duplikate.add(word);
			}
		}

		/*
		 * loescht alle Elemente in Mende uni, die es in Menge duplikate auch
		 * gibt, d.h. bleibt nur die Differenz von beiden Mengen
		 */
		uni.removeAll(duplikate);

		System.out.println(uni);
		System.out.println(duplikate);
	}
}
