package fr.loick.polytech.flu.world;

/**
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public class Location {
    /**
     * Position X
     */
    private Integer x;
    /**
     * Position Y
     */
    private Integer y;

    public Location(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Move to another direction
     *
     * @param direction direction
     * @return new position
     */
    public Location move(Direction direction) {
        Location location = null;

        switch (direction) {
            case NORTH:
                location = new Location(x, y - 1);
                break;
            case SOUTH:
                location = new Location(x, y + 1);
                break;
            case EAST:
                location = new Location(x + 1, y);
                break;
            case WEST:
                location = new Location(x - 1, y);
                break;
        }

        return location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Location location = (Location) o;

        if (x != null ? !x.equals(location.x) : location.x != null) return false;
        return !(y != null ? !y.equals(location.y) : location.y != null);
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
}
