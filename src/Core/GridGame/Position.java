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
     * Return the position after making it to go down of one row. (Does not move
     * the position)
     *
     * @return Current position + 1 in rows
     */
    public Position getDownPosition() {
        return new Position(this._x + 1, _y);
    }

    /**
     * Return the position after making it to go up of one row. (Does not move
     * the position)
     *
     * @return Current position - 1 in rows
     */
    public Position getUpPosition() {
        return new Position(this._x - 1, this._y);
    }

    /**
     * Return the position after making it to go left of one column (Does not
     * move the position)
     *
     * @return Current position - 1 in columns
     */
    public Position getLeftPosition() {
        return new Position(this._x, this._y - 1);
    }

    /**
     * Return the position after making it to go right of one column (Does not
     * modify the position)
     *
     * @return Current position + 1 in columns
     */
    public Position getRightPosition() {
        return new Position(this._x, this._y + 1);
    }

    /**
     * Set the position at the down position (row + 1)
     */
    public void setDownPosition() {
        this._x++;
    }

    /**
     * Set the position at the up position (row - 1)
     */
    public void setUpPosition() {
        this._x--;
    }

    /**
     * Set the position at the left position (column - 1)
     */
    public void setLeftPosition() {
        this._y--;
    }

    /**
     * Set the position at the right position (column + 1)
     */
    public void setRightPosition() {
        this._y++;
    }

    /**
     * Return a string of the position
     *
     * @return String of the position
     */
    @Override
    public String toString() {
        return "Position{" + "_x=" + _x + ", _y=" + _y + '}';
    }
}
