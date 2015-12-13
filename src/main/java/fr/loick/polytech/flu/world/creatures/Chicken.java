package fr.loick.polytech.flu.world.creatures;

import fr.loick.polytech.flu.world.virus.H1N1;

import java.util.Random;

/**
 * This object represents chicken creature
 *
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public class Chicken extends Animal {
    public static final Double INFECTED = 0.3;

    public Chicken() {
        super();
        Random random = new Random();

        if (random.nextInt(100) <= INFECTED * 100)
            fallIll(new H1N1());
    }
}
