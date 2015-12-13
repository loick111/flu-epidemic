package fr.loick.polytech.flu.world.creatures;

import fr.loick.polytech.flu.world.Chunk;
import fr.loick.polytech.flu.world.State;

import java.util.List;
import java.util.Random;

/**
 * @author Loïck MAHIEUX
 * @date 13/12/15
 */
public abstract class Animal extends Creature {

    private static final Double DEATH_RATE = 0.6;

    @Override
    protected Double infectCreature(Creature creature) {
        if (creature instanceof Human)
            return 0.2;
        return super.infectCreature(creature);
    }

    @Override
    public boolean isHealthy() {
        return State.HEALTHY.equals(getState())
                || (State.CONTAGIOUS == getState() && getAge() - getStateAge() > getVirus().getContagiousTime());
    }

    @Override
    public boolean move(List<Chunk> potentialChunks) {
        return false;
    }

    @Override
    public void update() {
        super.update();
        Random random = new Random();

        if (State.CONTAGIOUS == getState() && getAge() - getStateAge() == getVirus().getContagiousTime())
            if (random.nextInt(100) < DEATH_RATE * 100)
                changeState(State.DEAD);
    }
}
