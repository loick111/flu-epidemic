package fr.loick.polytech.flu.world.creatures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Loïck MAHIEUX
 * @date 12/12/15
 */
public abstract class CreatureFactory {

    protected List<Class<? extends Creature>> creatures;

    public CreatureFactory() {
        creatures = new ArrayList<>();
        creatures.add(Chicken.class);
        creatures.add(Duck.class);
        creatures.add(Human.class);
        creatures.add(Pig.class);
    }

    public abstract Creature create();
}
