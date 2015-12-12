package fr.loick.polytech.flu.simulator;

import fr.loick.polytech.flu.world.Chunk;
import fr.loick.polytech.flu.world.ChunkAnalyzer;
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
        ChunkAnalyzer chunkAnalyzer = new ChunkAnalyzer(worldMap);
        System.out.println(worldMap);

        for (; step < steps; step++) {

            for (int x = 0; x < worldMap.getWidth(); x++) {
                for (int y = 0; y < worldMap.getHeight(); y++) {
                    Chunk chunk = worldMap.getChunks().get(y).get(x);
                    Creature creature = chunk.getCreature();

                    // if chunk is not free
                    if (creature != null) {
                        creature.old();

                        // free chunk if is dead
                        if (creature.isDead())
                            chunk.removeCreature();

                        // get neighbors
                        List<Chunk> potentialChunks = chunkAnalyzer.potentialChunks(chunk);
                        List<Chunk> neighborsChunks = chunkAnalyzer.neighbourChunks(chunk);
                        List<Chunk> neighborsChunksCreatures = chunkAnalyzer.neighbourChunksCreatures(chunk);

                        // contact
                        for (Chunk c : neighborsChunksCreatures)
                            creature.contactWith(c.getCreature());

                        // move
                        if (!potentialChunks.isEmpty()) {
                            Random random = new Random();
                            Chunk toChunk = neighborsChunks.get(random.nextInt(neighborsChunks.size()));
                            chunk.moveCreature(toChunk);
                        }
                    }
                }
            }

            System.out.println(worldMap);
        }
    }
}
