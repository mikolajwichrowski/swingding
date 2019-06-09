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
            new int[] {10, 50, 100, 150, 200, 250, 300, 350},
            new int[] {10, 50,  10,  50,  10,  50,  10,  50}
        );
        this.shapeIndex = 1;
    }
}