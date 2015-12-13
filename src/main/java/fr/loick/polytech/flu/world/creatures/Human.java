package fr.loick.polytech.flu.world.creatures;

import fr.loick.polytech.flu.world.State;

import java.util.Random;

/**
 * This object represents human creature
 *
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public class Human extends Creature {

    public static final Double DEATH_RATE = 0.5;

    @Override
    public void contactWith(Creature creature) {
        if (creature instanceof Human)
            super.contactWith(creature);
    }

    @Override
    public void update() {
        super.update();
        Random random = new Random();

        if (State.SICK == getState() && getAge() - getStateAge() == getVirus().getIncubationTime())
            changeState(State.CONTAGIOUS);

        if (State.CONTAGIOUS == getState() && getAge() - getStateAge() == getVirus().getContagiousTime()) {
            if (random.nextInt(100) < DEATH_RATE * 100)
                changeState(State.DEAD);
            else
                changeState(State.RECOVERING);
        }

        if (State.RECOVERING == getState() && getAge() - getStateAge() == getVirus().getRecoveringTime())
            recover();
    }
}
