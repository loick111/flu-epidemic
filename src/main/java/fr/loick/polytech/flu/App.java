package fr.loick.polytech.flu;

import fr.loick.polytech.flu.simulator.GraphicSimulator;
import fr.loick.polytech.flu.views.LauncherView;

/**
 * Flu Epidemic App
 *
 * @author Loïck MAHIEUX and Ulysse RICCIO
 * @date 30/11/2015
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        //ConsoleSimulator consoleSimulator = new ConsoleSimulator();
        //consoleSimulator.run(1000);

	GraphicSimulator simulator = new GraphicSimulator();
	LauncherView frame = new LauncherView();
		while(true)
		{	
			Thread.sleep(1000);	
			if ( frame.getGo() )
			{
				frame.setGo(false);
				//simulate.reset();
				simulator.reset();
        			simulator.run( frame.getStep() + 1 ) ;
				//simulate.simulate( frame.getStep() );
			}
		}
	}
}
