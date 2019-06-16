package main.java.org.swingding;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.util.ArrayList;
/**
 * Canvas
 */
public class Canvas extends JPanel {
    private static final long serialVersionUID = 112031231023018201L; // Auto generated serial
    public static int WIDTH = 10;
    public static int HEIGHT = 10;
    public static ArrayList<Entity> map;
    public Player player;
    public static int lastPlayerLevel = 0;

    public Canvas()
    {
        player = new Player();
        lastPlayerLevel = player.level;
        map = new Map(player.level).getLayout();
    }

    /**
     * 
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new Color(255, 255, 255));

        if(lastPlayerLevel != player.level) {
            lastPlayerLevel = player.level;
            player.x = 0;
            player.y = 0;

            ArrayList<Entity> newMap = new Map(player.level).getLayout();
            if(newMap.size() > 0) {
                map = newMap;
            } else {
                player.level = 1;
                lastPlayerLevel = player.level;
                map = new Map(player.level).getLayout();
            }

            repaint();
        }
        drawEntities(g, map);
    }

    /**
     * 
     * @param g
     * @param p
     */
    private void drawPlayer(Graphics g, Player p) { 
        int calculatedX = 15+(50*p.y);
        int calculatedY = 15+(50*p.x);

        Graphics2D body = (Graphics2D)g;
        try {
            body.drawImage(p.getImage(p.direction), calculatedX, calculatedY, 50, 50, null);
        } catch (Exception e) {
            body.setColor(new Color(255, 255, 255));
            body.fill(new ShapeSquare().getPath(calculatedX, calculatedY, 1));
            body.setColor(new Color(0, 0, 0));
            body.drawRect(calculatedX, calculatedY, 50, 50);
        }
    }

    /**
     * 
     * @param g
     * @param entities
     */
    private void drawEntities(Graphics g, ArrayList<Entity> entities) { 
        for (Entity entity : entities) {
            int calculatedX = 15+(50*entity.y);
            int calculatedY = 15+(50*entity.x);

            Graphics2D body = (Graphics2D)g;

            if(entity instanceof EntityDoor){
                boolean doorDone = false;
                for (EntityDoor playerDoneDoor : player.doorsDone) {
                    if(((EntityDoor)entity).unlockValue == playerDoneDoor.unlockValue && ((EntityDoor)entity).x == playerDoneDoor.x && ((EntityDoor)entity).y == playerDoneDoor.y)
                    {
                        doorDone = true;
                    }
                }

                if(!doorDone) {
                    try {
                        body.drawImage(((EntityDoor) entity).getImage(0), calculatedX, calculatedY, 50, 50, null);
                    } catch (Exception e) {
                        body.setColor(new Color(entity.rgb[0], entity.rgb[1], entity.rgb[2]));
                        body.fill(new ShapeSquare().getPath(calculatedX, calculatedY, entity.direction));
                    }
                }
            } else if(entity instanceof EntityKey) {
                boolean keyExists = false;
                for (EntityKey playerKey : player.keys) {
                    if(((EntityKey)entity).keyValue == playerKey.keyValue && ((EntityKey)entity).x == playerKey.x && ((EntityKey)entity).y == playerKey.y)
                    {
                        keyExists = true;
                    }
                }

                if(!keyExists) {
                    try {
                        body.drawImage(((EntityKey)entity).getImage(0), calculatedX, calculatedY, 50, 50, null);
                    } catch (Exception e) {
                        body.setColor(new Color(entity.rgb[0], entity.rgb[1], entity.rgb[2]));
                        body.fill(new ShapeTriangle().getPath(calculatedX, calculatedY, entity.direction));
                    }
                }
            } else {
                body.setColor(new Color(entity.rgb[0], entity.rgb[1], entity.rgb[2]));
                body.fill(entity.shape.getPath(calculatedX, calculatedY, entity.direction));
            }
        }

        drawPlayer(g, player);
    }

    /**
     * 
     * @param x
     * @param y
     * @return
     */
    public static Entity getEntity(int x, int y) {
        // Maybe we need to use void entity to know that the entity is empty or invalid
        Entity requested = null;
        for (Entity entity : map) {
            if(entity.x == x && entity.y == y) {
                requested = entity;
            }
        }
        return requested;
    }

    /**
     * 
     * @param x
     * @param y
     */
    public static void removeEntity(int x, int y) {
        int index = -1;
        for (Entity entity : map) {
            if(entity.x == x && entity.y == y) {
                index = map.indexOf(entity);
            }
        }
        map.remove(index);
    }
}
  