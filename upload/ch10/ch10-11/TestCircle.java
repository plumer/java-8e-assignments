// Java Programming Assignment 10.11
// Test class Circle2D
// Written by 121220130

public class TestCircle {
	public static void main( String[] args) {
		Circle2D c1 = new Circle2D(2,2,5.5);
		System.out.printf("Area: %f\n", c1.getArea());
		System.out.printf("Circumference: %f\n", c1.getPerimeter());
		System.out.println("c1.contains(3,3): " + c1.contains(3,3));
		System.out.println("c1.contains circle(4,5,10.5): " + c1.contains(new Circle2D(4,5,10.5)));
		System.out.println("c1.overlaps circle(3,5,2.3): " + c1.overlaps(new Circle2D(3,5,2.3)));
	}
}
