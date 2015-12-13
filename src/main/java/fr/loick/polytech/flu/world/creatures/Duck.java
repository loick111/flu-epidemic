package fr.loick.polytech.flu.world.creatures;

import fr.loick.polytech.flu.world.Chunk;
import fr.loick.polytech.flu.world.State;

import java.util.List;
import java.util.Random;

/**
 * This object represents duck creature
 *
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public class Duck extends Creature {

    private static final Double DEATH_RATE = 0.6;

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
