import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Canvas
 */
public class Canvas extends JPanel {
<<<<<<< HEAD
    // Auto generated serial
    private static final long serialVersionUID = 8999265021216122578L;
    public static Player player = new Player();
    public static ArrayList<Entity> map = new ArrayList<Entity>();

    Canvas() {
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
        map.add(new Entity(4, 6, new int[] {0,255,0}, new ShapeSquare(), 0));

        // TODO: Door entity
        Entity door = new Entity(5, 6, new int[] {0,0,255}, new ShapeSquare() {}, 0);
        door.type = "DOOR";
        map.add(door);

        // TODO: Key entity
        Entity key = new Entity(8, 8, new int[] {255,255,0}, new ShapeSquare() {}, 0);
        key.type = "KEY";
        map.add(key);

        map.add(new Entity(6, 6, new int[] {0,255,0}, new ShapeSquare() {}, 0));
    }
=======
    private static final long serialVersionUID = 8999265021216122578L;
    public static Pen pen = new Pen();
>>>>>>> d6a450ed0aebcbad41931d08368a97518c975b36

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(new java.awt.Color(255, 255, 255));

<<<<<<< HEAD
        drawPoints(g, map);
    }

    private void drawPlayer(Graphics g, Player p) { 
        int calculatedX = 15+(50*p.y);
        int calculatedY = 15+(50*p.x);

        Graphics2D body = (Graphics2D)g;
        body.setColor(new Color(p.getCurrentColor()[0], p.getCurrentColor()[1], p.getCurrentColor()[2]));
        body.fill(player.currentShape.getPath(calculatedX, calculatedY, p.rotation));
=======
        drawPoints(g, pen.getTraces());
    }

    private void drawPen(Graphics g, Pen p) {
        int calculatedX = 15 + (50 * p.y);
        int calculatedY = 15 + (50 * p.x);

        Graphics2D body = (Graphics2D) g;
        body.setColor(new Color(p.getCurrentColor()[0], p.getCurrentColor()[1], p.getCurrentColor()[2]));
        body.fill(pen.currentShape.getPath(calculatedX, calculatedY, p.rotation));
>>>>>>> d6a450ed0aebcbad41931d08368a97518c975b36
        body.setColor(new Color(0, 0, 0));
        body.drawRect(calculatedX, calculatedY, 50, 50);
    }

<<<<<<< HEAD
    private void drawPoints(Graphics g, ArrayList<Entity> entities) { 
        for (Entity entity : entities) {
            int calculatedX = 15+(50*entity.y);
            int calculatedY = 15+(50*entity.x);

            Graphics2D body = (Graphics2D)g;
            body.setColor(new Color(entity.rgb[0], entity.rgb[1], entity.rgb[2]));
            body.fill(entity.shape.getPath(calculatedX, calculatedY, entity.rotation));
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
        System.out.println("Removing " + index);
        map.remove(index);
=======
    private void drawPoints(Graphics g, ArrayList<ColorDrop> ColorDropList) {
        for (ColorDrop e : ColorDropList) {
            int calculatedX = 15 + (50 * e.y);
            int calculatedY = 15 + (50 * e.x);

            Graphics2D body = (Graphics2D) g;
            body.setColor(new Color(e.rgb[0], e.rgb[1], e.rgb[2]));
            body.fill(e.shape.getPath(calculatedX, calculatedY, e.rotation));
        }

        drawPen(g, pen);
>>>>>>> d6a450ed0aebcbad41931d08368a97518c975b36
    }
}
  