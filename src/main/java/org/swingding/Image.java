package main.java.org.swingding;

import java.awt.image.BufferedImage;

/**
 * Image
 */
interface Image {
    BufferedImage getImage(int direction) throws Exception;
}