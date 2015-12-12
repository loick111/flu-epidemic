package fr.loick.polytech.flu;

import fr.loick.polytech.flu.simulator.ConsoleSimulator;
import fr.loick.polytech.flu.simulator.GraphicSimulator;

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

	GraphicSimulator consoleSimulator = new GraphicSimulator();


	OptionGraphic frame = new OptionGraphic();
		while(true)
		{	
			Thread.sleep(1000);	
			if ( frame.getGo() )
			{
				frame.setGo(false);
				//simulate.reset();
				consoleSimulator.reset();
        			consoleSimulator.run( frame.getStep() + 1 ) ;
				//simulate.simulate( frame.getStep() );
			}
		}
	}
}
