package de.university.doNotSent.b;

public class Circle implements Shape {
	double r;

	public Circle(double R) {
		this.r = R;
	}
	public Circle(){
		
	}

	@Override
	/*
	 * (non-Javadoc)
	 * obsah
	 * @see de.university.doNotSent.b.Shape#area()
	 */
	public double area() {
		double fi = Math.PI * Math.pow(r, 2);
		return fi;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * obvod
	 * @see de.university.doNotSent.b.Shape#circumference()
	 */
	public double circumference() {
		double D= 2*r;
		double C = Math.PI*D;
		return C;
	}

}
