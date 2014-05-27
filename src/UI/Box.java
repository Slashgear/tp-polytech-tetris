package UI;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Display of a part of the grid of the game
 *
 * @author Antoine
 */
public class Box extends JPanel {

    /**
     * Constructor of Box. Set the the color of the box and his dimension.
     */
    public Box() {
        super();
        setBackground(Color.WHITE);
        setMaximumSize(new Dimension(20, 20));
    }
}
