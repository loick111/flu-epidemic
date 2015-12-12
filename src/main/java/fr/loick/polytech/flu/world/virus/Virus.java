package fr.loick.polytech.flu.world.virus;

import fr.loick.polytech.flu.world.creatures.Creature;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public abstract class Virus {

    private Collection<Class<? extends Creature>> infectables;
    private Double infectionRatio;

    private Virus() {

    }

    protected Virus(Double infectionRatio) {
        this.infectionRatio = infectionRatio;
        this.infectables = new ArrayList<>();
    }

    protected void addInfectable(Class<? extends Creature> creatureClass) {
        infectables.add(creatureClass);
    }

    public boolean canInfect(Creature creature) {
        return infectables.contains(creature.getClass());
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public Double getInfectionRatio() {
        return infectionRatio;
    }
}
