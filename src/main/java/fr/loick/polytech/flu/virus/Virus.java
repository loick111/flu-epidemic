package fr.loick.polytech.flu.virus;

import fr.loick.polytech.flu.creature.Creature;

/**
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public interface Virus {
    Boolean infect(Creature creature);
}
