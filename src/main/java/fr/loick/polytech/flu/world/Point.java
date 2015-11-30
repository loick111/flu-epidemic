package fr.loick.polytech.flu.world;

/**
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public class Point {
    /**
     * Position X
     */
    Integer x;
    /**
     * Position Y
     */
    Integer y;

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Move to another direction
     *
     * @param direction direction
     * @return new position
     */
    public Point move(Direction direction) {
        Point point = null;

        switch (direction) {
            case NORTH:
                point = new Point(x, y - 1);
                break;
            case SOUTH:
                point = new Point(x, y + 1);
                break;
            case EAST:
                point = new Point(x + 1, y);
                break;
            case WEST:
                point = new Point(x - 1, y);
                break;
        }

        return point;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != null ? !x.equals(point.x) : point.x != null) return false;
        return !(y != null ? !y.equals(point.y) : point.y != null);
    }
}
