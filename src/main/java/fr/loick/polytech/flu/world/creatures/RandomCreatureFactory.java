package fr.loick.polytech.flu.world.creatures;

import java.util.Random;

/**
 * @author Loïck MAHIEUX
 * @date 12/12/15
 */
public class RandomCreatureFactory extends CreatureFactory {
    @Override
    public Creature create() {
        Creature creature = null;
        try {
            Random random = new Random();
            creature = creatures.get(random.nextInt(creatures.size())).newInstance();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return creature;
    }
}
