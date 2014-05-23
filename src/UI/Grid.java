package UI;

import Core.GridGame.Observers.GridObserver;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import Core.TetrisGame.TetrisGrid;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

/**
 * @author Antoine
 */
public class Grid extends JPanel implements GridObserver {

    public Grid() {
        super(new GridLayout(TetrisGrid.NB_ROW, TetrisGrid.NB_COL));
        Border blackline = BorderFactory.createLineBorder(Color.black, 1);

        int nb_box = (TetrisGrid.NB_COL) * TetrisGrid.NB_ROW;
        for (int i = 0; i < nb_box; i++) {
            JComponent tetrisBox = new Box();
            tetrisBox.setBorder(blackline);
            tetrisBox.setBackground(Color.BLACK);
            this.add(tetrisBox);
        }
    }

    @Override
    public void update(Color[][] tab) {
         for (int i = 0; i < TetrisGrid.NB_ROW; i++) {
            for (int j = 0; j < TetrisGrid.NB_COL; j++) {
                this.getComponent((i * (TetrisGrid.NB_COL)) + j).setBackground(tab[i][j]);
            }

        }
    }

}
