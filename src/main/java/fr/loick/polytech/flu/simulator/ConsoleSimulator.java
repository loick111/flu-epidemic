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
            step();

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
