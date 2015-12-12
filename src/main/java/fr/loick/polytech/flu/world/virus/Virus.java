package fr.loick.polytech.flu.world.virus;

import fr.loick.polytech.flu.world.creatures.Creature;

import java.util.Collection;

/**
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public abstract class Virus {

    private Collection<Class<? extends Creature>> infectables;

    protected void addInfectable(Class<? extends Creature> creatureClass) {
        infectables.add(creatureClass);
    }

    public boolean canInfect(Creature creature) {
        return infectables.contains(creature.getClass());
    }
}
