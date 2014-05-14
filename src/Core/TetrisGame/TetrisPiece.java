package Core.TetrisGame;

import Core.GridGame.Piece;
import Core.GridGame.Shape;
import java.awt.Color;

/**
 *
 * @author Antoine
 */
public class TetrisPiece extends Piece {

    public TetrisPiece() {
        super();
    }

    public TetrisPiece(Shape[] shapes, Color _color, int _x, int _y) {
        super(shapes, _color, _x, _y);
    }

    public TetrisPiece(Shape[] _shapes) {
        super(_shapes);
    }

    public TetrisPiece(Shape[] _shapes, Color _color) {
        super(_shapes, _color);
    }
}
