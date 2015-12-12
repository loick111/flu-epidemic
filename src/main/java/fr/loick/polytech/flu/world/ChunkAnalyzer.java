package fr.loick.polytech.flu.world;

import java.util.ArrayList;
import java.util.List;

import static fr.loick.polytech.flu.world.Direction.*;
import static fr.loick.polytech.flu.world.Neighbourhood.*;

/**
 * @author Loïck MAHIEUX
 * @date 12/12/15
 */
public class ChunkAnalyzer {

    private WorldMap worldMap;

    public ChunkAnalyzer(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    public List<Location> potentialChunks(Chunk chunk) {
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
                && north.getY() < worldMap.getHeight()
                && worldMap.getChunks().get(north.getY()).get(north.getX()).isFree())
            potentials.add(north);
        if (south.getX() >= 0
                && south.getX() < worldMap.getWidth()
                && south.getY() >= 0
                && south.getY() < worldMap.getHeight()
                && worldMap.getChunks().get(south.getY()).get(south.getX()).isFree())
            potentials.add(south);
        if (east.getX() >= 0
                && east.getX() < worldMap.getWidth()
                && east.getY() >= 0
                && east.getY() < worldMap.getHeight()
                && worldMap.getChunks().get(east.getY()).get(east.getX()).isFree())
            potentials.add(east);
        if (west.getX() >= 0
                && west.getX() < worldMap.getWidth()
                && west.getY() >= 0
                && west.getY() < worldMap.getHeight()
                && worldMap.getChunks().get(west.getY()).get(west.getX()).isFree())
            potentials.add(west);

        if(DIAGONAL.equals(worldMap.getNeighbourhood())) {
            if (northEast.getX() >= 0
                    && northEast.getX() < worldMap.getWidth()
                    && northEast.getY() >= 0
                    && northEast.getY() < worldMap.getHeight()
                    && worldMap.getChunks().get(northEast.getY()).get(northEast.getX()).isFree())
                potentials.add(northEast);
            if (northWest.getX() >= 0
                    && northWest.getX() < worldMap.getWidth()
                    && northWest.getY() >= 0
                    && northWest.getY() < worldMap.getHeight()
                    && worldMap.getChunks().get(northWest.getY()).get(northWest.getX()).isFree())
                potentials.add(northWest);
            if (southEast.getX() >= 0
                    && southEast.getX() < worldMap.getWidth()
                    && southEast.getY() >= 0
                    && southEast.getY() < worldMap.getHeight()
                    && worldMap.getChunks().get(southEast.getY()).get(southEast.getX()).isFree())
                potentials.add(southEast);
            if (southWest.getX() >= 0
                    && southWest.getX() < worldMap.getWidth()
                    && southWest.getY() >= 0
                    && southWest.getY() < worldMap.getHeight()
                    && worldMap.getChunks().get(southWest.getY()).get(southWest.getX()).isFree())
                potentials.add(southWest);
        }

        return potentials;
    }
}
