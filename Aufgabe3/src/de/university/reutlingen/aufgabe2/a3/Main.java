package de.university.reutlingen.aufgabe2.a3;

import java.util.ArrayList;

import de.university.reutlingen.aufgabe2.a3.ProductDescription.PriceLevel;


public class Main {

	public static void main(String[] args) {
		/**
		 * Das Preissystem der Warenhaussoftware soll umgestellt werden. Produktpreise sollen nicht mehr
		 * beliebig vergeben werden können. Stattdessen gibt es 4 Preisstufen, denen ein Produkt 
		 * zugeordnet wird. Die Stufen sind LOW (9,99), MEDIUM (19,99), HIGH (49,99) und EXCLUSIVE 
		 * (99,99). Innerhalb der Warenhaussoftware sollen die Preisstufen durch einen Enum-Typ 
		 * (enum PriceLevel) reprasenstiert werden. Programmieren Sie den enum PriceLevel, 
		 * passen Sie die Klasse Product und Ihr Testprogramm aus Teilaufgabe (a) an.
		 * Hinweis: Der Preis muss als double-Datentyp im enum PriceLevel verwaltet werden.
		 * enum-Typ muss zusatzlich public String toString() uberschreiben (gibt den Preis
		 * als String zuruck) und einen privaten Konstruktor besitzen, der den Preis als Argument erhalt. 
		 */
		
		/*
		 * this is a hack. Should not do, just for save heaven.
		 * 1 Possibility
		 * http://www.angelikalanger.com/GenericsFAQ/FAQSections/ParameterizedTypes.html#FAQ105
		 */
		Produkt<String>[] products = new Produkt[1];
		products[0] = new Produkt<String>("I Hate Apple", PriceLevel.EXCLUSIVE);
		products[1] = new Produkt<String>("I Hate Apple", PriceLevel.LOW);
		products[2] = new Produkt<String>("I Hate Apple", PriceLevel.MEDIUM);
	
		or (Produkt<String> i : products) {
			System.out.println(i.getProduktBeschreibung() + " "+  i.getProduktPreis());
		}
		
		System.out.println("");
		
		// This is better, because uses ArrayLists. For me
		ArrayList<Produkt<String>> produktLists = new ArrayList<>();
		produktLists.add(new Produkt<String>("I have bought Apple for ", PriceLevel.MEDIUM));
		produktLists.add(new Produkt<String>("I read the Verge ", PriceLevel.LOW));

		for (Produkt<String> g : produktLists) {
			System.out.println(g.getProduktBeschreibung()+ " " + g.getProduktPreis());
		}

	}

}
