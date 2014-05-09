package Core;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Adrien
 */
public class Piece {

    private ArrayList<Shape> _shapes;
    private Color _color;
    private int _currentRotation;
    //Position of the piece on the grid
    private int _x;
    private int _y;

    public Piece() {
        _currentRotation = 0;
    }

    /**
     * Constructor of Piece
     *
     * @param shapes : ArrayList of Shape
     * @param _color : Color of the piece
     */
    public Piece(ArrayList<Shape> shapes, Color _color, int _x, int _y) {
        this._shapes = shapes;
        this._color = _color;
        this._currentRotation = 0;
        this._x = _x;
        this._y = _y;
    }

    /**
     * Make a 90° degree rotation of the piece, clockwise
     */
    public void rotatePiece() {
        if (_currentRotation == _shapes.size() - 1) {
            _currentRotation = 0;
        } else {
            _currentRotation++;
        }
    }
}
