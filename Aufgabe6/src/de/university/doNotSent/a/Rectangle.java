package de.university.doNotSent.a;

public class Rectangle implements Shape {
	double a;
	double b;

	public Rectangle(double A, double B) {
		this.a = A;
		this.b = B;

	}

	@Override
	public double area() {
		double fi = a * b;
		return fi;
	}

	@Override
	public double circumference() {
		double seiteC = a + a;
		double seiteD = b + b;
		return seiteC + seiteD;
	}

}
