package de.university.reutlingen.aufgabe2.a3;

import java.util.ArrayList;

import de.university.reutlingen.aufgabe2.a3.ProductDescription.PriceLevel;


public class Main {

	public static void main(String[] args) {
		/*
		 * this is a hack. Should not do, just for save heaven.
		 * 1 Possibility
		 * http://www.angelikalanger.com/GenericsFAQ/FAQSections/ParameterizedTypes.html#FAQ105
		 */
		Produkt<String>[] products = new Produkt[1];
		products[0] = new Produkt<String>("Hate Apple", PriceLevel.EXCLUSIVE);
		for (Produkt<String> i : products) {
			System.out.println(i.getProduktBeschreibung() + " "+  i.getProduktPreis());
		}
		
		System.out.println("");
		
		/*
		 * Teacher basically wants create arraylist and put there Product object
		 * 2 Possibility 
		 */
		ArrayList<Produkt<String>> produktLists = new ArrayList<Produkt<String>>();
		produktLists.add(new Produkt<String>("sdfsd", PriceLevel.MEDIUM));

		for (Produkt<String> g : produktLists) {
			System.out.println(g.getProduktBeschreibung()+ " " + g.getProduktPreis());
		}

	}

}
