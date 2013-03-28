package de.university.reutlingen.aufgabe2.a1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		/*
		 * this is a hack. Should not do, just for save heaven. Looks horrible
		 * http://www.angelikalanger.com/GenericsFAQ/FAQSections/ParameterizedTypes.html#FAQ105
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
