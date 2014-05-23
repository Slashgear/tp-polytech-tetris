/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Core.GridGame.Observers.GridObserver;
import Core.TetrisGame.TetrisGrid;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Frame which is displaying the Tetris Game
 *
 * @author Antoine
 */
public class MainFrame extends JFrame {

    private Grid _tetrisGrid;

    public Grid getTetrisGrid() {
        return _tetrisGrid;
    }
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
        setSize(800, 600);
        setResizable(false);
        _scoreBoard = new TetrisScoreBoard();
        _menu = new TetrisMenu();
        _tetrisGrid = new Grid();
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

        //SetParameters
        setTitle("Tetris The Game");

        //adding the components
        this.add(_tetrisGrid, BorderLayout.WEST);
        this.add(_scoreBoard, BorderLayout.CENTER);
        this.add(_menu, BorderLayout.NORTH);
    }
}
