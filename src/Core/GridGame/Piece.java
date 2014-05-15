package Core.GridGame;

import java.awt.Color;

/**
 * Abstract Piece in a 2D grid Game
 *
 * @author Adrien
 * @version 1.0
 */
public abstract class Piece {

    /**
     * Constant number of Shapes for a Piece in a 2D Grid Game
     */
    public static final int NB_SHAPE = 4;
    /**
     * Array of Shape
     */
    private Shape[] _shapes;
    /**
     * Color of a Piece
     */
    private Color _color;
    /**
     * Current roatation of the Piece, corresponding to the index of the shape
     * in the Array of shapes
     */
    private int _currentRotation;

    private Position _position;

    public void setPosition(Position _position) {
        this._position = _position;
    }

    public Position getPosition() {
        return _position;
    }

    public void setPosition(int x, int y) {
        _position.setX(x);
        _position.setY(y);
    }
    
    

    public int getCurrentRotation() {
        return _currentRotation;
    }

    public int getLeftRotation() {
        return (_currentRotation + 1) % _shapes.length;
    }

    public int getRightRotation() {
        if (_currentRotation - 1 < 0) {
            return _shapes.length - 1;
        } else {
            return _currentRotation -1;
        }
    }

    /**
     * Getter of the Shapes Array
     *
     * @return
     */
    public Shape[] getShapes() {
        return _shapes;
    }

    /**
     * Getter of an indexed shape in the array
     *
     * @param index Index of the shape in the Shapes Array
     * @return Shape, the shape choosen
     */
    public Shape getShape(int index) {
        return _shapes[index];
    }

    /**
     * Default Constructor
     */
    public Piece() {
        _position = new Position();
        _currentRotation = 0;
    }

    /**
     * Getter of the Color
     *
     * @return
     */
    public Color getColor() {
        return _color;
    }

    /**
     * Constructor of the Piece
     *
     * @param shapes array of shapes
     * @param _color color of the Piece to generate
     * @param _x X-Position of the Piece in the Grid
     * @param _y Y-Position of the Piece in the Grid
     */
    public Piece(Shape[] shapes, Color _color, int _x, int _y) {
        this._shapes = shapes;
        this._color = _color;
        this._currentRotation = 0;
        this._position = new Position(_x, _y);
    }

    /**
     * Constructor of a Piece
     *
     * @param _shapes Array of Shapes
     */
    public Piece(Shape[] _shapes) {
        this();
        this._shapes = _shapes;
    }

    /**
     * Constructor of a Piece
     *
     * @param _shapes Array of Shapes
     * @param _color Color of the Piece
     */
    public Piece(Shape[] _shapes, Color _color) {
        this();
        this._shapes = _shapes;
        this._color = _color;
    }

    /**
     * Make a 90° degree rotation of the piece, clockwise
     */
    public void rotatePiece() {
        _currentRotation = (_currentRotation + 1) % _shapes.length;
    }
    
    
}
