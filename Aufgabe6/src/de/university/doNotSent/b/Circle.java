package de.university.doNotSent.b;

public class Circle implements Shape {
	double r;

	public Circle(double R) {
		this.r = R;
	}
	public Circle(){
		
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
