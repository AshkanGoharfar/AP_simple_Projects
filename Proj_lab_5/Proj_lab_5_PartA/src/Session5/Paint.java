package Session5;

import java.util.ArrayList;

public class Paint {

    private ArrayList<Circle> circles;
    private ArrayList<Triangle> triangles;
    private ArrayList<Rectangle> rectangles;

    /**
     * Create a Paint.
     */
    public Paint() {
        circles = new ArrayList<>();
        triangles = new ArrayList<>();
        rectangles = new ArrayList<>();
    }

    /**
     * Add a circle to the circles collection.
     * @param circle The circle to be added.
     */
    public void addCircle(Circle circle) {
        circles.add(circle);
    }

    /**
     * Add a rectangle to the rectangles collection.
     * @param rectangle The rectangle to be added.
     */
    public void addRectangle(Rectangle rectangle) {
        rectangles.add(rectangle);
    }

    /**
     * Add a triangle to the triangles collection.
     * @param triangle The triangle to be added.
     */
    public void addTriangle(Triangle triangle) {
        triangles.add(triangle);
    }

    /**
     * Print Shapes and sides and Perimeter and Area to the output.
     */
    public void drawAll() {
        for(Rectangle rectangle: rectangles) {
            rectangle.draw();
            System.out.println(rectangle);
        }
        for(Triangle triangle: triangles) {
            triangle.draw();
            System.out.println(triangle);
        }
        for(Circle circle: circles) {
            circle.draw();
            System.out.println(circle);
        }
    }

}

