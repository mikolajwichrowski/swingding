package main.java.org.swingding;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import javax.imageio.ImageIO;

/**
 * EntityDoor
 */
public class EntityDoor extends Entity implements Image {
    /**
     * 
     * @param x
     * @param y
     * @param rgb
     * @param shape
     * @param value
     */
    public EntityDoor(int x, int y, int[] rgb, Shape shape, int value) {
        super(x, y, rgb, shape, value);
    }

    /**
     *
     * @param direction
     */
    @Override
    public BufferedImage getImage(int direction) throws Exception {
        return ImageIO.read(FileUtil.resourceReader("door_" + value + ".png"));
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
            if(playerInput != null && playerInput.value == value) {
                Canvas.player.addDoor(this);
                Canvas.removeEntity(newPlayerLocationX, newPlayerLocationY);
                return null;
            } else {
                return "You don't have the right vodka!";
            }
        } else {
            return null;
        }
    }

    public String toString() {
        // Not so pretty code ... but very pretty json
        return "{\n" +
                "\t\"x\": " + x + ",\n" +
                "\t\"y\": " + y + ",\n" +
                "\t\"r\": " + rgb[0] + ",\n" +
                "\t\"g\": " + rgb[1] + ",\n" +
                "\t\"b\": " + rgb[2] + ",\n" +
                "\t\"value\": " + value +
                "\n}";
    }
}