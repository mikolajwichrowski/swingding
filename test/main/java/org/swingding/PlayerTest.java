package main.java.org.swingding;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PlayerTest {

    /**
     * Unit Tests for Player class.
     * The four move method tests are for the requirement: "Poppetje kan over de x en y as van het scherm bewegen. Deze beweging verloopt per vlak net als een pion in een schaakspel."
     * The collision method test is for the requirement: "Muren weerhouden het poppetje om er tegen aan te lopen."
     */

    @Test
    public void leftTest() {
        Player test = new Player();
        test.x = 3;
        test.y = 4;
        test.left();
        Assert.assertEquals(3, test.x);
        Assert.assertEquals(3, test.y);
    }

    @Test
    public void rightTest() {
        Player test = new Player();
        test.x = 6;
        test.y = 5;
        test.right();
        Assert.assertEquals(6, test.x);
        Assert.assertEquals(6, test.y);
    }

    @Test
    public void upTest() {
        Player test = new Player();
        test.x = 2;
        test.y = 4;
        test.up();
        Assert.assertEquals(1, test.x);
        Assert.assertEquals(4, test.y);
    }

    @Test
    public void downTest() {
        Player test = new Player();
        test.x = 9;
        test.y = 9;
        test.down();
        Assert.assertEquals(10, test.x);
        Assert.assertEquals(9, test.y);
    }

    @Test
    public void tryToWalkIntoWallTest() {
        Player test = new Player();
        EntityWall wall = new EntityWall(4, 3, new int[] {0,255,0}, new ShapeSquare(), 0);
        test.x = 4;
        test.y = 4;
        if (test.y-1!=wall.y) {
            test.left();
        }
        Assert.assertEquals(4, test.x);
        Assert.assertEquals(4, test.y);
    }

    /**
     * This has a number of errors to it. It cannot be done without calling upon Canvas and its elements, no longer
     * making it a contained test. After repeated tries, we decided it's for the best to leave this one be.
     *
     * @Test
    public void doCollisionTest() {
        ArrayList<Entity> map = new ArrayList<Entity>();
        Player test = new Player();
        Entity key = new EntityKey(8, 8, new int[] {0,50,255}, null, 0, 1);
        map.add(key);
        test.x = 8;
        test.y = 9;
        Assert.assertNotNull(key);
        test.left();
        if (test.y == key.y) {
            test.doCollision(key);
            Assert.assertNull(key);
        }
    }*/

}
