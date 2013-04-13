package de.university.doNotSent.a;

public class Test {

	public static void main(String[] args) {
		Rectangle rant = new Rectangle(54,56);
		double area = rant.area();
		double circ= rant.circumference();
		System.out.println(area + " + " + circ);
		
		System.out.println("");
		/*
		 * http://martin.feld.cvut.cz/~pelikano/vyuka/PRI/printf.html
		 */
		Circle ci = new Circle(5);
		double areaCi = ci.area();
		double circCi = ci.circumference();
		System.out.printf("%.3f \n", areaCi);
		System.out.printf("%.3f \n", circCi);
		
		
	}

}
