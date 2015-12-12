package fr.loick.polytech.flu.simulator;

import fr.loick.polytech.flu.world.Chunk;
import fr.loick.polytech.flu.world.Neighbourhood;
import fr.loick.polytech.flu.world.WorldMap;
import fr.loick.polytech.flu.world.creatures.CreatureFactory;
import fr.loick.polytech.flu.world.creatures.RandomCreatureFactory;

import java.util.Random;

/**
 * Simulator
 *
 * @author Loïck MAHIEUX
 */
public abstract class Simulator {

    private static final int DEFAULT_WIDTH = 20;
    private static final int DEFAULT_HEIGHT = 10;

    protected Integer step;
    protected WorldMap worldMap;

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
    }

    abstract void run(Integer steps);

    public void populate() {
        Random random = new Random();
        CreatureFactory creatureFactory = new RandomCreatureFactory();

        for (int x = 0; x < worldMap.getWidth(); x++) {
            for (int y = 0; y < worldMap.getHeight(); y++) {
                Chunk chunk = worldMap.getChunks().get(y).get(x);
                if (random.nextInt(100) < 20)
                    chunk.add(creatureFactory.create());
            }
        }
    }
}
