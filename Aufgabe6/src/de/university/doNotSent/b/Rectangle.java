package de.university.doNotSent.b;

public class Rectangle implements Shape {
	double a;
	double b;

	public Rectangle(double A, double B) {
		this.a = A;
		this.b = B;
	}
	public Rectangle(){
		
	}

	@Override
	/*
	 * (non-Javadoc)
	 * Flache, obsah
	 * @see de.university.doNotSent.b.Shape#area()
	 */
	public double area() {
		double fi = a * b;
		return fi;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * obvod
	 * @see de.university.doNotSent.b.Shape#circumference()
	 */
	public double circumference() {
		double seiteC = a + a;
		double seiteD = b + b;
		return seiteC + seiteD;
	}

}
