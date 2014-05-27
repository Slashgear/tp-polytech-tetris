package Core.TetrisGame;

import Core.GridGame.Piece;
import Core.GridGame.Shape;
import java.awt.Color;

/**
 * Piece in Tetris
 *
 * @author Antoine
 */
public class TetrisPiece extends Piece {

    /**
     * Constructor of TetrisPiece. Calling super constructor.
     */
    public TetrisPiece() {
        super();
    }

    /**
     * Full constructor of TetrisPiece. Calling super full constructor.
     *
     * @param shapes, array of shapes of a piece
     * @param _color, color of the piece
     * @param _x, index of rows
     * @param _y, index of rows
     */
    public TetrisPiece(Shape[] shapes, Color _color, int _x, int _y) {
        super(shapes, _color, _x, _y);
    }

    /**
     * Constructor of TetrisPiece. Calling super constructor.
     *
     * @param _shapes , array of shapes of a piece
     */
    public TetrisPiece(Shape[] _shapes) {
        super(_shapes);
    }

    /**
     * Constructor of TetrisPiece. Calling super constructor.
     *
     * @param _shapes, array of shapes of a piece
     * @param _color, color of the piece
     */
    public TetrisPiece(Shape[] _shapes, Color _color) {
        super(_shapes, _color);
    }
}
