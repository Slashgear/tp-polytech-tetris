package Core.TetrisGame;

import Core.GridGame.GridGameCore;
import Core.GridGame.Utilitary;
import static Core.TetrisGame.TetrisGrid.NB_COL;
import static Core.TetrisGame.TetrisGrid.NB_ROW;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antoine
 */
public class TetrisCore extends GridGameCore {

    public static final int NB_NEXTPIECE = 3;
    public static final double BASIC_TEMPO = 0.1f;
    private TetrisGrid _grid;

    
    public TetrisGrid getGrid() {
        return _grid;
    }
    
    
    public void setGrid(TetrisGrid _grid) {
        this._grid = _grid;
    }


    public TetrisCore() {
        super(new TetrisInfo(0), BASIC_TEMPO);
        TetrisPieceFactory factory = new TetrisPieceFactory();
        this.setAvailablePieces(factory.createAvailablePieces());
        this.setGrid(new TetrisGrid());

    }

    public void initGame() {
        for (int i = 0; i < NB_NEXTPIECE; i++) {
            this.getNextPieces().add(createRandomPiece());
        }
        this.getGrid().setCurrentPiece(createRandomPiece());
        this.getNextPieces().add(createRandomPiece());
        this.getInfo().setHeldPiece(this.getNextPieces().pop());
        this.getGrid().fireUpdatedGrid(this.getGrid().getColorTab());
    }

    public TetrisPiece createRandomPiece() {
        TetrisPiece p = (TetrisPiece) this.getAvailablePieces().get(Utilitary.generateRandomNumber(0, this.getAvailablePieces().size() - 1));
        return new TetrisPiece(p.getShapes(), p.getColor());
    }

    public boolean isSpawnFree() {
        for (int i = 3; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.getGrid().getBlocks(i, j).getColor() != Color.white) {
                    return false;
                }
            }
        }
        return true;
    }

    public void gameLoop() {
        //Main game Loop of the game
        boolean pieceFree = true;
        while (true) {
            if (!isSpawnFree()) {
                System.out.println("\n\n\n\n GAME OVER \n\n\n");
                break;
            } else {
                getGrid().spawnPiece();
                while (pieceFree) {
                    try {
                        sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TetrisCore.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    pieceFree = this.getGrid().isDownable();
                    this.getGrid().getCurrentPiece().setPosition(this.getGrid().getCurrentPiece().getPosition().getDownPosition());
                }
                this.getGrid().fixPiece();

            }
        }
    }

    public void nextPiece() {
        this.getGrid().setCurrentPiece(this.getInfo().getHeldPiece());
        this.getNextPieces().add(createRandomPiece());
        this.getInfo().setHeldPiece(this.getNextPieces().pop());
    }

}
