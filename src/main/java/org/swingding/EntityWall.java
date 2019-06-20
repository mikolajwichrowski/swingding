package main.java.org.swingding;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * EntityWall
 */
public class EntityWall extends Entity implements Image {
    /**
     * 
     * @param x
     * @param y
     * @param rgb
     * @param shape
     * @param value
     */
    public EntityWall(int x, int y, int[] rgb, Shape shape, int value) {
        super(x, y, rgb, shape, value);
    }

    /**
     *
     * @param playerX
     * @param playerY
     * @param playerInput
     * @param newPlayerLocationX
     * @param newPlayerLocationY
     */
    @Override
    public String doCollision(int playerX, int playerY, int newPlayerLocationX, int newPlayerLocationY, Entity playerInput) {
        if(x == newPlayerLocationX && y == newPlayerLocationY) {
            // Does nothing. It's just a collision
            // Uncomment this to see that the test works. Change asserted y value
            // Canvas.removeEntity(newPlayerLocationX, newPlayerLocationY);
            return null;
        }

        return null;
    }

    /**
     *
     * @param direction
     */
    @Override
    public BufferedImage getImage(int direction) throws Exception {
        // Does not have to have an image. In our scenario we skipped it.
        return ImageIO.read(new File(getClass().getClassLoader().getResource("wall_" + direction + ".png").getFile()));
    }
}