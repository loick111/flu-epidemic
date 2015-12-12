package fr.loick.polytech.flu.simulator;

import fr.loick.polytech.flu.world.Chunk;
import fr.loick.polytech.flu.world.ChunkAnalyzer;
import fr.loick.polytech.flu.world.Location;
import fr.loick.polytech.flu.world.creatures.Creature;

import java.util.List;
import java.util.Random;

/**
 * Console Simulator
 *
 * @author Loïck MAHIEUX
 */
public class ConsoleSimulator extends Simulator {
    public void run(Integer steps) {
        populate();
        System.out.println(worldMap);

        for (;step < steps; step++) {

            for (int x = 0; x < worldMap.getWidth(); x++) {
                for (int y = 0; y < worldMap.getHeight(); y++) {
                    Chunk chunk = worldMap.getChunks().get(y).get(x);
                    Creature creature = chunk.getCreature();

                    if (creature != null) {
                        ChunkAnalyzer chunkAnalyzer = new ChunkAnalyzer(worldMap);
                        List<Location> potentialChunks = chunkAnalyzer.potentialChunks(chunk);

                        // Move
                        if (!potentialChunks.isEmpty()) {
                            Random random = new Random();
                            Location location = potentialChunks.get(random.nextInt(potentialChunks.size()));
                            Chunk toChunk = worldMap.getChunks().get(location.getY()).get(location.getX());
                            chunk.moveCreature(toChunk);
                        }
                    }
                }
            }

            System.out.println(worldMap);
        }
    }
}
