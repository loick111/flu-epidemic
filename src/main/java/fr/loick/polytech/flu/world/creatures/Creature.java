package fr.loick.polytech.flu.world.creatures;

import fr.loick.polytech.flu.world.Chunk;
import fr.loick.polytech.flu.world.State;
import fr.loick.polytech.flu.world.virus.Virus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This object represents creature
 *
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public abstract class Creature {

    private List<Class<? extends Virus>> antibodies;

    private Virus virus;
    private Integer age;
    private State state;
    private Integer stateAge;
    private Double speedRate;

    public Creature() {
        antibodies = new ArrayList<>();
        virus = null;
        age = 0;
        state = State.HEALTHY;
        stateAge = 0;
        speedRate = 1.;
    }

    protected void changeState(State state) {
        this.state = state;
        stateAge = age;
        if (State.RECOVERING.equals(state))
            speedRate = 0.5;
        if (State.HEALTHY.equals(state))
            speedRate = 1.;
    }

    protected void fallIll(Virus virus) {
        this.virus = virus;
        changeState(State.SICK);
    }

    protected void recover() {
        antibodies.add(virus.getClass());
        virus = null;
        changeState(State.HEALTHY);
    }

    protected void addAntibodies(Class<? extends Virus> virusClass) {
        antibodies.add(virusClass);
    }

    protected Double infectCreature(Creature creature) {
        return 1.;
    }

    public boolean move(List<Chunk> potentialChunks) {
        if (potentialChunks.isEmpty())
            return false;

        Random random = new Random();

        if (random.nextInt(100) >= speedRate * 100)
            return false;

        Chunk chunk = potentialChunks.get(random.nextInt(potentialChunks.size()));
        chunk.add(this);
        return true;
    }

    public void contactWith(Creature creature) {
        if (creature.virus != null)
            return;

        if (virus == null || !virus.canInfect(creature))
            return;

        if (creature.antibodies.contains(virus.getClass()))
            return;

        Random random = new Random();
        Double infectionRatio = virus.getInfectionRatio();

        if (random.nextInt(100) < infectionRatio * 100) {
            if (random.nextInt(100) < infectCreature(creature) * 100)
                creature.fallIll(virus);
        }
    }

    public void update() {
        age++;
        if (State.SICK == state && age - stateAge == virus.getIncubationTime())
            changeState(State.CONTAGIOUS);
    }

    public boolean isDead() {
        return State.DEAD.equals(state);
    }

    public boolean isSick() {
        return State.SICK.equals(state)
                || State.CONTAGIOUS.equals(state);
    }

    public boolean isHealthy() {
        return State.HEALTHY.equals(state);
    }

    public State getState() {
        return state;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getStateAge() {
        return stateAge;
    }

    public Virus getVirus() {
        return virus;
    }

    @Override
    public String toString() {
        if (state == State.DEAD)
            return " X ";
        if (virus != null)
            return "(" + this.getClass().getSimpleName().substring(0, 1) + ")";
        return " " + this.getClass().getSimpleName().substring(0, 1) + " ";
    }
}
