package Core.GridGame;

import Core.GridGame.Observers.Observable;

/**
 * Informations about the Game, this class is Observable in order to update the
 * score
 *
 * @author Antoine
 */
public abstract class GridGameInfo extends Observable {

    /**
     * Score
     */
    protected int _score;

    /**
     * Next piece
     */
    private Piece _heldPiece;

    /**
     * Constructor of GridGameInfo
     * @param _score initial score
     */
    public GridGameInfo(int _score) {
        super();
        this._score = _score;
    }

    /**
     * Getter of the score
     * @return int
     */
    public int getScore() {
        return _score;
    }

    /**
     * Setter of Score
     * @param _score int
     */
    public void setScore(int _score) {
        this._score = _score;
    }

    /**
     * Getter of the next piece
     * @return Piece
     */
    public Piece getHeldPiece() {
        return _heldPiece;
    }

    /**
     * Setter of the next piece
     * @param _heldPiece Piece
     */
    public void setHeldPiece(Piece _heldPiece) {
        this._heldPiece = _heldPiece;
    }
    
    /**
     * Update the score by a calculus with the nblignes parameter
     * @param nblignes int
     */
    public abstract void updateScore(int nblignes);
}
