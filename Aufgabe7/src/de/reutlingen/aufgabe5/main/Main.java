package de.reutlingen.aufgabe5.main;

public class Main {

	public static void main(String[] args) {
		Queue <String> str = new Queue <String>();
		System.out.println(str.isEmpty());
		str.push("Erstes Element");
		str.push("Zweites Element");
		str.push("Drittes Element");
		System.out.println(str.isEmpty());
		System.out.println(str.toString());
		System.out.println(str.size());
	}

}
