package fr.loick.polytech.flu.world.creatures;

import fr.loick.polytech.flu.world.State;
import fr.loick.polytech.flu.world.virus.Virus;

import java.util.Random;

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

        Random random = new Random();
        Double infectionRatio = virus.getInfectionRatio();

        if (random.nextInt(100) < infectionRatio * 100)
            creature.virus = virus;
    }

    public void old() {
        age++;
    }

    public boolean isDead() {
        return state.equals(State.DEAD);
    }

    @Override
    public String toString() {
        if (virus != null)
            return "(" + this.getClass().getSimpleName().substring(0, 1) + ")";
        return " " + this.getClass().getSimpleName().substring(0, 1);
    }
}
