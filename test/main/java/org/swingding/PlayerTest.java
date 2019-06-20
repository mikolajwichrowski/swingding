package main.java.org.swingding;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class PlayerTest {

    /**
     * Unit Tests for Player class.
     * The four move method tests are for the requirement:
     *  - "Poppetje kan over de x en y as van het scherm bewegen."
     *  - "Deze beweging verloopt per vlak net als een pion in een schaakspel."
     * The collision method tests are for the requirement:
     * - "Muren weerhouden het poppetje om er tegen aan te lopen."
     * - "Sleutels openen deuren. "
     * - "......"
     * The save state test is for the nice-to-have requirement:
     * - "Na het opslaan van het spel kan de speler weer verder spelen als hij het spel opnieuw opstart."
     */

    @Test
    public void leftTest() {
        Player test = new Player();

        // Place player on location
        test.x = 3;
        test.y = 4;

        // Move player
        test.left();

        // Check player location
        Assert.assertEquals(3, test.x);
        Assert.assertEquals(3, test.y);

        // Made by Tiko
    }

    @Test
    public void rightTest() {
        Player test = new Player();

        // Place player
        test.x = 6;
        test.y = 5;

        // Move player
        test.right();

        // Check player location
        Assert.assertEquals(6, test.x);
        Assert.assertEquals(6, test.y);

        // Made by Tiko
    }

    @Test
    public void upTest() {
        Player test = new Player();

        // Place player
        test.x = 2;
        test.y = 4;

        // Move player
        test.up();

        // Check player location
        Assert.assertEquals(1, test.x);
        Assert.assertEquals(4, test.y);

        // Made by Tiko
    }

    @Test
    public void downTest() {
        Player test = new Player();

        // Place player
        test.x = 9;
        test.y = 9;

        // Move player
        test.down();

        // Check player location
        Assert.assertEquals(10, test.x);
        Assert.assertEquals(9, test.y);

        // Made by Tiko
    }

    @Test
    public void tryToWalkIntoWallTest() {
        Form form = new Form();
        Player player = new Player();
        EntityWall wall = new EntityWall(4, 3, new int[] {0,255,0}, new ShapeSquare(), 0);

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

        // If u use this assert, you will see what will happen if the wall has no collision
        // Change the doCollision method in entity wall as instructed
        // Assert.assertEquals(3, form.panel.player.y);

        // Made by Mikolaj
    }

    @Test
    public void tryToWalkIntoDoorWithoutKeyTest() {
        Form form = new Form();
        Player player = new Player();
        EntityDoor door = new EntityDoor(4, 3, new int[] {0,255,0}, null, 1);

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

        // Made by Mikolaj
    }

    @Test
    public void tryToWalkIntoDoorWithKeyTest() {
        Form form = new Form();
        Player player = new Player();
        player.keys.add(new EntityKey(0,0, new int[] {0,255,0}, null, 1));
        EntityDoor door = new EntityDoor(4, 3, new int[] {0,255,0}, null, 1);

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

        // Made by Mikolaj
    }

    @Test
    public void tryToWalkIntoKeyTest() {
        Form form = new Form();
        Player player = new Player();
        EntityKey key = new EntityKey(4,3, new int[] {0,255,0}, null, 1);

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
}
