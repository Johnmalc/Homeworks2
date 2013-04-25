package de.reutlingen.aufgabe5.main;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) throws Exception {//TO DO Exception
		Queue<String> str = new Queue<String>();
		System.out.println(str.isEmpty()); // richtig = true
		str.push("Erstes Element");
		str.push("Zweites Element");
		str.push("Drittes Element");
		System.out.println(str.isEmpty()); // richtig = false
		//System.out.println(str.toString()); // was soll die machen ?
		System.out.println(str.size()); // funktieonier

		System.out.println("--------Print elents------");

		// Iterator prints all the elements of queue
		Iterator<String> it = str.getIterator();
		while (it.hasNext()) {
			System.out.println("Queue Next Value : " + it.next());
		}
		System.out.println("----Entfernt (und & print) elemente von pull--");

		System.out.println(str.pull());
		System.out.println(str.pull());
		System.out.println(str.pull());

		System.out.println("----------Nachdem sie alle entfernt werden---");
		while (it.hasNext()) {
			System.out.println("Queue Next Value : " + it.next());
		}
		System.out.println("Ist die queue frei: ? " + str.isEmpty());

		// Verwendung meiner Testklasse
		AnastasiaQueue<String> s =new AnastasiaQueue <String>();
		System.out.println(s.isEmpty());
		s.push("Erstes Element");
		s.push("Zweites Element");
		s.push("Drittes Element");
		System.out.println(s.toStringListNode());
		System.out.println(s.isEmpty());
		System.out.println(s.pull());
		System.out.println(s.pull());
		System.out.println(s.pull());
		System.out.println(s.isEmpty());
	}

}
