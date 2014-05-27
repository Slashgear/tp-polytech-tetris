package UI;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * View of a game of Tetris. It contains the grid and the score board.
 *
 * @author Antoine
 */
public class TetrisView extends JPanel {

    /**
     * Grid of the Tetris
     */
    private Grid _tetrisGrid;

    /**
     * Score board of the Tetris
     */
    private TetrisScoreBoard _scoreBoard;

    /**
     * Getter of the TetrisGrid
     *
     * @return Grid
     */
    public Grid getTetrisGrid() {
        return _tetrisGrid;
    }

    /**
     * Getter of the Score Board
     *
     * @return TetrisScoreBoard
     */
    public TetrisScoreBoard getScoreBoard() {
        return _scoreBoard;
    }

    /**
     * Constructor of a TetrisView : a Grid, a Score Board, a layout and build
     * it
     */
    public TetrisView() {
        _tetrisGrid = new Grid();
        _scoreBoard = new TetrisScoreBoard();
        setLayout(new BorderLayout(25, 25));
        built();
    }

    /**
     * Function to build the tetris view
     */
    public void built() {
        this.add(_tetrisGrid, BorderLayout.WEST);
        this.add(_scoreBoard, BorderLayout.CENTER);
    }

}
