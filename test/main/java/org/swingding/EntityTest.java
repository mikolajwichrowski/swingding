package main.java.org.swingding;

import org.junit.Assert;
import org.junit.Test;

public class EntityTest {
    @Test
    public void EntityTest() {
        Entity test = new Entity(4, 3, new int[] {60,60,64}, new ShapeSquare(), 0);
        Assert.assertNotNull(test);
        //Test to see if an entity can be made on its own, out of the blue.

    }
}
