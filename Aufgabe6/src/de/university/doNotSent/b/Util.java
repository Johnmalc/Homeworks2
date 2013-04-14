package de.university.doNotSent.b;

public class Util {
	Shape[] shapes;
	static int sum = 0; 

	public Util() {

	}
	public static double accumulateArea(Shape[] shapes) {
		Circle a = new Circle();
		 for (Shape s : shapes){
			 if(shapes.equals(a)){
				 sum+=a.area();
			 }
		 }
		// must be for circle and rectangle
		return sum;

	}
	public static double accumulateCircumference(Shape[] shapes) {
		// the same 
		
		return sum;
	}
}
