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
    public ArrayList<EntityDoor> doorsDone = new ArrayList<EntityDoor>();

    public Player()
    {
        JSONObject jobj = new JSONObject(FileUtil.fileReader("./state.json"));
        try {
            x = jobj.getJSONObject("position").getInt("x");
            y = jobj.getJSONObject("position").getInt("y");
            level = jobj.getInt("level");
        }
        catch (Exception e)
        {

        }


        JSONArray keysJson = jobj.getJSONArray("keys");
        for (int i = 0; i < keysJson.length(); i++) {
            try {
                addKey(new EntityKey(
                        keysJson.getJSONObject(i).getInt("x"),
                        keysJson.getJSONObject(i).getInt("y"),
                            new int[] {
                                    keysJson.getJSONObject(i).getInt("r"),
                                    keysJson.getJSONObject(i).getInt("g"),
                                    keysJson.getJSONObject(i).getInt("b")
                            },
                            new ShapeSquare(),
                        keysJson.getJSONObject(i).getInt("value")
                ));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        JSONArray doorsDoneJson = jobj.getJSONArray("doors");
        for (int i = 0; i < doorsDoneJson.length(); i++) {
            try {
                addDoor(new EntityDoor(
                        doorsDoneJson.getJSONObject(i).getInt("x"),
                        doorsDoneJson.getJSONObject(i).getInt("y"),
                        new int[] {
                                doorsDoneJson.getJSONObject(i).getInt("r"),
                                doorsDoneJson.getJSONObject(i).getInt("g"),
                                doorsDoneJson.getJSONObject(i).getInt("b")
                        },
                        new ShapeSquare(),
                        doorsDoneJson.getJSONObject(i).getInt("value")
                ));
            } catch (Exception e) {
                System.out.println(e.getMessage());
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
                break;
            case 2:
                name += "_up.png";
                break;
            default:
            case 3:
                name += "_down.png";
                break;
            case 4:
                name += "_right.png";
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
     */
    private void addDoor(EntityDoor entity) {
        doorsDone.add(entity);
    }

    /**
     * 
     * @param entity
     * @return
     */
    private boolean unlock(EntityDoor entity) {
        boolean keyFound = false;

        if(keys.size()-1 >= 0 && keys.get(keys.size()-1).keyValue == entity.unlockValue)
        {
            keyFound = true;
        }

        return keyFound;
    }

    /**
     * 
     * @param collisionEntity
     */
    private void doCollision(Entity collisionEntity) {
        if (collisionEntity instanceof EntityDoor) {
            if(unlock((EntityDoor)collisionEntity)) {
                doorsDone.add((EntityDoor)collisionEntity);
                Canvas.removeEntity(collisionEntity.x, collisionEntity.y);
            }
            else {
                JOptionPane.showMessageDialog(null, "Je hebt niet het juiste vodka merk bij je...\nGa weg pleb!\n.....\n...");
            }
        } else if (collisionEntity instanceof EntityKey) {
            addKey((EntityKey)collisionEntity);
            Canvas.removeEntity(collisionEntity.x, collisionEntity.y);
        } else if(collisionEntity instanceof EntityPortal) {
            JOptionPane.showMessageDialog(null, "Level up my frend!");
            doorsDone = new ArrayList<EntityDoor>();
            level++;
        }
    }

    /**
     *
     *
     */
    public String toString()
    {
        // Not so pretty code ... but very pretty json
        ArrayList<String> keyStrings = new ArrayList<String>();
        for (EntityKey key: keys) {
            keyStrings.add(
                "\t\t" +
                key
                    .toString()
                    .replace(
                "\t",
                "\t\t\t"
                    )
                    .replace(
                "}",
                "\t\t}"
                    )
            );
        }
        ArrayList<String> doorStrings = new ArrayList<String>();
        for (EntityDoor door: doorsDone) {
            doorStrings.add(
                "\t\t" +
                    door
                        .toString()
                        .replace(
                                "\t",
                                "\t\t\t"
                        )
                        .replace(
                                "}",
                                "\t\t}"
                        )
            );
        }
        String state = "{\n" +
            "\t\"level\": " + level + ",\n" +
            "\t\"position\": {\n" +
            " \t\t\"x\": " + x + " ,\n" +
            "\t\t\"y\": " + y + "\n" +
            "\t},\n" +
            "\t\"keys\": [\n" +
                    String.join(
                        ",\n",
                        keyStrings
                    ) + "\n\t],\n" +
            "\t\"doors\": [\n" +
                    String.join(
                        ",\n",
                        doorStrings
                    ) + "\n\t]\n" +
            "}";

        return state;
    }

}