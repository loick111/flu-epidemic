package fr.loick.polytech.flu.simulator;

import fr.loick.polytech.flu.world.Chunk;
import fr.loick.polytech.flu.world.ChunkAnalyzer;
import fr.loick.polytech.flu.world.Neighbourhood;
import fr.loick.polytech.flu.world.WorldMap;
import fr.loick.polytech.flu.world.creatures.Creature;
import fr.loick.polytech.flu.world.creatures.CreatureFactory;
import fr.loick.polytech.flu.world.creatures.RandomCreatureFactory;

import java.util.List;
import java.util.Random;

/**
 * Simulator
 *
 * @author Loïck MAHIEUX
 */
public abstract class Simulator {

    public static final Double CONTACT_RATE = 0.3;
    private static final int DEFAULT_WIDTH = 10;
    private static final int DEFAULT_HEIGHT = 20;
    protected Integer step;
    protected WorldMap worldMap;
    private ChunkAnalyzer chunkAnalyzer;

    public Simulator() {
        this(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public Simulator(Integer width, Integer height) {
        if (width <= 0 || height <= 0) {
            System.out.println("The dimensions must be greater than zero.");
            System.out.println("Using default values.");
            height = DEFAULT_HEIGHT;
            width = DEFAULT_WIDTH;
        }

        step = 0;
        worldMap = new WorldMap(width, height, Neighbourhood.NORMAL);
        chunkAnalyzer = new ChunkAnalyzer(worldMap);
    }

    public abstract void run(Integer steps) throws InterruptedException;

    public void reset() {
        step = 0;
        for (int x = 0; x < worldMap.getWidth(); x++) {
            for (int y = 0; y < worldMap.getHeight(); y++) {

                Chunk chunk = worldMap.getChunks().get(y).get(x);
                Creature creature = chunk.getCreature();
                if (creature != null) {
                    chunk.removeCreature();
                }
            }
        }
    }

    protected void step() {
        Random random = new Random();
        for (int x = 0; x < worldMap.getWidth(); x++) {
            for (int y = 0; y < worldMap.getHeight(); y++) {
                Chunk chunk = worldMap.getChunks().get(y).get(x);
                Creature creature = chunk.getCreature();

                // if chunk is not free
                if (creature != null) {

                    // update creature
                    creature.update();

                    // free chunk if is dead
                    if (creature.isDead()) {
                        chunk.removeCreature();
                        continue;
                    }

                    // get neighbors
                    List<Chunk> potentialChunks = chunkAnalyzer.potentialChunks(chunk);
                    List<Chunk> neighborsChunksCreatures = chunkAnalyzer.neighbourChunksCreatures(chunk);

                    // contact with neighbors
                    neighborsChunksCreatures.stream().filter(c -> random.nextInt(100) < CONTACT_RATE * 100).forEach(c -> creature.contactWith(c.getCreature()));

                    // move
                    if (creature.move(potentialChunks))
                        chunk.removeCreature();
                }
            }
        }
    }

    protected void populate() {
        Random random = new Random();
        CreatureFactory creatureFactory = new RandomCreatureFactory();

        for (int x = 0; x < worldMap.getWidth(); x++) {
            for (int y = 0; y < worldMap.getHeight(); y++) {
                Chunk chunk = worldMap.getChunks().get(y).get(x);
                if (random.nextInt(100) < WorldMap.CREATURE_RATE * 100)
                    chunk.add(creatureFactory.create());
            }
        }
    }
}
