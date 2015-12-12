package fr.loick.polytech.flu.world.virus;

import fr.loick.polytech.flu.world.creatures.Human;
import fr.loick.polytech.flu.world.creatures.Pig;

/**
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public class H1N1 extends Virus {
    public H1N1() {
        super();
        addInfectable(Pig.class);
        addInfectable(Human.class);
    }
}
