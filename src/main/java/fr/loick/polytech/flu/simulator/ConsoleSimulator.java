package fr.loick.polytech.flu.simulator;

import fr.loick.polytech.flu.world.Chunk;
import fr.loick.polytech.flu.world.ChunkAnalyzer;
import fr.loick.polytech.flu.world.creatures.*;

import java.util.List;
import java.util.Random;

/**
 * Console Simulator
 *
 * @author Loïck MAHIEUX
 */
public class ConsoleSimulator extends Simulator {
    public void run(Integer steps) throws InterruptedException {
        populate();
        ChunkAnalyzer chunkAnalyzer = new ChunkAnalyzer(worldMap);

        System.out.println("Nombre de créatures : " + chunkAnalyzer.countCreatures());
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
                        List<Chunk> neighborsChunksCreatures = chunkAnalyzer.neighbourChunksCreatures(chunk);

                        // contact
                        for (Chunk c : neighborsChunksCreatures)
                            creature.contactWith(c.getCreature());

                        // move
                        if (!potentialChunks.isEmpty()) {
                            Random random = new Random();
                            Chunk toChunk = potentialChunks.get(random.nextInt(potentialChunks.size()));
                            chunk.moveCreature(toChunk);
                        }
                    }
                }
            }

            System.out.println("Step " + step);
            System.out.println(chunkAnalyzer.countCreatures() + " creatures");
            System.out.println(chunkAnalyzer.countCreatures(Pig.class) + " Pig(s)");
            System.out.println(chunkAnalyzer.countCreatures(Human.class) + " Human(s)");
            System.out.println(chunkAnalyzer.countCreatures(Duck.class) + " Duck(s)");
            System.out.println(chunkAnalyzer.countCreatures(Chicken.class) + " Chicken(s)");
            System.out.println("");
            System.out.println(worldMap);
            Thread.sleep(100);
            System.out.println("\u001b[2J");
        }
    }
}
