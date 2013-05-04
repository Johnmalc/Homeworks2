package de.reutlingen.a5.main;

import java.util.Iterator;

public class Main {
								
	public static void main(String[] args){
		Queue<String> str = new Queue<String>();
		
		System.out.println("Queue soll jetzt frei sein = " + str.isEmpty());
		
		str.push("Erstes Element");
		str.push("Zweites Element");
		str.push("Drittes Element");
		
		System.out.println("\nQueue ist jetzt voll (false): " + str.isEmpty());
		System.out.println("\n" + str.toString());  // Ausgabe aller Elementen der Queue
		System.out.println("\n" + "Grosse der queue : " + str.size());

		System.out.println("--------Print elements------");

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
		
	}

}
