package Session5;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Shape tri = new Triangle(3,4,5);
        Shape tri2 = new Triangle(3,3,4);
        Triangle tri3 = new Triangle(3,3,3);
        Triangle tri33 = new Triangle(3,3,3);
        System.err.println("equal or no ? " + tri33.equals(tri3));
        Circle circ = new Circle(4);
        Triangle tri4 = new Triangle(5,5,5);
        Rectangle rect = new Rectangle(5,6);
        Rectangle rect3 = new Rectangle(6,6);
        System.err.println("equal or no ? " + rect.equals(rect3));
        Paint paint = new Paint();
        paint.addShape(tri);
        paint.addShape(tri2);
        paint.addShape(circ);
        paint.addShape(rect3);
        paint.addShape(rect3);
        paint.addShape(tri4);
        paint.addShape(rect3);
        paint.describeEqualSides();
    }
}
