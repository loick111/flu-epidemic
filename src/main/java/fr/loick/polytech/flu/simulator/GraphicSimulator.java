package fr.loick.polytech.flu.simulator;

import fr.loick.polytech.flu.views.WorldMapView;
import fr.loick.polytech.flu.world.creatures.Chicken;
import fr.loick.polytech.flu.world.creatures.Duck;
import fr.loick.polytech.flu.world.creatures.Human;
import fr.loick.polytech.flu.world.creatures.Pig;

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
        super.reset();
        if (view != null)
            view.dispose();
    }
}
