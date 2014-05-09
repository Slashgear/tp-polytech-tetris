package Core;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Adrien
 */
public class PieceFactory {

    private ArrayList<Piece> _availablePieces;

    /**
     * Create the ArrayList available pieces for the game where you can draw
     * pieces from
     */
    public void createAvailablePieces() {
        ArrayList<Shape> shapes = new ArrayList();
        int[][] shape = {
            {0, 0, 0, 0},
            {1, 2, 1, 0},
            {0, 1, 0, 0},
            {0, 0, 0, 0}
        };
        Shape s = new Shape(shape);
        shapes.add(s);
        Piece square = new Piece(shapes, Color.yellow, 1, 1);
    }

    public Piece drawPiece() {
        return _availablePieces.get(Utilitary.generateRandomNumber(0, _availablePieces.size()-1));
    }
}
