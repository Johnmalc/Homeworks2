package de.university.reutlingen.aufgabe2.a1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		/*
		 * this is a hack. Should not do, just for save heaven. Looks horrible
		 * http://www.angelikalanger.com/GenericsFAQ/FAQSections/ParameterizedTypes.html#FAQ105
		 */
		
		/**
		 * In der Aufgabe steht, dass die Produkte in einem Array gespeichert werden muessen 
		 * Es ist keine ArrayList, von mir aus, sondern ganz normale Array,
		 *  wie du dass zuerst gemacht hast.
		 *  Lass das so:
		 *  
		 *  Produkt<String>[] products =  new Produkt[3];
		 *  products[0] = new Produkt<String>("Java Editor 7.0 ", 99.99);
		 *  products[1] = new Produkt<String>("Photoshop CS5 von Adobe ", 523.0);
		 *  products[2] = new Produkt<String>("Microsoft Office Student and Home 2013 ", 456.99);
		 *  for (Produkt<String> i : products) {
		 *  System.out.println(i.getProduktBeschreibung() + i.getProduktPreis());
		 *  }		
		 * 
		 * Und was heisst "Mochte noch"? Was ist das fuer eine Beschreibung? 
		 * Beschreibung ist kurze Info ueber das Produkt.
		 * 
		 *  
		 * 
		 */
		
		
		Produkt<String>[] products =  new Produkt[1];
		products[0] = new Produkt<String>("Sie sind gut. Mochte noch ", 5645.3666);
		for (Produkt<String> i : products) {
			System.out.println(i.getProduktBeschreibung() + i.getProduktPreis());
		}
		
		System.out.println("");
		
		// Teacher basically wants create arraylist and put there Produkt object
		ArrayList<Produkt<String>> produktList = new ArrayList<Produkt<String>>();
		produktList.add(new Produkt<String>("Adobe ist besser als Apple. NYSE: ", 564.5146));
		produktList.add(new Produkt<String>("Microsoft kostet", 564.5146));
		for (Produkt<String> g : produktList) {
			System.out.println(g.getProduktBeschreibung()+ " " + g.getProduktPreis());
		}

	}

}
