package fr.loick.polytech.flu.simulator;

import fr.loick.polytech.flu.world.Chunk;
import fr.loick.polytech.flu.world.ChunkAnalyzer;
import fr.loick.polytech.flu.world.creatures.*;

import java.util.List;
import java.util.Random;
import java.awt.Color;

import fr.loick.polytech.flu.world.Chunk;
import fr.loick.polytech.flu.world.Neighbourhood;
import fr.loick.polytech.flu.world.WorldMap;
import fr.loick.polytech.flu.world.creatures.CreatureFactory;
import fr.loick.polytech.flu.world.creatures.RandomCreatureFactory;

/**
 * Console Simulator
 *
 * @author Ulysse RICCIO
 */
public class GraphicSimulator extends Simulator {

// A graphical view of the simulation.
    private SimulatorView view;

    public void run(Integer steps) throws InterruptedException {

	// Create a view of the state of each location in the field.
        view = new SimulatorView(worldMap.getHeight(), worldMap.getWidth());
        view.setColor(Pig.class, Color.ORANGE);
        view.setColor(Human.class, Color.BLUE);	
	view.setColor(Duck.class, Color.RED);
        view.setColor(Chicken.class, Color.GREEN);	

	//for (; step < steps; step++)
	 //{
		
	//}

        populate();
        ChunkAnalyzer chunkAnalyzer = new ChunkAnalyzer(worldMap);

        System.out.println("Nombre de créatures : " + chunkAnalyzer.countCreatures());
        System.out.println(worldMap);
	 for (; step < steps; step++) {
view.showStatus( step , worldMap );
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

	/**
     * Reset the simulation to a starting position.
     */
    public void reset() {

        step = 0;
        //rabbits.clear();
        //foxes.clear();
        //populate();

        // Show the starting state in the view.
        //view.showStatus(step, field);

	if ( view != null )
	view.dispose();

	for (int x = 0; x < worldMap.getWidth(); x++) {
                for (int y = 0; y < worldMap.getHeight(); y++) {

		Chunk chunk = worldMap.getChunks().get(y).get(x);
                    Creature creature = chunk.getCreature();
		if (creature != null) {
			chunk.removeCreature();
		}
	}}


    }
}
