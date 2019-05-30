/**
 * Position
 */
public class Entity {
    public int x, y, rotation;
    public int[] rgb;
    public Shape shape;
    public String type = "BLOCK";

    Entity(int x, int y, int[] rgb, Shape shape, int rotation) {
        this.x = x;
        this.y = y;
        this.rgb = new int[] { rgb[0], rgb[1], rgb[2] };
        this.shape = shape;
        this.rotation = rotation;
    }
}