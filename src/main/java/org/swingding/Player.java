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

/**
 * Player
 */
public class Player {
    public int x, y, level, direction = 0;
    public ArrayList<EntityKey> keys = new ArrayList<EntityKey>();

    public Player()
    {
        JSONObject jobj = new JSONObject(FileUtil.fileReader("./state.json"));
        x = jobj.getJSONObject("position").getInt("x");
        y = jobj.getJSONObject("position").getInt("y");
        level = jobj.getInt("level");

        JSONArray keyInts = jobj.getJSONArray("keys");
        for (var key: keyInts) {
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
        switch(direction) {
            case 1:
                return ImageIO.read(new File(getClass().getClassLoader().getResource("zygmund_left.png").getFile()));
            case 2:
                return ImageIO.read(new File(getClass().getClassLoader().getResource("zygmund_up.png").getFile()));
            case 3:
                return ImageIO.read(new File(getClass().getClassLoader().getResource("zygmund_down.png").getFile()));
            case 4:
                return ImageIO.read(new File(getClass().getClassLoader().getResource("zygmund_right.png").getFile()));
            default:
                return ImageIO.read(new File(getClass().getClassLoader().getResource("zygmund.png").getFile()));
        }
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
        if (collisionEntity instanceof EntityDoor && unlock((EntityDoor)collisionEntity)) {
            Canvas.removeEntity(collisionEntity.x, collisionEntity.y);
        } else if (collisionEntity instanceof EntityKey) {
            addKey((EntityKey)collisionEntity);
            Canvas.removeEntity(collisionEntity.x, collisionEntity.y);
        } else if(collisionEntity instanceof EntityPortal) {
            Canvas.removeEntity(collisionEntity.x, collisionEntity.y);
            level++;
        }
    }

    /**
     *
     *
     */
    public void saveState()
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

        try
        {
            FileWriter fileWriter = new FileWriter("./state.json",false);
            fileWriter.write(state);
            fileWriter.close();
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

}