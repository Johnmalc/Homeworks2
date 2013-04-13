package de.university.doNotSent.a;

public class Circle implements Shape {
	double r;

	public Circle(double R) {
		this.r = R;

	}

	@Override
	public double area() {
		double fi = Math.PI * Math.pow(r, 2);
		return fi;
	}

	@Override
	public double circumference() {
		double D= 2*r;
		double C = Math.PI*D;
		return C;
	}

}
