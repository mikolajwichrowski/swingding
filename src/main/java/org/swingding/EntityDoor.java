package main.java.org.swingding;

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
     * @param unlockValue
     */
    public EntityDoor(int x, int y, int[] rgb, Shape shape, int unlockValue) {
        super(x, y, rgb, shape, 0);
        this.unlockValue = unlockValue;
    }

    /**
     * 
     */
    public BufferedImage getImage(int direction) throws Exception {
        return ImageIO.read(new File(getClass().getClassLoader().getResource("door_" + unlockValue + ".png").getFile()));
    }
}