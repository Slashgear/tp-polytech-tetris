package Core;

import java.util.ArrayList;

/**
 *
 * @author Adrien
 */
public class TetrisCore extends PieceFactory {

    private Piece _currentPiece;
    private Piece _heldPiece;
    private ArrayList<Piece> _nextPieces;
    private int _score;
    private int _tempo;

    public void setCurrentPiece(Piece _currentPiece) {
        this._currentPiece = _currentPiece;
    }

    public void setHeldPiece(Piece _heldPiece) {
        this._heldPiece = _heldPiece;
    }

    public void setScore(int _score) {
        this._score = _score;
    }

    public void run() {
        PieceFactory pf = new PieceFactory();
        pf.createAvailablePieces();
        setCurrentPiece(pf.drawPiece());
        
    }
    
    public void generatePiece(){
        
    }
}
