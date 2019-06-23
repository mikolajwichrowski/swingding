package main.java.org.swingding;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PlayerTest {

    /**
     * Unit Tests for Player class.
     * The four move method tests are for the requirement:
     * - "Poppetje kan over de x en y as van het scherm bewegen."
     * - "Deze beweging verloopt per vlak net als een pion in een schaakspel."
     * The collision method tests are for the requirement:
     * - "Muren weerhouden het poppetje om er tegen aan te lopen."
     * - "Sleutels openen deuren. "
     * - "......"
     * The save state test is for the nice-to-have requirement:
     * - "Na het opslaan van het spel kan de speler weer verder spelen als hij het spel opnieuw opstart."
     */

    @Test
    public void leftTest() throws AWTException {
        Form form = new Form(); //Instantiate Form (with player on it)
        Robot robot = new Robot(); //Used for simulating KeyEvents.

        // Location of the player on form (X and Y coordinates.
        form.panel.player.x = 3;
        form.panel.player.y = 4;

        // Simulate KeyPressed event with a slight artificial delay. (Move the player that belongs to form)
        robot.setAutoDelay(200);
        robot.keyPress(KeyEvent.VK_LEFT);

        // Check player location to make sure the player moved.
        Assert.assertEquals(3, form.panel.player.x);
        Assert.assertEquals(3, form.panel.player.y);
        Assert.assertNotEquals(4, form.panel.player.y);

        // Made for requirement: Player can move across the empty spaces of the panel/field/form.
        // This test tests the actual instance of player belonging to the board by simulating a key event through Robot. This test is to make sure that the player can move left.
        // Made by Tiko
    }

    @Test
    public void rightTest() throws AWTException {
        Form form = new Form(); //Instance of form (Form loads the objects that are on it, including the player.
        Robot robot = new Robot(); //Used for simulating KeyEvents.

        // Location of the player on form (X and Y coordinates.
        form.panel.player.x = 6;
        form.panel.player.y = 5;

        // Simulate KeyPressed event with a slight artificial delay. (Move the player that belongs to form)
        robot.setAutoDelay(200);
        robot.keyPress(KeyEvent.VK_RIGHT);

        // Check player location
        Assert.assertEquals(6, form.panel.player.x);
        Assert.assertEquals(6, form.panel.player.y);
        Assert.assertNotEquals(5, form.panel.player.y);

        // Second test for requirement: Player can move across the empty spaces of the panel/field/form.
        // This test tests the actual instance of player belonging to the board by simulating a key event through Robot. This test is to make sure that the player can move right.
        // Made by Tiko
    }

    @Test
    public void upTest() throws AWTException {
        Form form = new Form();
        Robot robot = new Robot();

        // Location of the player on form (X and Y coordinates)
        form.panel.player.x = 2;
        form.panel.player.y = 4;

        // Simulate KeyPressed event with a slight artificial delay. (Move the player that belongs to form)
        robot.setAutoDelay(200);
        robot.keyPress(KeyEvent.VK_UP);

        // Check player location
        Assert.assertEquals(1, form.panel.player.x);
        Assert.assertEquals(4, form.panel.player.y);
        Assert.assertNotEquals(2, form.panel.player.x);

        // Third test for requirement: Player can move across the empty spaces of the panel/field/form.
        // This test tests the actual instance of player belonging to the board by simulating a key event through Robot. This test is to make sure that the player can move up.
        // Made by Tiko
    }

    @Test
    public void downTest() throws AWTException {
        Form form = new Form();
        Robot robot = new Robot();

        // Location of the player on form (X and Y coordinates)
        form.panel.player.x = 9;
        form.panel.player.y = 9;

        // Simulate KeyPressed event with a slight artificial delay. (Move the player that belongs to form)
        robot.setAutoDelay(200);
        robot.keyPress(KeyEvent.VK_DOWN);

        // Check player location
        Assert.assertEquals(10, form.panel.player.x);
        Assert.assertEquals(9, form.panel.player.y);
        Assert.assertNotEquals(9, form.panel.player.x);

        // Fourth and final test for requirement: Player can move across the empty spaces of the panel/field/form.
        // This test tests the actual instance of player belonging to the board by simulating a key event through Robot. This test is to make sure that the player can move down.
        // Made by Tiko
    }

    @Test
    public void tryToWalkIntoWallTest() {
        Form form = new Form();
        Player player = new Player();
        EntityWall wall = new EntityWall(4, 3, new int[]{0, 255, 0}, new ShapeSquare(), 0);

        // Add map with one wall
        form.panel.map = new ArrayList<Entity>();
        form.panel.map.add(wall);
        form.panel.player = player;

        // Place player on position
        form.panel.player.x = 4;
        form.panel.player.y = 4;

        // Move player
        form.panel.player.left();
        form.panel.player.left();

        // Check player location
        Assert.assertEquals(4, form.panel.player.x);
        Assert.assertEquals(4, form.panel.player.y);

        // Check that player is not on the new position
        Assert.assertNotEquals(3, form.panel.player.y);

        // Made by Mikolaj
    }

    @Test
    public void tryToWalkIntoDoorWithoutKeyTest() {
        Form form = new Form();
        Player player = new Player();
        EntityDoor door = new EntityDoor(4, 3, new int[]{0, 255, 0}, null, 1);

        // Add map with one door
        form.panel.map = new ArrayList<Entity>();
        form.panel.map.add(door);
        form.panel.player = player;

        // Place player on position
        form.panel.player.x = 4;
        form.panel.player.y = 4;

        // Move player
        form.panel.player.left();
        form.panel.player.left();

        // Test player position
        Assert.assertEquals(4, form.panel.player.x);
        Assert.assertEquals(4, form.panel.player.y);

        // Check that player is not on the new position
        Assert.assertNotEquals(3, form.panel.player.y);

        // Made by Mikolaj
    }

    @Test
    public void tryToWalkIntoDoorWithKeyTest() {
        Form form = new Form();
        Player player = new Player();
        player.keys.add(new EntityKey(0, 0, new int[]{0, 255, 0}, null, 1));
        EntityDoor door = new EntityDoor(4, 3, new int[]{0, 255, 0}, null, 1);

        // Add clear map with one key
        form.panel.map = new ArrayList<Entity>();
        form.panel.map.add(door);
        form.panel.player = player;

        // Place player on position
        form.panel.player.x = 4;
        form.panel.player.y = 4;

        // Move player
        form.panel.player.left();
        form.panel.player.left();

        // Check player position
        Assert.assertEquals(4, form.panel.player.x);
        Assert.assertEquals(3, form.panel.player.y);

        // Check that player is not on the old position
        Assert.assertNotEquals(4, form.panel.player.y);

        // Made by Mikolaj
    }

    @Test
    public void tryToWalkIntoKeyTest() {
        Form form = new Form();
        Player player = new Player();
        EntityKey key = new EntityKey(4, 3, new int[]{0, 255, 0}, null, 1);

        // Add clear map with one key
        form.panel.map = new ArrayList<Entity>();
        form.panel.map.add(key);
        form.panel.player = player;

        // Place player on position
        form.panel.player.x = 4;
        form.panel.player.y = 4;

        // Move player
        form.panel.player.left();
        form.panel.player.left();

        // Test player position and amount of keys
        Assert.assertEquals(4, form.panel.player.x);
        Assert.assertEquals(3, form.panel.player.y);
        Assert.assertEquals(1, form.panel.player.keys.size());

        // Made by Mikolaj
    }

    @Test
    public void saveStateTest() {
        // Create save state
        Player player = new Player();
        player.x = 5;
        player.y = 5;
        player.level = 5;
        FileUtil.fileWriter("state.json", player.toString());

        // Check save state
        JSONObject jobj = new JSONObject(FileUtil.fileReader("./state.json"));
        Assert.assertEquals(5, jobj.getJSONObject("position").getInt("x"));
        Assert.assertEquals(5, jobj.getJSONObject("position").getInt("y"));
        Assert.assertEquals(5, jobj.getInt("level"));

        // Clear save after test
        player.x = 0;
        player.y = 0;
        player.level = 0;
        player.keys = new ArrayList<EntityKey>();
        FileUtil.fileWriter("state.json", player.toString());

        // Made by Pawel
    }

    @Test
    public void loadStateTest() {
        // Create save state
        Player player = new Player();
        player.x = 5;
        player.y = 5;
        player.level = 5;
        FileUtil.fileWriter("state.json", player.toString());

        // Reload player
        player = new Player();

        // Test to see if save state is loaded
        Assert.assertEquals(5, player.x);
        Assert.assertEquals(5, player.y);
        Assert.assertEquals(5, player.level);

        // Clear save after test
        player.x = 0;
        player.y = 0;
        player.level = 0;
        player.keys = new ArrayList<EntityKey>();
        FileUtil.fileWriter("state.json", player.toString());

        // Made by Pawel
    }

    @Test
    public void restartTest() {
        Form form = new Form();
        form.panel.map = new ArrayList<Entity>();

        int originalPosition = form.panel.player.y;
        form.panel.player.right();
        Assert.assertEquals(form.panel.player.y, originalPosition + 1);
        form.reloadEvent();
        Assert.assertEquals(form.panel.player.y, originalPosition);

        // Made by Pawel
    }
}
