package Core.GridGame;

/**
 *
 * @author Antoine
 */
public class Position {

    /**
     * Row index
     */
    private int _x;
    /**
     * Column index
     */
    private int _y;

    public Position() {

    }

    /**
     * Get the row index
     *
     * @return row index
     */
    public int getX() {
        return _x;
    }

    /**
     * Set the row index at the value _x
     *
     * @param _x value of the row index
     */
    public void setX(int _x) {
        this._x = _x;
    }

    /**
     * Get the column index
     *
     * @return column index
     */
    public int getY() {
        return _y;
    }

    /**
     * Set the column index at the value _y
     *
     * @param _y value of the column index
     */
    public void setY(int _y) {
        this._y = _y;
    }

    /**
     * Full constructor
     *
     * @param _x row index
     * @param _y column index
     */
    public Position(int _x, int _y) {
        this._x = _x;
        this._y = _y;
    }

    /**
     * Return the position of the piece after to make it go down of one row.
     * (The function does not move the piece)
     *
     * @return Current position of the piece - 1 in rows
     */
    public Position getDownPosition() {
        return new Position(this._x - 1, _y);
    }
}
