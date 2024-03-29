package fr.loick.polytech.flu;

import fr.loick.polytech.flu.simulator.GraphicSimulator;
import fr.loick.polytech.flu.simulator.Simulator;
import fr.loick.polytech.flu.views.LauncherView;

/**
 * Flu Epidemic App
 *
 * @author Loïck MAHIEUX
 * @author Ulysse RICCIO
 * @date 30/11/2015
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
//        new ConsoleSimulator().run(1000);

        Simulator simulator = null;
        LauncherView frame = new LauncherView();
	
        while (true) {
            Thread.sleep(1000);
            if (frame.getGo()) {

		simulator = new GraphicSimulator( frame.get4Connected() );
		
		frame.setGo(false);
                simulator.reset();
		simulator.setSleep(frame.getStep1());
		simulator.run(frame.getStep()+1);
            }
        }
    }
}
