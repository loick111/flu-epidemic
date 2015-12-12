package fr.loick.polytech.flu.world;

/**
 * This object represents direction
 *
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public enum Direction {
    NORTH("North"), SOUTH("South"), EAST("East"), WEST("West");

    private String name;

    Direction(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
