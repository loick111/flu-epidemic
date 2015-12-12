package fr.loick.polytech.flu.world.virus;

import fr.loick.polytech.flu.world.creatures.Creature;

/**
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public class H1N1 extends Virus {
    @Override
    public boolean infect(Creature creature) {
        return false;
    }
}
