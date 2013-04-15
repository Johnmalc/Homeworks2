package de.university.doNotSent.b;

public class Util {
	Shape[] shapes;
	static int sum = 0; 
	static double dasdw =0;

	public Util() {

	}
	public static double accumulateArea(Shape[] shapes) {
		 for (Shape s : shapes){
			 sum+=s.area();
		 }
		// must be for circle and rectangle
		return sum;

	}
	public static double accumulateCircumference(Shape[] shapes) {
		for (Shape s : shapes){
			 dasdw = s.circumference();
		 }
		return dasdw;
	}
}
