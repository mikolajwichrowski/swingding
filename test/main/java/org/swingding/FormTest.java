package main.java.org.swingding;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormTest {
    /**
     * Level boundary unit test
     * This is a integration test and will make sure that the player cant walk off the map
     */
    @Test
    public void levelBoundary() throws InterruptedException {
        Form form = new Form();

        int widthOfOperation = form.panel.WIDTH;
        int heightOfOperation = form.panel.HEIGHT;

        // Testing works around but not in the corners
        //
        //      00||00
        //      0####0
        //      -####-
        //      -####-
        //      0####0
        //      00||00

        Thread.sleep(2000);

        for(int s = 1; s <= 4; s++) {                           // For every side
            if(s%2==1) {                                        // Top and bottom side
                for(int w = 0; w <= widthOfOperation; w++) {    // Over the width of the map
                    if(s==1) {                                  // If first side
                        Thread.sleep(500);               // Top side
                        form.panel.player.right();              // Move right
                        form.panel.player.up();                 // Try to move up
                        form.panel.repaint();                   // Repaint to show the that the test is indeed running
                        assertEquals(0, form.panel.player.x, "player walking of on the top of map");
                    } else {
                        Thread.sleep(500);               // Bottom side
                        form.panel.player.left();               // Move left
                        form.panel.player.down();               // Try to move left
                        form.panel.repaint();                   // Repaint to show the that the test is indeed running
                        assertEquals(heightOfOperation, form.panel.player.x, "player walking of on the bottom of map");
                    }
                }
            } else {
                for (int h = 0; h <= heightOfOperation; h++) {  // Over the height of the map
                    if (s == 2) {                               // If second side
                        Thread.sleep(500);               // Right side
                        form.panel.player.down();               // Move down
                        form.panel.player.right();              // Try to move right
                        form.panel.repaint();                   // Repaint to show the that the test is indeed running
                        assertEquals(widthOfOperation, form.panel.player.y, "player walking of on the right of map");
                    } else {
                        Thread.sleep(500);               // Left side
                        form.panel.player.up();                 // Move up
                        form.panel.player.left();               // Try to move left
                        form.panel.repaint();                   // Repaint to show the that the test is indeed running
                        assertEquals(0, form.panel.player.y, "player walking of on the left of map");
                    }
                }
            }
        }
    }
}