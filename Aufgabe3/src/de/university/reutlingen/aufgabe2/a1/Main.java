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
		 *  ich werde daruber mit prof. reden, weil arraylist ist fortgeschritten, dagegen norm. array ist 
		 *  fur kindergarten. Er gibt uns das, weil alle andere haben keine ahnung was arraylist ist. 
		 *  ICH kann das schon und( kann das deswegen verbessern).  
		 */
		
		
		Produkt<String>[] products =  new Produkt[1]; // hier kannst du auch eine warning lesen in eclipse. 
		// Eclipse sagt type savety, bei array list ist das ohne warning
		products[0] = new Produkt<String>("Adobe CS6 - Dreamweaver is the best. Will cost you ", 651.33);
		for (Produkt<String> i : products) {
			System.out.println(i.getProduktBeschreibung() + i.getProduktPreis());
		}
		
		System.out.println("");
		
		// Teacher basically wants create arraylist and put there Produkt object
		ArrayList<Produkt<String>> produktList = new ArrayList<>();
		produktList.add(new Produkt<String>("Adobe ist besser als Apple. NYSE: ", 564.5146));
		produktList.add(new Produkt<String>("Microsoft kostet", 564.5146));
		for (Produkt<String> g : produktList) {
			System.out.println(g.getProduktBeschreibung()+ " " + g.getProduktPreis());
		}

	}

}
