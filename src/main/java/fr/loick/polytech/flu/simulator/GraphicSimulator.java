package fr.loick.polytech.flu.simulator;

import fr.loick.polytech.flu.views.WorldMapView;
import fr.loick.polytech.flu.world.Chunk;
import fr.loick.polytech.flu.world.creatures.*;

import java.awt.*;

/**
 * Console Simulator
 *
 * @author Ulysse RICCIO
 */
public class GraphicSimulator extends Simulator {

    // A graphical view of the simulation.
    private WorldMapView view;

    public void run(Integer steps) throws InterruptedException {

        view = new WorldMapView(worldMap.getHeight(), worldMap.getWidth());
        view.setColor(Pig.class, Color.ORANGE);
        view.setColor(Human.class, Color.BLUE);
        view.setColor(Duck.class, Color.RED);
        view.setColor(Chicken.class, Color.GREEN);

        populate();

        for (; step < steps; step++) {
            view.showStatus(step, worldMap);
            Thread.sleep(100);
            step();
        }
    }

    /**
     * Reset the simulation to a starting position.
     */
    public void reset() {

        step = 0;

        if (view != null)
            view.dispose();

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
}
