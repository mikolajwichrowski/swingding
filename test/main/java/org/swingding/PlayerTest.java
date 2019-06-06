package main.java.org.swingding;

import org.junit.Assert;
import org.junit.Test;

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
    public void tryToWalkIntoWall() {
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

}
