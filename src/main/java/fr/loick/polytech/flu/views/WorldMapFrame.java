package fr.loick.polytech.flu.views;

import fr.loick.polytech.flu.world.creatures.Creature;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * A graphical view of the simulation grid. The view displays a colored
 * rectangle for each location representing its contents. Colors for each type
 * of species can be defined using the setColor method.
 *
 * @author Michael Kölling and David J. Barnes
 * @author Loïck MAHIEUX
 */
public class WorldMapFrame extends JFrame {
    // Colors used for empty locations.
    private static final Color EMPTY_COLOR = Color.white;

    // Color used for objects that have no defined color.
    private static final Color UNKNOWN_COLOR = Color.gray;

    private final String STEP_PREFIX = "Step: ";
    private JLabel stepLabel;

    private ChunkFrame chunkFrame;

    // A map for storing colors for participants in the simulation
    private Map<Class, Color> colors;

    /**
     * Create a view of the given width and height.
     *
     * @param height The simulation's height.
     * @param width  The simulation's width.
     */
    public WorldMapFrame(int height, int width) {
        colors = new HashMap<>();

        setTitle("Fox and Rabbit Simulation");
        stepLabel = new JLabel(STEP_PREFIX, JLabel.CENTER);

        setLocation(20, 50);

        chunkFrame = new ChunkFrame(height, width);

        Container contents = getContentPane();
        contents.add(stepLabel, BorderLayout.NORTH);
        contents.add(chunkFrame, BorderLayout.CENTER);

        pack();
        setVisible(true);
    }

    public void setColor(Class<? extends Creature> creatureClass, Color color) {
        colors.put(creatureClass, color);
    }

    /**
     * @return The color to be used for a given class of animal.
     */
    private Color getColor(Creature creature) {
        Color col = colors.get(creature.getClass());
        if (col == null) {
            // no color defined for this class
            return UNKNOWN_COLOR;
        } else {
            return col;
        }
    }
}
