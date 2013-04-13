package de.university.doNotSent.b;

import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Rectangle rant = new Rectangle(54, 56);
		double area = rant.area();
		double circ = rant.circumference();
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
		
		// do random numbers
		Random randomZahle = new Random();
		double rz = randomZahle.nextDouble();
		System.out.println(rz);

		Shape[] shape = new Shape[3];
		shape[0] = new Circle(rz);
		shape[1] = new Rectangle(rz,rz);
		
		for (int i = 0; i<shape.length;i++){
			System.out.println(i);
		}
		
		System.out.println(Util.accumulateArea(shape));
		System.out.println(Util.accumulateCircumference(shape));
	}

}
