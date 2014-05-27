/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.GridGame.Observers.ScoreBoardObserver;
import Core.TetrisGame.TetrisShape;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Panel which is displaying buttons and score of the current Game
 *
 * @author Antoine
 */
public class TetrisScoreBoard extends JPanel implements ScoreBoardObserver {

    private JComponent _next_piece_grid;
    private JLabel _score;
    private JLabel _level;

    public TetrisScoreBoard() {
        super();
        build();
    }

    private void build() {
        this.setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(150,0));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridheight = 1;
        c.weightx = 1;
        c.weighty = 1;
        

        buildNextPieceGrid();
        c.gridx = 0;
        c.gridy = 0;
        this.add(_next_piece_grid, c);

        //Score
        c.gridx = 0;
        c.gridy = 1;
        this.add(new JLabel("Score : "), c);
        c.gridx = 0;
        c.gridy = 2;
        _score = new JLabel("0");
        this.add(_score, c);

        //Level 
        c.gridx = 0;
        c.gridy = 3;
        this.add(new JLabel("Level : "), c);
        c.gridx = 0;
        c.gridy = 4;
        _level = new JLabel("0");
        this.add(_level, c);
    }

    @Override
    public void updateNext(Color[][] tab) {
        for (int i = 0; i < TetrisShape.NB_ROW; i++) {
            for (int j = 0; j < TetrisShape.NB_COL; j++) {
                _next_piece_grid.getComponent((i * (TetrisShape.NB_COL)) + j).setBackground(tab[i][j]);
            }

        }
    }

    @Override
    public void updateScore(int score) {
        Integer i = score;
        _score.setText(i.toString());
    }

    public void buildNextPieceGrid() {
        JPanel nextPieceGrid = new JPanel(new GridBagLayout());
        //Set common constraints for each box
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1;
        c.weighty = 1;

        //Set a black border
        Border blackline = BorderFactory.createLineBorder(Color.black, 1);
        nextPieceGrid.setBorder(blackline);

        //Construct the grid of boxes
        int nb_box = (TetrisShape.NB_ROW) * (TetrisShape.NB_COL);
        for (int i = 0; i < nb_box; i++) {
            c.gridy = (int) i / 4;
            c.gridx = i % 4;
            JComponent tetrisBox = new Box();
            tetrisBox.setBorder(blackline);
            tetrisBox.setBackground(Color.BLACK);
            nextPieceGrid.add(tetrisBox, c);
        }

        _next_piece_grid = nextPieceGrid;
    }

    @Override
    public void updateLevel(int level) {
        Integer i=level;
        _level.setText(i.toString());
    }
}
