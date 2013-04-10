package de.university.reutlingen.aufgabe2.a2;

import java.util.ArrayList;
import de.university.reutlingen.aufgabe2.a2.ProductDescription;

public class Main {

	public static void main(String[] args) {
		/*
		*Schreiben Sie eine Klasse ProductDescription, die eine Produktbeschreibung reprasentiert. Die 
		*Klasse hat 2 Attribute, eine Produktgruppe und einen Beschreibungstext. Beide Attribute 
		*werden durch die Klasse String repräsentiert. Implementieren Sie alle notigen Konstruktoren 
		*und die Methode public String toString() (Der Ergebnis-String soll die Produktgruppe und den
		*Text enthalten). Verandern Sie das Testprogramm aus Teilaufgabe (a) in der Art, dass an
		*Stelle eines String-Objekts ein Objekt der Klasse ProductDescription als Produktbeschreibung 
		*verwendet wird.
		*/
		
		/*
		* this is a hack. Should not do, just for save heaven. Looks horrible
		* http://www.angelikalanger.com/GenericsFAQ/FAQSections/ParameterizedTypes.html#FAQ105
		*/
		Produkt<ProductDescription>[] products = new Produkt[4];
		products[0] = new Produkt<ProductDescription>(new ProductDescription("Adobe kostet auf NYSE ", " Stuck kostet 5.6 - 10 Stucke "),56);
		products[1] = new Produkt<ProductDescription>(new ProductDescription("Adobe CS6 - Dreamweaver is the best. "," Stuck kostet 65.33 - 10 Stucke"), 651.33); 
		products[2] = new Produkt<ProductDescription>(new ProductDescription("Microsoft costs auf NASDAQ "," Stuck kostet 0 - 10 Stucke"), 0);
		products[3] = new Produkt<ProductDescription>(new ProductDescription("Apple will make iTV "," Stuck kostet 5600 - 10 Stucke"), 56_000);
		
		for (Produkt<ProductDescription> i : products) {
			System.out.println(i.getProduktBeschreibung() + " "+  i.getProduktPreis());
		}
		
		System.out.println("");
		
		// This is better, because uses ArrayLists. 
		ArrayList<Produkt<ProductDescription>> produktLists = new ArrayList<>();
		ProductDescription pd = new ProductDescription("Adobe ist besser als Apple. NYSE: ", "564.5146");
		produktLists.add(new Produkt<ProductDescription>(pd,0)); // 0 kommt von double, wird nicht gezeigt.
		produktLists.add(new Produkt<ProductDescription>(new ProductDescription("I love Trees", null) ,0));
		
		for (Produkt<ProductDescription> g : produktLists) {
			System.out.println(g.getProduktBeschreibung()+ " " + g.getProduktPreis());
		}

	}

}
