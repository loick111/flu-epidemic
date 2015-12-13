package fr.loick.polytech.flu.world.creatures;

import fr.loick.polytech.flu.world.State;
import fr.loick.polytech.flu.world.virus.H1N1;
import fr.loick.polytech.flu.world.virus.H5N1;

import java.util.Random;

/**
 * This object represents human creature
 *
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public class Human extends Creature {

    public static final Double DEATH_RATE = 0.5;
    public static final Double VACCINATED_RATE = 0.1;

    public Human() {
        super();
        Random random = new Random();
        if (random.nextInt(100) < VACCINATED_RATE * 100)
            addAntibodies(H1N1.class);
        if (random.nextInt(100) < VACCINATED_RATE * 100)
            addAntibodies(H5N1.class);
    }

    @Override
    protected Double infectCreature(Creature creature) {
        if (creature instanceof Human)
            return 1.;
        return 0.;
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
