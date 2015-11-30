package fr.loick.polytech.flu.world;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public class PointTest {
    @Test
    public void testMove() throws Exception {
        Point point = new Point(12, 23);
        assertEquals(new Point(12, 24), point.move(Direction.SOUTH));
        assertEquals(new Point(12, 22), point.move(Direction.NORTH));
        assertEquals(new Point(11, 23), point.move(Direction.WEST));
        assertEquals(new Point(13, 23), point.move(Direction.EAST));
    }
}