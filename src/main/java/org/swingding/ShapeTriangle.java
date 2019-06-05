package main.java.org.swingding;

/**
 * Square
 */
public class ShapeTriangle extends Shape {
    /**
     * 
     */
    public ShapeTriangle() {
        super(
            new int[] {0, 50, -1, 0}, 
            new int[] {50, 0, 0, -1}
        );
        this.shapeIndex = 2;
    }
}