// Java Programming Assignment 10.11
// Implement a Circle class
// Written by 121220130

import java.lang.Math;

public class Circle2D {
	final double pi = 3.14159265358979;
	private double x;
	private double y;
	private double radius;
	public Circle2D() {
		x = y = 0;
		radius = 1;
	}
	public Circle2D(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getRadius() {
		return radius;
	}

	public double getArea() {
		return getRadius() * getRadius() * pi;
	}

	public double getPerimeter() {
		return getRadius() * 2 * pi;
	}

	public boolean contains(double x, double y) {
		double distanceSquare = (this.x - x) * (this.x - x) + (this.y - y) * (this.y - y);
		return (distanceSquare < radius * radius);
	}

	public boolean contains(Circle2D circle) {
		double distanceSquare = (this.x-circle.x) * (this.x-circle.x) + (this.y-circle.y) + (this.y-circle.y);
		return (this.radius > circle.radius + Math.sqrt(distanceSquare));
	}

	public boolean overlaps(Circle2D circle) {
		double distanceSquare = (this.x - circle.x) * (this.x - circle.x) + (this.y - circle.y) * (this.y - circle.y);
		double compare = circle.radius + this.radius;
		return (distanceSquare < compare * compare);
	}
}
