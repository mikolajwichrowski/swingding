

/**
 * Position
 */
public class ColorDrop {
    public int x, y, rotation;
    public int[] rgb;
    public Shape shape;

    ColorDrop(int x, int y, int[] rgb, Shape shape, int rotation) {
        this.x = x;
        this.y = y;
        this.rgb = new int[]{rgb[0], rgb[1], rgb[2]};
        this.shape = shape;
        this.rotation = rotation;
    }
}