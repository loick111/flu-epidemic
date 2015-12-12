package fr.loick.polytech.flu.world.virus;

import fr.loick.polytech.flu.world.creatures.Chicken;
import fr.loick.polytech.flu.world.creatures.Duck;
import fr.loick.polytech.flu.world.creatures.Human;

/**
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public class H5N1 extends Virus {
    public H5N1() {
        super(0.6);
        addInfectable(Duck.class);
        addInfectable(Chicken.class);
        addInfectable(Human.class);
    }
}
