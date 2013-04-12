package de.university.aufgabe2;

import java.util.ArrayList;
import de.university.aufgabe2.ProductDescription.PriceLevel;

public class Main {

	public static void main(String[] args) {

		/*
		 * Read ReadMe file for exact exercise
		 * this is a hack. Should not do, just for save heaven. 1 Possibility
		 * http://www.angelikalanger.com/GenericsFAQ/FAQSections/ParameterizedTypes.html#FAQ105
		 * (Produkt<String>[]) doesn't have to be
		 */
		Produkt<String>[] products = (Produkt<String>[]) new Produkt[3];
		products[0] = new Produkt<String>("I Hate Apple", PriceLevel.EXCLUSIVE);
		products[1] = new Produkt<String>("I Hate Apple", PriceLevel.LOW);
		products[2] = new Produkt<String>("I Hate Apple", PriceLevel.MEDIUM);

		for (Produkt<String> i : products) {
			System.out.println(i.getProduktBeschreibung() + " "	+ i.getProduktPreis());
		}

		System.out.println("");

		// This is better, because uses ArrayLists. For me
		ArrayList<Produkt<String>> produktLists = new ArrayList<>();
		produktLists.add(new Produkt<String>("I have bought Apple for ", PriceLevel.MEDIUM));
		produktLists.add(new Produkt<String>("I read the Verge ", PriceLevel.LOW));

		for (Produkt<String> g : produktLists) {
			System.out.println(g.getProduktBeschreibung() + " "	+ g.getProduktPreis());
		}

	}

}
