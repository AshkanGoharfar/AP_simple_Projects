package Session5;

import java.util.ArrayList;


public class Paint {

    private ArrayList<Shape> shapes;

    /**
     * Create a Paint.
     */
    public Paint() {
        shapes = new ArrayList<>();
    }

    /**
     * Add a shape to the shapes collection.
     *
     * @param shape The shape to be added.
     */
    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    /**
     * Print Shapes and sides(or radius) and Perimeter and Area to the output terminal.
     */
    public void drawAll() {
        for (Shape shape : shapes) {
            System.out.println(shape);
            shape.draw();
            System.out.println("----------------------");
        }
    }

    /**
     * Determine whether the given shape has equalSides.
     */
    public void describeEqualSides() {
        for (Shape shape : shapes) {
            if (shape instanceof Triangle)
                if (((Triangle) shape).isEquilateral())
                    System.out.println(shape + " is equilateral");
            if (shape instanceof Rectangle)
                if (((Rectangle) shape).isSquare())
                    System.out.println(shape + " is Square");
        }
    }
}
