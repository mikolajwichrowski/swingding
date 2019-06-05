import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

/**
 * EntityKey
 */
public class EntityKey extends Entity implements Image {
    public int keyValue;

    /**
     * 
     * @param x
     * @param y
     * @param rgb
     * @param shape
     * @param direction
     * @param keyValue
     */
    public EntityKey(int x, int y, int[] rgb, Shape shape, int direction, int keyValue) {
        super(x, y, rgb, shape, direction);
        this.keyValue = keyValue;
    }

    /**
     * 
     */
    public BufferedImage getImage() throws Exception {
        return ImageIO.read(new File(Paths.get("").toAbsolutePath().toString() + "/images/key_" + keyValue + ".png"));
    }
}