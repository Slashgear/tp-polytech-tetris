package Core.TetrisGame;

import Core.GridGame.GridGameCore;
import Core.GridGame.Utilitary;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Antoine
 */
public class TetrisCore extends GridGameCore<TetrisGrid> {

    public static final int NB_NEXTPIECE = 3;
    public static final double BASIC_TEMPO = 0.1f;

    public TetrisGrid getGrid() {
        return grid;
    }
    
    public TetrisCore() {
        super(new TetrisInfo(0), BASIC_TEMPO,new TetrisGrid());
        TetrisPieceFactory factory = new TetrisPieceFactory();
        this.setAvailablePieces(factory.createAvailablePieces());
    }

    public void initGame() {
        for (int i = 0; i < NB_NEXTPIECE; i++) {
            this.getNextPieces().add(createRandomPiece());
        }
        this.grid.setCurrentPiece(createRandomPiece());
        this.getNextPieces().add(createRandomPiece());
        this.getInfo().setHeldPiece(this.getNextPieces().pop());
        this.grid.fireUpdatedGrid(this.grid.getColorTab());
    }

    public TetrisPiece createRandomPiece() {
        TetrisPiece p = (TetrisPiece) this.getAvailablePieces().get(Utilitary.generateRandomNumber(0, this.getAvailablePieces().size() - 1));
        return new TetrisPiece(p.getShapes(), p.getColor());
    }

    public boolean isSpawnFree() {
        for (int i = 3; i < 7; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.grid.getBlocks(i, j).getColor() != Color.white) {
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
                grid.spawnPiece();
                while (pieceFree) {
                    try {
                        sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TetrisCore.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    pieceFree = this.grid.isDownable();
                    if(pieceFree){
                        this.grid.getCurrentPiece().setPosition(this.grid.getCurrentPiece().getPosition().getDownPosition());
                        this.grid.fireUpdatedGrid(grid.getColorTab(true));
                    }
                }
                this.grid.fixPiece();

            }
        }
    }

    public void nextPiece() {
        this.grid.setCurrentPiece(this.getInfo().getHeldPiece());
        this.getNextPieces().add(createRandomPiece());
        this.getInfo().setHeldPiece(this.getNextPieces().pop());
    }

}
