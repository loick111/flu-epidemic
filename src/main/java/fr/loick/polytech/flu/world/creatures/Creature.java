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
    private Integer age;

    public Creature() {
        age = 1;
        state = State.HEALTHY;
        virus = null;
    }

    public void contactWith(Creature creature) {
        if (virus == null || !virus.canInfect(creature))
            return;

        
    }

    public void old() {
        age++;
    }

    @Override
    public String toString() {
        if (virus != null)
            return this.getClass().getSimpleName() + "(" + virus + ")";
        return this.getClass().getSimpleName().substring(0, 1);
    }

    public boolean isDead() {
        return state.equals(State.DEAD);
    }
}
