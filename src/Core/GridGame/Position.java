
package Core.GridGame;

/**
 *
 * @author Antoine
 */
public class Position {
    private int _x;
    private int _y;

    public int getX() {
        return _x;
    }

    public void setX(int _x) {
        this._x = _x;
    }

    public int getY() {
        return _y;
    }

    public void setY(int _y) {
        this._y = _y;
    }

    public Position(int _x, int _y) {
        this._x = _x;
        this._y = _y;
    }
    
    public Position getDownPosition(){
        return new Position(this._x-1, _y);
    }
}
