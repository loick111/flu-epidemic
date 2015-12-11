//package foxesandrabbits.v1;

//import foxesandrabbits.graph.Randomizer;
//import foxesandrabbits.graph.Simulator;

import javax.swing.*;
import java.awt.event.*;

/*
	@author : Ulysse RICCIO
*/

public class Main {
	
	public static void main(String[] args) throws InterruptedException{
Simulator simulate=new Simulator();
OptionGraphic frame = new OptionGraphic();
//simulate.simulate(300);
		while(true)
		{	
			Thread.sleep(1000);	
			if ( frame.getGo() )
			{
				frame.setGo(false);
				simulate.reset();
				//simulate.simulate(300);
				simulate.simulate( frame.getStep() );
			}
		}
	}
}
