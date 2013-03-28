package de.university.reutlingen.aufgabe2;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String[] array = new String[6];

		for (String i : array) {

			Produkt<String> pro;
			array[i] = new Produkt<String>("Produkt 1", 65.56);
			System.out.println(i);
		}
		
		for (int i =0; i < array.length;i++) {
			array[i] = new Produkt<String>("dfs",546);
		}
		
	}

}
