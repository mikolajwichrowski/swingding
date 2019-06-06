package main.java.org.swingding;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    public ArrayList<EntityKey> keys = new ArrayList<EntityKey>();

    @Test
    public BufferedImage getImage(int direction) throws Exception {
        BufferedImage image = ImageIO.read(new File(Paths.get("").toAbsolutePath().toString() + "/images/zygmund.png"));
        long zygmundLength = 32437; //expected size of zygmund image file.
        DataBuffer buff = image.getData().getDataBuffer(); //DataBuffer for calculation of image size.
        long size = ((long) buff.getSize()) * 4l; //Size is in here!

        assertNotNull(image); //Make sure it is a thing. This is the important one.
        assertEquals(zygmundLength, size); //Make sure the zygmund image is the expected size.
        return null;
    }

    @Test
    private void addKey(EntityKey entity) {
        keys.add(entity);
        assertNotNull(entity); //Make sure it is a thing.
    }

    @Test
    private boolean unlock(EntityDoor entity) {

        boolean keyFound = false;
        for (EntityKey key : keys) {
            if(key.keyValue == entity.unlockValue) {
                keyFound = true;
            }
        }
        return keyFound;
    }

    @Test
    private void doCollision(Entity collisioned) {
        if (collisioned instanceof EntityDoor && unlock((EntityDoor)collisioned)) {
            Canvas.removeEntity(collisioned.x, collisioned.y);
        } else if (collisioned instanceof EntityKey) {
            addKey((EntityKey)collisioned);
            Canvas.removeEntity(collisioned.x, collisioned.y);
        }
    }
}
