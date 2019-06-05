/**
 * Square
 */
public class ShapeSquare extends Shape {
    /**
     * 
     */
    public ShapeSquare() {
        super(
            new int[] { 0, 50, 0, 50, 0, 50, 50, 0, 0 }, 
            new int[] { 0, 50, 50, 0, 0, 50, 0, 50, 0  }
        );
        this.shapeIndex = 1;
    }
}