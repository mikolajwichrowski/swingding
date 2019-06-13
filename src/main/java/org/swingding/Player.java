package main.java.org.swingding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Player
 */
public class Player implements Image {
    public int x, y, level, direction = 0;
    public ArrayList<EntityKey> keys = new ArrayList<EntityKey>();

    public Player()
    {
        JSONObject jobj = new JSONObject(FileUtil.fileReader("./state.json"));
        x = jobj.getJSONObject("position").getInt("x");
        y = jobj.getJSONObject("position").getInt("y");
        level = jobj.getInt("level");

        JSONArray keyInts = jobj.getJSONArray("keys");
        for (Object key: keyInts) {
            try {
                addKey(new EntityKey(
                        0,
                        0,
                        new int[] {0, 0, 0},
                        new ShapeSquare(),
                        Integer.parseInt(key.toString())
                ));
            } catch (Exception e) {

            }
        }
    }

    /**
     * 
     * @param direction
     * @return
     * @throws Exception
     */
    public BufferedImage getImage(int direction) throws Exception {
        String name = "zygmund";
        switch(direction) {
            case 1:
                name += "_left.png";
            case 2:
                name += "_up.png";
            case 3:
                name += "_down.png";
            case 4:
                name += "_right.png";
            default:
                name += ".png";
                break;
        }

        return ImageIO.read(FileUtil.resourceReader(name));
    }

    /**
     * 
     */
    public void left() {
        int nextX = x; 
        int nextY = y-1;
        Entity collisionEntity = Canvas.getEntity(nextX, nextY);

        direction = 1;
        if (y > 0 && collisionEntity == null) {
            y = nextY;
        } else {
            doCollision(collisionEntity);
        }
    }

    /**
     * 
     */
    public void up() {
        int nextX = x-1; 
        int nextY = y;
        Entity collisionEntity = Canvas.getEntity(nextX, nextY);

        direction = 2;
        if(x > 0 && collisionEntity == null) {
            x = nextX;
        } else {
            doCollision(collisionEntity);
        }
    }

    /**
     * 
     */
    public void right() {
        int nextX = x; 
        int nextY = y+1;
        Entity collisionEntity = Canvas.getEntity(nextX, nextY);

        direction = 4;
        if (y < Canvas.WIDTH && collisionEntity == null) {
            y = nextY;
        } else {
            doCollision(collisionEntity);
        }
    }

    /**
     * 
     */
    public void down() {
        int nextX = x+1; 
        int nextY = y;
        Entity collisionEntity = Canvas.getEntity(nextX, nextY);

        direction = 3;
        if (x < Canvas.HEIGHT && collisionEntity == null) {
            x = nextX;
        } else {
            doCollision(collisionEntity);
        }
    }

    /**
     * 
     * @param entity
     */
    private void addKey(EntityKey entity) {
        keys.add(entity);
    }

    /**
     * 
     * @param entity
     * @return
     */
    private boolean unlock(EntityDoor entity) {
        boolean keyFound = false;
        EntityKey keyRemove = null;
        for (EntityKey key : keys) {
            if(key.keyValue == entity.unlockValue) {
                keyFound = true;
                keyRemove = key;
            }
        }
        keys.remove(keyRemove);
        return keyFound;
    }

    /**
     * 
     * @param collisionEntity
     */
    private void doCollision(Entity collisionEntity) {
        if (collisionEntity instanceof EntityDoor) {
            if(unlock((EntityDoor)collisionEntity)) {
                Canvas.removeEntity(collisionEntity.x, collisionEntity.y);
            }
            else {
                JOptionPane.showMessageDialog(null, "Je hebt niet het juiste vodka merk bij je...\nGa weg pleb!\n.....\n...");
            }
        } else if (collisionEntity instanceof EntityKey) {
            addKey((EntityKey)collisionEntity);
            Canvas.removeEntity(collisionEntity.x, collisionEntity.y);
        } else if(collisionEntity instanceof EntityPortal) {
            JOptionPane.showMessageDialog(null, "Level up blyat!");
            Canvas.removeEntity(collisionEntity.x, collisionEntity.y);
            level++;
        }
    }

    /**
     *
     *
     */
    public String toString()
    {
        ArrayList<String> keyInts = new ArrayList<String>();
        for (EntityKey key: keys) {
            keyInts.add(""+key.keyValue);
        }
        String state = "{\n" +
        "  \"level\": " + level + ",\n" +
        "  \"position\": {\n" +
        "    \"x\": " + x + " ,\n" +
        "    \"y\": " + y + "\n" +
        "  },\n" +
        "  \"keys\": [" + String.join(",", keyInts) + "]\n" +
        "}";

        return state;
    }

}