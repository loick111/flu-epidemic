package fr.loick.polytech.flu.world.creatures;

import fr.loick.polytech.flu.states.State;
import fr.loick.polytech.flu.world.virus.Virus;

/**
 * This object represents creature
 *
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public abstract class Creature {

    protected State state;
    protected Virus virus;

    public Creature() {
        state = State.HEALTHY;
        virus = null;
    }

    public abstract void act();

    public abstract void undergo();

    public Boolean isInfectable() {
        if (state == State.DEAD)
            return false;
        if (state == State.CONTAGIOUS)
            return false;
        if (state == State.SICK)
            return false;
        return true;
    }

    @Override
    public String toString() {
        if (virus != null)
            return this.getClass().getSimpleName() + "(" + virus + ")";
        return this.getClass().getSimpleName().substring(0, 1);
    }
}
