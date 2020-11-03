package Session5;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Triangle tri1 = new Triangle(3, 3, 3);
        Rectangle rect1 = new Rectangle(8, 5,8,5);
        Rectangle rect2 = new Rectangle(6, 6,6,6);
        Circle circle1 = new Circle(10);
        tri1.draw();
        rect1.draw();
        circle1.draw();
        System.out.println(tri1.isEquilateral());
        System.out.println(rect2.isSquare());
        System.out.println(rect1.equals(rect2));
        Paint paint = new Paint();
        paint.addTriangle(tri1);
        paint.addRectangle(rect1);
        paint.addRectangle(rect2);
        paint.addCircle(circle1);
    }
}
