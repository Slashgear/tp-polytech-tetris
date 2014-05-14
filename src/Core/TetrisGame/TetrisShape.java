package Core.TetrisGame;

import Core.GridGame.Shape;

/**
 *
 * @author Antoine
 */
public class TetrisShape extends Shape {

    public static final int NB_ROW = 4;
    public static final int NB_COL = 4;

    public TetrisShape(int[][] tab) {
        super(tab);
    }
}
