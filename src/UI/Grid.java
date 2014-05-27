package UI;

import Core.GridGame.Observers.GridObserver;
import Core.TetrisGame.TetrisGrid;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Display the entire grid of the game
 *
 * @author Antoine
 */
public class Grid extends JPanel implements GridObserver {

    /**
     * Constructor of a grid
     */
    public Grid() {
        super(new GridBagLayout());
        this.setPreferredSize(new Dimension(400, 800));
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        Border blackline = BorderFactory.createLineBorder(Color.black, 1);
        int nb_box = (TetrisGrid.NB_COL) * TetrisGrid.NB_ROW;
        for (int i = 0; i < nb_box; i++) {

            c.gridy = (int) i / TetrisGrid.NB_COL;
            c.gridx = i % TetrisGrid.NB_COL;
            JComponent tetrisBox = new Box();
            tetrisBox.setBorder(blackline);
            tetrisBox.setBackground(Color.BLACK);
            this.add(tetrisBox, c);
        }
    }

    /**
     * Update the color graphically of the grid
     * @param tab 
     */
    @Override
    public void update(Color[][] tab) {
        for (int i = 0; i < TetrisGrid.NB_ROW; i++) {
            for (int j = 0; j < TetrisGrid.NB_COL; j++) {
                this.getComponent((i * (TetrisGrid.NB_COL)) + j).setBackground(tab[i][j]);
            }

        }
    }

    /**
     * Function that is doing nothing, Jon Snow. 
     */
    @Override
    public void onGameOver() {
    }

}
