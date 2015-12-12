package fr.loick.polytech.flu.world;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.sun.javafx.fxml.expression.Expression.not;
import static fr.loick.polytech.flu.world.Direction.*;
import static fr.loick.polytech.flu.world.Neighbourhood.DIAGONAL;

/**
 * @author Loïck MAHIEUX
 * @date 12/12/15
 */
public class ChunkAnalyzer {

    private WorldMap worldMap;

    public ChunkAnalyzer(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public List<Chunk> neighbourChunks(Chunk chunk) {
        List<Location> potentials = new ArrayList<>();

        Location location = new Location(chunk.getX(), chunk.getY());
        Location north = location.move(NORTH);
        Location south = location.move(SOUTH);
        Location east = location.move(EAST);
        Location west = location.move(WEST);

        Location northEast = north.move(EAST);
        Location northWest = north.move(WEST);
        Location southEast = south.move(EAST);
        Location southWest = south.move(WEST);

        if (north.getX() >= 0
                && north.getX() < worldMap.getWidth()
                && north.getY() >= 0
                && north.getY() < worldMap.getHeight())
            potentials.add(north);
        if (south.getX() >= 0
                && south.getX() < worldMap.getWidth()
                && south.getY() >= 0
                && south.getY() < worldMap.getHeight())
            potentials.add(south);
        if (east.getX() >= 0
                && east.getX() < worldMap.getWidth()
                && east.getY() >= 0
                && east.getY() < worldMap.getHeight())
            potentials.add(east);
        if (west.getX() >= 0
                && west.getX() < worldMap.getWidth()
                && west.getY() >= 0
                && west.getY() < worldMap.getHeight())
            potentials.add(west);

        if (DIAGONAL.equals(worldMap.getNeighbourhood())) {
            if (northEast.getX() >= 0
                    && northEast.getX() < worldMap.getWidth()
                    && northEast.getY() >= 0
                    && northEast.getY() < worldMap.getHeight())
                potentials.add(northEast);
            if (northWest.getX() >= 0
                    && northWest.getX() < worldMap.getWidth()
                    && northWest.getY() >= 0
                    && northWest.getY() < worldMap.getHeight())
                potentials.add(northWest);
            if (southEast.getX() >= 0
                    && southEast.getX() < worldMap.getWidth()
                    && southEast.getY() >= 0
                    && southEast.getY() < worldMap.getHeight())
                potentials.add(southEast);
            if (southWest.getX() >= 0
                    && southWest.getX() < worldMap.getWidth()
                    && southWest.getY() >= 0
                    && southWest.getY() < worldMap.getHeight())
                potentials.add(southWest);
        }

        return potentials.stream().map(l -> worldMap.getChunks().get(l.getY()).get(l.getX())).collect(Collectors.toList());
    }

    public List<Chunk> potentialChunks(Chunk chunk) {
        return neighbourChunks(chunk).stream().filter(Chunk::isFree).collect(Collectors.toList());
    }

    public List<Chunk> neighbourChunksCreatures(Chunk chunk) {
        return neighbourChunks(chunk).stream().filter(c -> !c.isFree()).collect(Collectors.toList());
    }
}
