package Session5;

import java.util.Objects;

public class Circle extends Shape {

    private double radius;

    /**
     * Create a new Circle with a given radius.
     *
     * @param radius The radius of circle.
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * get The radius.
     *
     * @return radius field.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * calculate perimeter of circle.
     *
     * @return perimeter
     */
    @Override
    public double calculatePerimeter() {
        return (2 * Math.PI * radius);
    }

    /**
     * calculate area of circle.
     *
     * @return area
     */
    @Override
    public double calculateArea() {
        return (Math.PI * (radius * radius));
    }

    /**
     * Determine whether the given polygon equals the polygon.
     *
     * @param o The polygon to be checked.
     * @return true if the given polygon is valid, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;

        Circle circle = (Circle) o;

        return Double.compare(circle.getRadius(), getRadius()) == 0;
    }

    /**
     * Make a hashcode depends on radius.
     *
     * @return code
     */
    @Override
    public int hashCode() {
        return Objects.hash(getRadius());
    }

    /**
     * get a String for circle and radius.
     *
     * @return a String.
     */
    @Override
    public String toString() {
        return "Shape is Circle and its radius is : " + radius;
    }

}
