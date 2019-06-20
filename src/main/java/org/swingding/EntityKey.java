package main.java.org.swingding;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

/**
 * EntityKey
 */
public class EntityKey extends Entity implements Image {
    /**
     * 
     * @param x
     * @param y
     * @param rgb
     * @param shape
     * @param value
     */
    public EntityKey(int x, int y, int[] rgb, Shape shape, int value) {
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
            if(Canvas.player.keys.size() > Canvas.player.doorsDone.size()) {
                return "You are already carrying a key";
            }
            else {
                Canvas.player.addKey(this);
                Canvas.removeEntity(newPlayerLocationX, newPlayerLocationY);
                return null;
            }
        }
        return null;
    }

    /**
     *
     * @param direction
     */
    @Override
    public BufferedImage getImage(int direction) throws Exception {
        return ImageIO.read(FileUtil.resourceReader("key_" + value + ".png"));
    }
}