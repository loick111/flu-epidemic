package fr.loick.polytech.flu.simulator;

import fr.loick.polytech.flu.views.WorldMapView;
import fr.loick.polytech.flu.world.creatures.Chicken;
import fr.loick.polytech.flu.world.creatures.Duck;
import fr.loick.polytech.flu.world.creatures.Human;
import fr.loick.polytech.flu.world.creatures.Pig;

import java.awt.*;

import fr.loick.polytech.flu.views.GraphView;

/**
 * Console Simulator
 *
 * @author Ulysse RICCIO
 */
public class GraphicSimulator extends Simulator {

    // A graphical view of the simulation.
    private WorldMapView view;
	private int sleep = 150;

	private GraphView secondFrame = null;

	private boolean exit = false;

	public GraphicSimulator( boolean neighbourhood ) 
{
        super(neighbourhood);
    }

    public void run(Integer steps) throws InterruptedException {

        view = new WorldMapView(worldMap.getHeight(), worldMap.getWidth());
        view.setColor(Pig.class, Color.ORANGE);
        view.setColor(Human.class, Color.BLUE);
        view.setColor(Duck.class, Color.RED);
        view.setColor(Chicken.class, Color.GREEN);

	

        populate();

	secondFrame = new GraphView( 250,250,250, chunkAnalyzer );

	secondFrame.setColor(Pig.class, Color.ORANGE);
	secondFrame.setColor(Human.class, Color.BLUE);
	secondFrame.setColor(Duck.class, Color.RED);
        secondFrame.setColor(Chicken.class, Color.GREEN);

        for (; step < steps; step++) {

		if ( exit )
			break;
            view.showStatus(step, worldMap);
		secondFrame.showStatus(step);
            Thread.sleep(sleep);
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

	/**
     * Reset the simulation to a starting position.
     */
    public void setSleep( int sleep ) {
        this.sleep = sleep;
    }

	public void setExit( boolean exit ) {
        this.exit = exit;
    }
}
