package de.university.reutlingen.newVersion;

import java.util.ArrayList;
import de.university.reutlingen.newVersion.ProductDescription.*;

public class Main {

	public static void main(String[] args) {

		/*
		 * 
		 * Should not do. 1. Possibility
		 * http://www.angelikalanger.com/GenericsFAQ/FAQSections/ParameterizedTypes.html#FAQ105
		 * (Produkt<String>[]) doesn't have to be
		 */
		Produkt<String>[] products = (Produkt<String>[]) new Produkt[3];
		products[0] = new Produkt<String>("Ich liebe Apple", PriceLevel.EXCLUSIVE);
		products[1] = new Produkt<String>("I mag keine Porsche", PriceLevel.LOW);
		products[2] = new Produkt<String>("Ich kaufe Photoshop", PriceLevel.MEDIUM);

		for (Produkt<String> i : products) {
			System.out.println(i.getProduktBeschreibung() + " "	+ i.getProduktPreis());
		}

		System.out.println("");

		// This is better, because uses ArrayLists. For me, not teacher
		ArrayList<Produkt<String>> produktLists = new ArrayList<>();
		produktLists.add(new Produkt<String>("I kaufte Ticket fur ", PriceLevel.MEDIUM ));
		produktLists.add(new Produkt<String>("I lese WSJ ", PriceLevel.LOW ));

		for (Produkt<String> g : produktLists) {
			System.out.println(g.getProduktBeschreibung() + " "	+ g.getProduktPreis());
		}

	}

}
