package main.java.org.swingding;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

/**
 * Position
 */
public abstract class Entity {
    public int x, y, direction, value;
    public int[] rgb;
    public Shape shape;


    /**
     * 
     * @param x
     * @param y
     * @param rgb
     * @param shape
     * @param direction
     */
    public Entity(int x, int y, int[] rgb, Shape shape, int direction, int value) {
        this.x = x;
        this.y = y;
        this.rgb = new int[] { rgb[0], rgb[1], rgb[2] };
        this.shape = shape;
        this.direction = direction;
        this.value = value;
    }

    /**
    *
    * @param direction
    */
    public BufferedImage getImage(int direction) throws Exception {
        return null;
    }

    /**
     *
     * @param playerX
     * @param playerY
     * @param playerInput
     * @param newPlayerLocationX
     * @param newPlayerLocationY
     */
    public String doCollision(int playerX, int playerY, int newPlayerLocationX, int newPlayerLocationY, Entity playerInput) {
        return "Unknown collision!";
    }

}