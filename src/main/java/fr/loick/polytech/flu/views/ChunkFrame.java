package fr.loick.polytech.flu.views;

import javax.swing.*;
import java.awt.*;

/**
 * This object represents a field in the graphical interface
 *
 * @author Loïck MAHIEUX
 * @date 11/12/15
 */
public class ChunkFrame extends JPanel {
    private final int GRID_VIEW_SCALING_FACTOR = 6;
    Dimension size;
    private int gridWidth, gridHeight;
    private int xScale, yScale;
    private Graphics g;
    private Image fieldImage;

    public ChunkFrame(int height, int width) {
        gridHeight = height;
        gridWidth = width;
        size = new Dimension(0, 0);
    }

    public Dimension getPreferredSize() {
        return new Dimension(gridWidth * GRID_VIEW_SCALING_FACTOR,
                gridHeight * GRID_VIEW_SCALING_FACTOR);
    }

    public void preparePaint() {
        if (!size.equals(getSize())) { // if the size has changed...
            size = getSize();
            fieldImage = createImage(size.width, size.height);
            g = fieldImage.getGraphics();

            xScale = size.width / gridWidth;
            if (xScale < 1) {
                xScale = GRID_VIEW_SCALING_FACTOR;
            }
            yScale = size.height / gridHeight;
            if (yScale < 1) {
                yScale = GRID_VIEW_SCALING_FACTOR;
            }
        }
    }

    public void drawMark(int x, int y, Color color) {
        g.setColor(color);
        g.fillRect(x * xScale, y * yScale, xScale - 1, yScale - 1);
    }

    public void paintComponent(Graphics g) {
        if (fieldImage != null) {
            Dimension currentSize = getSize();
            if (size.equals(currentSize)) {
                g.drawImage(fieldImage, 0, 0, null);
            } else {
                // Rescale the previous image.
                g.drawImage(fieldImage, 0, 0, currentSize.width,
                        currentSize.height, null);
            }
        }
    }
}
