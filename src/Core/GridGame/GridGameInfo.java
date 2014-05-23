
package Core.GridGame;

import Core.GridGame.Observers.Observable;


/**
 * Information about the Game, this class is Observable in order to get
 * @author Antoine
 */
public abstract class GridGameInfo extends Observable{
    protected int _score;
    private Piece _heldPiece;

    public GridGameInfo(int _score) {
        super();
        this._score = _score;
    }

    public int getScore() {
        return _score;
    }

    public void setScore(int _score) {
        this._score = _score;
    }

    public Piece getHeldPiece() {
        return _heldPiece;
    }

    public void setHeldPiece(Piece _heldPiece) {
        this._heldPiece = _heldPiece;
    }
    public abstract void updateScore(int nblignes);
}
