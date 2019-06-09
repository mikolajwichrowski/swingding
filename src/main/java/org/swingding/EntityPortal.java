package main.java.org.swingding;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * EntityKey
 */
public class EntityPortal extends Entity implements Image {
    /**
     *
     * @param x
     * @param y
     * @param rgb
     * @param shape
     */
    public EntityPortal(int x, int y, int[] rgb, Shape shape) {
        super(x, y, rgb, shape, 0);
    }

    /**
     * 
     */
    public BufferedImage getImage() throws Exception {
        return ImageIO.read(new File(getClass().getClassLoader().getResource("portal.png").getFile()));
    }
}