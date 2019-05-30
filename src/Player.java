import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.imageio.ImageIO;

/**
 * Pen
 */
public class Player {
    public int x = 0, y = 0, direction = 0;

    public Shape currentShape = new ShapeSquare();
    public ArrayList<EntityKey> keys = new ArrayList<EntityKey>();

    // TODO: get GeneralPath image based on the direction
    public BufferedImage getImage(int direction) throws Exception {
        BufferedImage image = ImageIO.read(new File(Paths.get("").toAbsolutePath().toString() + "/images/zygmund.png"));

        switch(direction) {
            case 1:
                return image;
            case 2:
                return image;
            case 3:
                return image;
            case 4:
                return image;
            default:
                return image;
        }
        
        
        

        // I used this in the old version
        // shape.moveTo(xPoints[0] + currentX, yPoints[0] + currentY);
        // for (int i = 1; i < xPoints.length; i++) {
        //     shape.lineTo(xPoints[i] + currentX, yPoints[i] + currentY);
        // }
        // shape.closePath();

        // if(rotation != 0) {
        //     AffineTransform at = new AffineTransform();
        //     at.rotate((-Math.PI/2)*rotation, currentX+25, currentY+25);
        //     shape.transform(at);
        // }
    }

    public void addKey(EntityKey entity) {
        keys.add(entity);
    }

    public boolean unlock(EntityDoor entity) {
        boolean keyFound = false;
        for (EntityKey key : keys) {
            if(key.keyValue == entity.unlockValue) {
                keyFound = true;
            }
        }
        return keyFound;
    }

    public void left() {
        int nextX = x; 
        int nextY = y-1;
        Entity collisioned = Canvas.getEntity(nextX, nextY);

        currentShape = new ShapeTriangle();
        if (y > 0&& !Canvas.isCollision(nextX, nextY)) {
            direction = 1;
            y = nextY;
        } else if (Canvas.isDoor(nextX, nextY) && unlock((EntityDoor)collisioned)) {
            Canvas.remove(nextX, nextY);
        } else if (Canvas.isKey(nextX, nextY)) {
            addKey((EntityKey)collisioned);
            Canvas.remove(nextX, nextY);
        }
        
    }

    public void up() {
        int nextX = x-1; 
        int nextY = y;
        Entity collisioned = Canvas.getEntity(nextX, nextY);

        currentShape = new ShapeTriangle();

        if(x > 0 && !Canvas.isCollision(nextX, nextY)) {
            direction = 2;
            x = nextX;
        } else if (Canvas.isDoor(nextX, nextY) && unlock((EntityDoor)collisioned)) {
            Canvas.remove(nextX, nextY);
        } else if (Canvas.isKey(nextX, nextY)) {
            addKey((EntityKey)collisioned);
            Canvas.remove(nextX, nextY);
        }
        
    }

    public void right() {
        int nextX = x; 
        int nextY = y+1;
        Entity collisioned = Canvas.getEntity(nextX, nextY);

        currentShape = new ShapeTriangle();
        if (y < Canvas.WIDTH && !Canvas.isCollision(nextX, nextY)) {
            direction = 4;
            y = nextY;
        } else if (Canvas.isDoor(nextX, nextY) && unlock((EntityDoor)collisioned)) {
            Canvas.remove(nextX, y);
        } else if (Canvas.isKey(nextX, nextY)) {
            addKey((EntityKey)collisioned);
            Canvas.remove(nextX, nextY);
        }
        
    }

    public void down() {
        currentShape = new ShapeTriangle();

        int nextX = x+1; 
        int nextY = y;
        Entity collisioned = Canvas.getEntity(nextX, nextY);

        if (x < Canvas.HEIGHT && !Canvas.isCollision(nextX, nextY)) {
            direction = 3;
            x = nextX;
        } else if (Canvas.isDoor(nextX, nextY) && unlock((EntityDoor)collisioned)) {
            Canvas.remove(nextX, nextY);
        } else if (Canvas.isKey(nextX, nextY)) {
            addKey((EntityKey)collisioned);
            Canvas.remove(nextX, nextY);
        }
        
        
    }
}