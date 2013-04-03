package de.reutlingen.university.aufgabe3;

/**
 * @author Anastasia Baron
 * @author Dmitry Petrov
 * 
 *         Erstellen Sie in einer main()-Methode von den verschiedenen
 *         Schuharten ein Objekt. Ausserdem sind Box- und ShoeBox-Objekte zu
 *         erstellen, in denen Sie die die Schuhpaare aufbewahren und
 *         herausnehmen koennen. Der Inhalt der Box- bzw. ShoeBox-Objekte soll
 *         auf der Konsole ausgegeben werden.
 * 
 */
public class Main {

	public static void main(String[] args){

		/*
		 * Es wird die Fehlermeldung erscheinen, wenn die Schuhegroesse nicht im
		 * passenden Format eingegeben wuerde
		 */
		Stiefel stiefel = new Stiefel("Steifel", 36);
		Sportschuhe sportschuhe = new Sportschuhe("Sportschuhe", 40);

		Box<Sportschuhe> box = new Box<Sportschuhe>();

		/*
		 * Jetzt duerfen nur die Elemente von der Klasse Spotschuehe hier
		 * geschpeichert werden
		 */

		box.addShoes(sportschuhe);

		/*
		 * in ShoeBox kann jetzt nur die Elemente von der Klasse Stiefel
		 * geschpeichert werden
		 */
		ShoeBox<Stiefel> shoebox = new ShoeBox<Stiefel>();
		shoebox.addShoes(stiefel);

		System.out.println(box.toString());
		System.out.println(shoebox.toString());

	}

}
