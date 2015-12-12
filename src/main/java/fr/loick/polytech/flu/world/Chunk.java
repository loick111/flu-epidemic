package fr.loick.polytech.flu.world;

import fr.loick.polytech.flu.world.creatures.Creature;

/**
 * @author Loïck MAHIEUX
 * @date 12/12/15
 */
public class Chunk {

    private Integer x;
    private Integer y;
    private Creature creature;

    public Chunk(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public void add(Creature creature) {
        this.creature = creature;
    }

    @Override
    public String toString() {
        if (creature == null)
            return " . ";
        return creature.toString();
    }

    public Creature getCreature() {
        return creature;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public void moveCreature(Chunk toChunk) {
        toChunk.creature = creature;
        creature = null;
    }

    public boolean isFree() {
        return creature == null;
    }

    public void removeCreature() {
        creature = null;
    }
}
