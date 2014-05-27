/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author Antoine
 */
public class TetrisView extends JPanel {
    private Grid _tetrisGrid;
    private TetrisScoreBoard _scoreBoard;

    public Grid getTetrisGrid() {
        return _tetrisGrid;
    }

    public TetrisScoreBoard getScoreBoard() {
        return _scoreBoard;
    }

    public TetrisView() {
        _tetrisGrid = new Grid();
        _scoreBoard = new TetrisScoreBoard();
        setLayout(new BorderLayout(25, 25));
        built();
    }
    
    public void built(){
        this.add(_tetrisGrid,BorderLayout.WEST);
        this.add(_scoreBoard,BorderLayout.CENTER);
    }
    
}
