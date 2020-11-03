package Session5;

public class Rectangle extends Polygon {

    /**
     * Create a new Rectangle with a given sides.
     *
     * @param sides The second side of rectangle.
     */
    public Rectangle(double... sides) {
        super(sides);
    }

    /**
     * Determine square condition of rectangle.
     *
     * @return true if the rectangle is square, false otherwise.
     */
    public boolean isSquare() {
        return sides.get(0).equals(sides.get(1)) && sides.get(2).equals(sides.get(3))
                && sides.get(2).equals(sides.get(3));
    }
}