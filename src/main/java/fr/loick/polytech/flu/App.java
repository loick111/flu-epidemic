package fr.loick.polytech.flu;

import fr.loick.polytech.flu.simulator.ConsoleSimulator;

/**
 * Flu Epidemic App
 *
 * @author Loïck MAHIEUX
 * @date 30/11/2015
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        ConsoleSimulator consoleSimulator = new ConsoleSimulator();
        consoleSimulator.run(1000);
    }
}
