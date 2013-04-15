package de.university.doNotSent.b;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Rectangle rant = new Rectangle(54, 56);
		double area = rant.area();
		double circ = rant.circumference();
		System.out.println(area + " + " + circ);

		/*
		 * http://martin.feld.cvut.cz/~pelikano/vyuka/PRI/printf.html
		 */
		Circle ci = new Circle(5);
		double areaCi = ci.area();
		double circCi = ci.circumference();
		System.out.printf("%.3f \n", areaCi);
		System.out.printf("%.3f \n", circCi);
		
		// do random numbers
		Random randomZahle = new Random();
		double rz = randomZahle.nextInt(100);
		System.out.println("number which represents a and b "+ rz);

		Shape[] shape = new Shape[2];
		shape[0] = new Circle(rz);
		shape[1] = new Rectangle(rz,rz);
		
		System.out.println(Util.accumulateArea(shape));
		System.out.println(Util.accumulateCircumference(shape));
	}

}
