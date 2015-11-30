package fr.loick.polytech.flu.exceptions;

import fr.loick.polytech.flu.world.Direction;

/**
 * @author Loïck MAHIEUX
 * @date 30/11/15
 */
public class DirectionMoveException extends Exception {
    public DirectionMoveException(Direction direction) {
        super("Can't move to " + direction.toString() + ".");
    }
}
