/**
 * EntityDoor
 */
public class EntityDoor extends Entity {
    public int unlockValue;

    EntityDoor(int x, int y, int[] rgb, Shape shape, int direction, int unlockValue) {
        super(x, y, rgb, shape, direction);
        this.unlockValue = unlockValue;
    }
}