import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Canvas
 */
public class Canvas extends JPanel {
    // Auto generated serial
    private static final long serialVersionUID = 8999265021216122578L;
    public static int WIDTH = 12;
    public static int HEIGHT = 10;
    public static ArrayList<Entity> map = new ArrayList<Entity>();

    public Player player = new Player();

    Canvas() {
        // TODO: instead of entity we should use the subclass... Kan gedaan worden via files en een for-loop of switch statement.
        // This is the "map"
        map.add(new Entity(3, 3, new int[] {0,255,0}, new ShapeSquare(), 0));
        map.add(new Entity(4, 3, new int[] {0,255,0}, new ShapeSquare(), 0));
        map.add(new Entity(5, 3, new int[] {0,255,0}, new ShapeSquare(), 0));
        map.add(new Entity(6, 3, new int[] {0,255,0}, new ShapeSquare(), 0));

        map.add(new Entity(3, 4, new int[] {0,255,0}, new ShapeSquare(), 0));
        map.add(new Entity(6, 4, new int[] {0,255,0}, new ShapeSquare(), 0));

        map.add(new Entity(3, 5, new int[] {0,255,0}, new ShapeSquare(), 0));
        map.add(new Entity(6, 5, new int[] {0,255,0}, new ShapeSquare(), 0));

        map.add(new Entity(3, 6, new int[] {0,255,0}, new ShapeSquare(), 0));
        map.add(new Entity(6, 6, new int[] {0,255,0}, new ShapeSquare(), 0));

        map.add(new Entity(3, 6, new int[] {0,255,0}, new ShapeSquare(), 0));
        map.add(new Entity(6, 6, new int[] {0,255,0}, new ShapeSquare(), 0));

        {
            // TODO: Door entity
            Entity door = new EntityDoor(5, 6, new int[] {0,100,255}, new ShapeSquare() {}, 0, 1);
            door.type = "DOOR";
            map.add(door);

            // TODO: Key entity
            Entity key = new EntityKey(8, 8, new int[] {0,50,255}, new ShapeSquare() {}, 0, 1);
            key.type = "KEY";
            map.add(key);
        }

        {
            // TODO: Door entity
            Entity door = new EntityDoor(4, 6, new int[] {0,255,100}, new ShapeSquare() {}, 0, 2);
            door.type = "DOOR";
            map.add(door);

            // TODO: Key entity
            Entity key = new EntityKey(0, 8, new int[] {0,255,50}, new ShapeSquare() {}, 0, 2);
            key.type = "KEY";
            map.add(key);
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new java.awt.Color(255, 255, 255));

        drawEntities(g, map);
    }

    private void drawPlayer(Graphics g, Player p) { 
        int calculatedX = 15+(50*p.y);
        int calculatedY = 15+(50*p.x);

        Graphics2D body = (Graphics2D)g;
        body.setColor(new Color(255, 0, 0));
        body.fill(player.currentShape.getPath(calculatedX, calculatedY, 1));
        body.setColor(new Color(0, 0, 0));
        body.drawRect(calculatedX, calculatedY, 50, 50);
    }

    private void drawEntities(Graphics g, ArrayList<Entity> entities) { 
        for (Entity entity : entities) {
            int calculatedX = 15+(50*entity.y);
            int calculatedY = 15+(50*entity.x);

            Graphics2D body = (Graphics2D)g;
            // Color from the entity sounds good but the path is something every entity has to have different.. direction is just optional
            body.setColor(new Color(entity.rgb[0], entity.rgb[1], entity.rgb[2]));
            body.fill(entity.shape.getPath(calculatedX, calculatedY, entity.direction));
        }

        drawPlayer(g, player);
    }

    // TODO make this simple and not so redundant 
    public static boolean isCollision(int x, int y) {
        boolean r = false;
        for (Entity entity : map) {
            if(entity.x == x && entity.y == y) {
                r = true;
            }
        }
        return r;
    }

    public static boolean isDoor(int x, int y) {
        boolean r = false;
        for (Entity entity : map) {
            if(entity.x == x && entity.y == y && entity.type == "DOOR") {
                r = true;
            }
        }
        return r;
    }

    public static boolean isKey(int x, int y) {
        boolean r = false;
        for (Entity entity : map) {
            if(entity.x == x && entity.y == y && entity.type == "KEY") {
                r = true;
            }
        }
        return r;
    }

    public static Entity getEntity(int x, int y) {
        // Maybe we need to use void entity to know that the entity is empty or invalid
        Entity requested = new Entity(-1, -1, new int[] {255,255,255}, new ShapeSquare(), 0);
        for (Entity entity : map) {
            if(entity.x == x && entity.y == y) {
                requested = entity;
            }
        }
        return requested;
    }

    public static void remove(int x, int y) {
        int index = -1;
        for (Entity entity : map) {
            if(entity.x == x && entity.y == y) {
                index = map.indexOf(entity);
            }
        }
        map.remove(index);
    }

    
}
  