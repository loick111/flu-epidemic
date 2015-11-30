package fr.loick.polytech.flu.world;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public class DirectionTest {
    @Test
    public void testName() {
        assertEquals("North", Direction.NORTH.toString());
        assertEquals("South", Direction.SOUTH.toString());
        assertEquals("East", Direction.EAST.toString());
        assertEquals("West", Direction.WEST.toString());
    }
}