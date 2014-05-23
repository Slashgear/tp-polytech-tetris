/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.GridGame.Observers.GridObserver;
import Core.TetrisGame.TetrisCore;
import Core.TetrisGame.TetrisGrid;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Frame which is displaying the Tetris Game
 *
 * @author Antoine
 */
public class MainFrame extends JFrame implements GridObserver {

    private JComponent tetrisGrid;
    private TetrisScoreBoard _scoreBoard;

    private TetrisMenu _menu;

    public TetrisScoreBoard getScoreBoard() {
        return _scoreBoard;
    }

    /**
     * Contruct the Main Frame of the Game
     */
    public MainFrame() {
        super();
        setSize(300, 300);
        setResizable(false);
        _scoreBoard = new TetrisScoreBoard();
        _menu = new TetrisMenu();

        build();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
    }

    /**
     * Building the Frame
     */
    public void build() {
        setLayout(new BorderLayout(0, 0));
        JPanel pane = new JPanel();
        pane.setLayout(new BorderLayout(0, 500));
        //adding the components
        tetrisGrid = new JPanel(new GridLayout(TetrisGrid.NB_ROW, TetrisGrid.NB_COL + 2));
        //adding the Listeners

        //SetParameters
        setTitle("Tetris The Game");

        Border blackline = BorderFactory.createLineBorder(Color.black, 1);

        int nb_box = (TetrisGrid.NB_COL + 2) * TetrisGrid.NB_ROW;
        for (int i = 0; i < nb_box; i++) {
            JComponent tetrisBox = new Box();
            tetrisBox.setBorder(blackline);
            tetrisBox.setBackground(Color.BLACK);
            tetrisGrid.add(tetrisBox);
        }

        pane.add(tetrisGrid, BorderLayout.WEST);
        pane.add(_scoreBoard, BorderLayout.EAST);
        this.add(pane, BorderLayout.CENTER);
        this.add(_menu, BorderLayout.NORTH);
    }

    @Override
    public void update(Color[][] tab) {
        for (int i = 0; i < TetrisGrid.NB_ROW; i++) {
            for (int j = 0; j < TetrisGrid.NB_COL; j++) {
                tetrisGrid.getComponent((i * (TetrisGrid.NB_COL + 2)) + j + 1).setBackground(tab[i][j]);
            }

        }
    }
}
