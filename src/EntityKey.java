/**
 * EntityKey
 */
public class EntityKey extends Entity {
    public int keyValue;

    EntityKey(int x, int y, int[] rgb, Shape shape, int direction, int keyValue) {
        super(x, y, rgb, shape, direction);
        this.keyValue = keyValue;
    }
}