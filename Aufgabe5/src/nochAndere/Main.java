package nochAndere;

import java.util.Iterator;
public class Main {
	public static void main(String[] args) {
		List<Integer> l = new List<Integer>();
		System.out.println("Die List hat keine Daten enthalten:" + " "
				+ l.isEmpty());
		l.insertFirst(3);
		l.add(2);
		l.add(5);
		l.add(7);
		l.add(1);
		l.add(1);
		l.insertFirst(0);
		System.out.println(l);
		System.out.println("Die List ist nach der Bef�llung noch leer:" + " "
				+ l.isEmpty());
		System.out.println("Menge der Elemente in der List:" + " " + l.size());
		System.out
				.println("Welches Element ist an meiner gew�nschten Position?"
						+ " " + l.get(3));

		Iterator<Object> i = l.getIterator();
		// Solange mir meine hasNext true liefert wird mir in meiner println die
		// zahlen ausgegeben.
		while (i.hasNext() == true) {
			System.out.println(i.next());
		}

	}
}
