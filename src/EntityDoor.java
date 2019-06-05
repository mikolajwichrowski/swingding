import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

/**
 * EntityDoor
 */
public class EntityDoor extends Entity implements Image {
    public int unlockValue;

    /**
     * 
     * @param x
     * @param y
     * @param rgb
     * @param shape
     * @param direction
     * @param unlockValue
     */
    public EntityDoor(int x, int y, int[] rgb, Shape shape, int direction, int unlockValue) {
        super(x, y, rgb, shape, direction);
        this.unlockValue = unlockValue;
    }

    /**
     * 
     */
    public BufferedImage getImage() throws Exception {
        return ImageIO.read(new File(Paths.get("").toAbsolutePath().toString() + "/images/door_" + unlockValue + ".png"));
    }
}