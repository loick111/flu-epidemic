package fr.loick.polytech.flu.world;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public class LocationTest {
    @Test
    public void testMove() throws Exception {
        Location point = new Location(12, 23);
        assertEquals(new Location(12, 24), point.move(Direction.SOUTH));
        assertEquals(new Location(12, 22), point.move(Direction.NORTH));
        assertEquals(new Location(11, 23), point.move(Direction.WEST));
        assertEquals(new Location(13, 23), point.move(Direction.EAST));
    }
}