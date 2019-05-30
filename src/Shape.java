import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

/**
 * Shape
 */
public class Shape {
    public int[] xPoints;
    public int[] yPoints;
    public int shapeIndex;

    public Shape(int[] xPoints, int[] yPoints) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }

    public GeneralPath getPath(int currentX, int currentY, int rotation) {
        GeneralPath shape = new GeneralPath();

        shape.moveTo(xPoints[0] + currentX, yPoints[0] + currentY);
        for (int i = 1; i < xPoints.length; i++) {
            shape.lineTo(xPoints[i] + currentX, yPoints[i] + currentY);
        }
        shape.closePath();

<<<<<<< HEAD
        if(rotation != 0) {
            AffineTransform at = new AffineTransform();
            at.rotate((-Math.PI/2)*rotation, currentX+25, currentY+25);
=======
        if (rotation != 0) {
            AffineTransform at = new AffineTransform();
            at.rotate((-Math.PI / 2) * rotation, currentX + 25, currentY + 25);
>>>>>>> d6a450ed0aebcbad41931d08368a97518c975b36
            shape.transform(at);
        }
        return shape;
    }
}