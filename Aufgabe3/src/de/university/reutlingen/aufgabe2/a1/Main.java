package de.university.reutlingen.aufgabe2.a1;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		/*
		 * Schreiben Sie eine generische Klasse Product, die ein Produkt
		 * reprasentiert. Ein Product- Objekt besteht aus zwei Attributen. Das
		 * erste Attribut ist die Produktbeschreibung, das zweite Argument ist
		 * der Produktpreis. Die tatsächliche Klasse fur das Attribut
		 * Produktbeschreibung soll erst bei der Verwendung der Klasse
		 * festgelegt werden, verwenden Sie deshalb eine Typvariable
		 * (Stellvertreterbuchstaben). Das zweite Attribut Produktpreis ist vom
		 * Datentyp double. Die Klasse Product soll einen Konstruktor besitzen,
		 * der Werte für beide Attribute als Argumente ubergeben bekommt
		 * Schreiben Sie ein Testprogramm, welches eine Anzahl von
		 * Product-Objekten erzeugt (Verwenden Sie die Klasse String als Klasse
		 * für die Produktbeschreibung), in einem Array speichert und auf die
		 * Standardausgabe ausgibt. Verwenden Sie zur Ausgabe des Arrays die
		 * "neue" for-Schleife von Java (Seit der Version 1.5 kann die
		 * for-Schleife im Sinne einer foreach-Schleife verwendet werden. Es ist
		 * dann keine Laufvariable zur Indizierung in ein Array oder eine
		 * Collection notwendig, sondern die Laufvariable nimmt selber den Wert
		 * an.)
		 * 
		 */
		
		/*
		* this is a hack. Should not do, just for save heaven.
		* http://www.angelikalanger.com/GenericsFAQ/FAQSections/ParameterizedTypes.html#FAQ105
		*/
		Produkt<String>[] products =  new Produkt[1]; // hier kannst du auch eine warning lesen in eclipse. 
		// Eclipse sagt type savety, bei array list ist das ohne warning
		products[0] = new Produkt<String>("Adobe CS6 - Dreamweaver is the best. Will cost you ", 651.33);
		products[1] = new Produkt<String>("Microsoft costs ", 651.33);
		products[2] = new Produkt<String>("Apple will make iTV ", 651.33);
		for (Produkt<String> i : products) {
			System.out.println(i.getProduktBeschreibung() + i.getProduktPreis());
		}
		
		System.out.println("");
		
		// This is better, because uses ArrayLists. 
		ArrayList<Produkt<String>> produktList = new ArrayList<>();
		produktList.add(new Produkt<String>("Adobe ist besser als Apple. NYSE: ", 564.5146));
		produktList.add(new Produkt<String>("Microsoft kostet", 564.5146));
		produktList.add(new Produkt<String>("Google is verz expensive ", 564.5146));
		for (Produkt<String> g : produktList) {
			System.out.println(g.getProduktBeschreibung()+ " " + g.getProduktPreis());
		}

	}

}
