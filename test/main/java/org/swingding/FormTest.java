package main.java.org.swingding;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FormTest {
    /**
     * Level boundary unit test
     * This unit test will make sure that the player cant walk off the map
     */
    @Test
    public void levelBoundary() throws InterruptedException {
        Form form = new Form();


        int widthOfOperation = form.panel.WIDTH;
        int heightOfOperation = form.panel.HEIGHT;

        // Test around level boundary
        for(int s = 1; s <= 4; s++) {
            if(s%2==1) {
                for(int w = 0; w <= widthOfOperation; w++) {
                    if(s==1) {
                        // Top
                        form.panel.player.right();
                        form.panel.player.up();
                        assertEquals(0, form.panel.player.x, "player walking of on the top of map");
                    } else {
                        // Bottom
                        form.panel.player.down();
                        assertEquals(heightOfOperation, form.panel.player.x, "player walking of on the bottom of map");
                    }
                    
                }
            } else {
                for(int h = 0; h <= heightOfOperation; h++) {
                    if(s==2) {
                        // Right
                        form.panel.player.down();
                        form.panel.player.right();
                        assertEquals(widthOfOperation, form.panel.player.y, "player walking of on the right of map");
                    } else {
                        // Left
                        form.panel.player.up();
                        form.panel.player.left();
                        assertEquals(0, form.panel.player.y, "player walking of on the left of map");
                    }
                }
            }
            
        }
    }
}