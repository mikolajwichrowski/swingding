package main.java.org.swingding;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

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
     * @param playerX
     * @param playerY
     * @param playerInput
     * @param newPlayerLocationX
     * @param newPlayerLocationY
     */
    @Override
    public String doCollision(int playerX, int playerY, int newPlayerLocationX, int newPlayerLocationY, Entity playerInput) {
        if(x == newPlayerLocationX && y == newPlayerLocationY) {
            Canvas.player.keys = new ArrayList<EntityKey>();
            Canvas.player.doorsDone = new ArrayList<EntityDoor>();
            Canvas.player.level++;
            return "Level up!";
        }

        return null;
    }

    /**
     *
     * @param direction
     */
    @Override
    public BufferedImage getImage(int direction) throws Exception {
        return ImageIO.read(new File(getClass().getClassLoader().getResource("portal.png").getFile()));
    }
}