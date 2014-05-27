package Core.TetrisGame;

import Core.GridGame.Shape;

/**
 * Shape for tetris pieces
 *
 * @author Antoine
 */
public class TetrisShape extends Shape {

    //Size of the grid containing the shapes
    /**
     * Number of rows
     */
    public static final int NB_ROW = 4;

    /**
     * Number of columns
     */
    public static final int NB_COL = 4;

    /**
     * Constructor of TetrisShape. Calling super constructor.
     *
     * @param tab, shape
     */
    public TetrisShape(int[][] tab) {
        super(tab);
    }
}
