package main.java.org.swingding;

/**
 * Square
 */
public class ShapeStar extends Shape {
    /**
     *
     */
    public ShapeStar() {
        // TODO: make this a star
        super(
            new int[] {30, 20, 10, 20, 0, 30, 50, 40, 50, 40, 29},
            new int[] {0, 10, 10, 30, 30, 30, 40, 30, 20, 20, -1}
        );
        this.shapeIndex = 1;
    }
}