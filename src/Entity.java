import java.awt.image.BufferedImage;

/**
 * Position
 */
public class Entity {
    public int x, y, direction;
    public int[] rgb;
    public Shape shape;

    Entity(int x, int y, int[] rgb, Shape shape, int direction) {
        this.x = x;
        this.y = y;
        this.rgb = new int[] { rgb[0], rgb[1], rgb[2] };
        this.shape = shape;
        this.direction = direction;
    }
}