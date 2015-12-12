package fr.loick.polytech.flu.world.virus;

import fr.loick.polytech.flu.world.creatures.Creature;

import java.util.Collection;

/**
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public abstract class Virus {

    private Collection<Class<? extends Creature>> infectables;

    protected void addInfectable(Creature creature) {
        infectables.add(creature.getClass());
    }

    abstract boolean infect(Creature creature);
}
