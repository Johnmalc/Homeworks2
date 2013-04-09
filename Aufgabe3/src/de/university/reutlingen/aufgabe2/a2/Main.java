package de.university.reutlingen.aufgabe2.a2;

import java.util.ArrayList;
import de.university.reutlingen.aufgabe2.a2.ProductDescription;

public class Main {

	public static void main(String[] args) {
		/*
		 * this is a hack. Should not do, just for save heaven. Looks horrible
		 * http://www.angelikalanger.com/GenericsFAQ/FAQSections/ParameterizedTypes.html#FAQ105
		 */

		Produkt<ProductDescription>[] products = new Produkt[1];
		products[0] = new Produkt<ProductDescription>(new ProductDescription("Adobe kostet auf NYSE ", "5645.3666 "),56);
		products[1] = new Produkt<ProductDescription>(new ProductDescription("Adobe CS6 - Dreamweaver is the best. Will cost you ", 651.33);
		products[2] = new Produkt<ProductDescription>(new ProductDescription("Microsoft costs ", 651.33);
		products[3] = new Produkt<ProductDescription>(new ProductDescription("Apple will make iTV ", 651.33);
		
		for (Produkt<ProductDescription> i : products) {
			System.out.println(i.getProduktBeschreibung() + " "+  i.getProduktPreis());
		}
		
		System.out.println("");
		
		// Teacher basically wants create arraylist and put there Produkt object
		ArrayList<Produkt<ProductDescription>> produktLists = new ArrayList<>();
		ProductDescription pd = new ProductDescription("Adobe ist besser als Apple. NYSE: ", "564.5146");
		produktLists.add(new Produkt<ProductDescription>(pd,0)); // 0 kommt von double, wird nicht gezeigt.
		produktLists.add(new Produkt<ProductDescription>(new ProductDescription("I love Trees") ,0));
		
		for (Produkt<ProductDescription> g : produktLists) {
			System.out.println(g.getProduktBeschreibung()+ " " + g.getProduktPreis());
		}

	}

}
