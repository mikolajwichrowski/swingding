package main.java.org.swingding;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;


public class FormTest {
    /**
     * Level boundary test:
     * - This is a integration test and will make sure that the player cant walk off the map
     * Reload test:
     * - Makes sure the game reloads properly
     */

    @Test
    public void levelBoundaryTest() throws InterruptedException
    {
        // Wait for other tests to run
        Thread.sleep(1000);

        Form form = new Form();

        int widthOfOperation = form.panel.WIDTH;
        int heightOfOperation = form.panel.HEIGHT;
        form.panel.map = new ArrayList<Entity>();
        form.panel.repaint();

        // Testing works around but not (yet) in the corners
        //
        //      00||00
        //      0####0
        //      -####-
        //      -####-
        //      0####0
        //      00||00

        // Wait for form to show. The timeouts are not necessary but it's nice to show what this tests does
        Thread.sleep(1000);

        for(int s = 1; s <= 4; s++) {                           // For every side
            if(s%2==1) {                                        // Top and bottom side
                for(int w = 0; w <= widthOfOperation; w++) {    // Over the width of the map
                    if(s==1) {                                  // If first side
                        Thread.sleep(200);               // Top side
                        form.panel.player.right();              // Move right
                        form.panel.player.up();                 // Try to move up
                        form.panel.repaint();                   // Repaint to show the that the test is indeed running
                        Assert.assertEquals(0, form.panel.player.x);
                    } else {
                        Thread.sleep(200);               // Bottom side
                        form.panel.player.left();               // Move left
                        form.panel.player.down();               // Try to move left
                        form.panel.repaint();                   // Repaint to show the that the test is indeed running
                        Assert.assertEquals(heightOfOperation, form.panel.player.x);
                    }
                }
            } else {
                for (int h = 0; h <= heightOfOperation; h++) {  // Over the height of the map
                    if (s == 2) {                               // If second side
                        Thread.sleep(200);               // Right side
                        form.panel.player.down();               // Move down
                        form.panel.player.right();              // Try to move right
                        form.panel.repaint();                   // Repaint to show the that the test is indeed running
                        Assert.assertEquals(widthOfOperation, form.panel.player.y);
                    } else {
                        Thread.sleep(200);               // Left side
                        form.panel.player.up();                 // Move up
                        form.panel.player.left();               // Try to move left
                        form.panel.repaint();                   // Repaint to show the that the test is indeed running
                        Assert.assertEquals(0, form.panel.player.y);
                    }
                }
            }
        }

        // Made by Mikolaj
    }

    @Test
    public void reloadTest()
    {
        Form form = new Form();

        // Add empty canvas with one panel
        form.panel.map = new ArrayList<Entity>();
        form.panel.player.right();

        // Reload panel
        form.reloadEvent();

        // Test if player is back to starting position
        Assert.assertEquals(0, form.panel.player.x);
        Assert.assertEquals(0, form.panel.player.y);

        // Made by Mikolaj
    }

    @Test
    public void replayTest()
    {
        Form form = new Form();

        // Add empty canvas with one panel
        form.panel.map = new ArrayList<Entity>();
        form.panel.player.right();

        int previousLevel = form.panel.player.level;

        // Reload panel
        form.replayEvent();

        // Test if player is back to starting position
        Assert.assertEquals(0, form.panel.player.x);
        Assert.assertEquals(0, form.panel.player.y);
        Assert.assertEquals(previousLevel, form.panel.player.level);

        // Made by Mikolaj
    }

    @Test
    public void MoreKeysTest() {
        Form form = new Form();

        // Add an empty canvas and multiple keys to it.
        form.panel.map = new ArrayList<Entity>();
        form.panel.map.add(new EntityKey(2, 4, new int[] {0, 0, 0}, new ShapeSquare(), 3));
        form.panel.map.add(new EntityKey(2, 1, new int[] {0, 0, 0}, new ShapeSquare(), 3));
        form.panel.map.add(new EntityKey(1,1, new int[] {255, 255, 255}, new ShapeSquare(), 2));
        form.panel.map.add(new EntityKey(9,9, new int[] {66, 66, 66}, new ShapeSquare(), 1));
        form.panel.map.add(new EntityKey(8,8, new int[] {66, 66, 66}, new ShapeSquare(), 1));
        form.panel.map.add(new EntityKey(7,7, new int[] {66, 66, 66}, new ShapeSquare(), 1));

        // Count the total number of kays on the map and each type of keys.
        int total = form.panel.map.size();

        // Test to see if there really are six keys on the map, using the total variable, and another test using the size variable directly.
        Assert.assertEquals(6, total);
        Assert.assertEquals(6, form.panel.map.size());

        // Test for requirement: There can be more than one key on the field at a time.
        // This test makes a new empty map, adds keys onto them for different types and then counts them up to see if there can be more than one key on the field at a time.
        // Made by Tiko.

        /**int type1, type2, type3 = 0; 

        for (int i = 0; i < form.panel.map.size(); i++) {
            if
        }*/

    }
}