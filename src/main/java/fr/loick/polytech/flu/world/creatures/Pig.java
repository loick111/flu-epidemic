package fr.loick.polytech.flu.world.creatures;

import fr.loick.polytech.flu.world.virus.H1N1;

/**
 * This object represents pig creature
 *
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public class Pig extends Creature {
    public Pig() {
        super();
        virus = new H1N1();
    }
}
