package main.java.org.swingding;

import java.awt.Panel;

public class Form {
    /**
     * Level boundry unit test
     * This unit test will make sure that the player cant walk off the map
     */
    @Test
    public static void levelBoundry() {
        Form form = new Form();
        form.setAccesible(true); // acces private stuff

        int widthOfOperation = form.get(panel).WIDTH;
        int heightOfOperation = form.get(panel).HEIGHT;

        // Test around level boundry
        method.invoke(form.get(panel).player.left);
        assertEquals(form.get(panel).player.x, 10, "player position x=0");
    }
}