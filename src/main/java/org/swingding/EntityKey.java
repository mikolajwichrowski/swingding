package main.java.org.swingding;

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
     * @param keyValue
     */
    public EntityKey(int x, int y, int[] rgb, Shape shape, int keyValue) {
        super(x, y, rgb, shape, 0);
        this.keyValue = keyValue;
    }

    /**
     * 
     */
    public BufferedImage getImage(int direction) throws Exception {
        return ImageIO.read(FileUtil.resourceReader("key_" + keyValue + ".png"));
    }
}