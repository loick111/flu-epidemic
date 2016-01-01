package fr.loick.polytech.flu.simulator;

import fr.loick.polytech.flu.world.ChunkAnalyzer;
import fr.loick.polytech.flu.world.creatures.Chicken;
import fr.loick.polytech.flu.world.creatures.Duck;
import fr.loick.polytech.flu.world.creatures.Human;
import fr.loick.polytech.flu.world.creatures.Pig;

/**
 * Console Simulator
 *
 * @author Loïck MAHIEUX and Ulysse RICCIO
 */
public class ConsoleSimulator extends Simulator {

	public	ConsoleSimulator( boolean neighbourhood ) 
	{
        super(neighbourhood);
    }

    public void run(Integer steps) throws InterruptedException {
        populate();
        ChunkAnalyzer chunkAnalyzer = new ChunkAnalyzer(worldMap);

        System.out.println("Nombre de créatures : " + chunkAnalyzer.countCreatures());
        System.out.println(worldMap);

        for (; step < steps; step++) {
            step();

            System.out.println("Step " + step);
            System.out.println(chunkAnalyzer.countCreatures() + " creatures " + chunkAnalyzer.countSickCreatures() + " sick");
            System.out.println(chunkAnalyzer.countCreatures(Pig.class) + " Pig(s) " + chunkAnalyzer.countSickCreatures(Pig.class) + " sick");
            System.out.println(chunkAnalyzer.countCreatures(Human.class) + " Human(s) " + chunkAnalyzer.countSickCreatures(Human.class) + " sick");
            System.out.println(chunkAnalyzer.countCreatures(Duck.class) + " Duck(s) " + chunkAnalyzer.countSickCreatures(Duck.class) + " sick");
            System.out.println(chunkAnalyzer.countCreatures(Chicken.class) + " Chicken(s) " + chunkAnalyzer.countSickCreatures(Chicken.class) + " sick");
            System.out.println("");
            System.out.println(worldMap);
            Thread.sleep(100);
        }
    }
}
