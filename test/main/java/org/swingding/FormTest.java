package main.java.org.swingding;

import org.junit.Assert;
import org.junit.Test;
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

        // Wait for form to show
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
        Assert.assertEquals(form.panel.player.x, 0);
        Assert.assertEquals(form.panel.player.y, 0);

        // Made by Pawel
    }
}