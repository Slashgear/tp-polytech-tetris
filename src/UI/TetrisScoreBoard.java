/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

import Core.GridGame.Observers.ScoreBoardObserver;
import Core.TetrisGame.TetrisShape;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Panel which is displaying buttons and score of the current Game
 * @author Antoine
 */
public class TetrisScoreBoard extends JPanel implements ScoreBoardObserver{

    private JComponent _next_piece_grid;
    private JLabel _score;
     
    public TetrisScoreBoard() {
        super();
        build();
    }

    private void build() {
        _next_piece_grid=new JPanel(new GridLayout(TetrisShape.NB_ROW+2,TetrisShape.NB_COL+2));
        _score=new JLabel();
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        
        _next_piece_grid.setBorder(blackline);
        int nb_box=(TetrisShape.NB_ROW+2)*(TetrisShape.NB_COL+2);
        for(int i=0;i<nb_box;i++){
            JComponent tetrisBox=new Box();
            tetrisBox.setBorder(blackline);
            tetrisBox.setBackground(Color.BLACK);
            _next_piece_grid.add(tetrisBox);
        }
        this.add(new JLabel("Score :"));
        this.add(_score);
        this.add(_next_piece_grid);
    }

    @Override
    public void updateNext(Color[][] tab) {
        for(int i=0;i<TetrisShape.NB_ROW;i++){
            for(int j=0;j<TetrisShape.NB_COL;j++){
                _next_piece_grid.getComponent(((i+1)*(TetrisShape.NB_COL+2))+j+1).setBackground(tab[i][j]);
            }
                
        }
    }

    @Override
    public void updateScore(int score) {
        Integer i=score;
        _score.setText(i.toString());
    }
}
