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
    public static final int BASIC_TEMPO = 500;
    private boolean _gameState;

    public boolean isGameState() {
        return _gameState;
    }

    public void setGameState(boolean _gameState) {
        this._gameState = _gameState;
    }

    public TetrisGrid getGrid() {
        return grid;
    }

    public TetrisCore() {
        super(new TetrisInfo(0), BASIC_TEMPO, new TetrisGrid());
        TetrisPieceFactory factory = new TetrisPieceFactory();
        this.setAvailablePieces(factory.createAvailablePieces());
        _gameState = true;
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
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 7; j++) {
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
                this.grid.fireGameOver();
                break;
            } else {
                grid.spawnPiece();
                while (pieceFree) {
                    if (!_gameState) {
                        try {
                            synchronized(this){wait();}
                        } catch (InterruptedException ex) {
                            Logger.getLogger(TetrisCore.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    try {
                        Thread.currentThread().sleep((long) getTempo());
                    } catch (InterruptedException ex) {
                         Thread.currentThread().interrupt();
                         break;
                    }
                    pieceFree = this.grid.isDownable();
                    if (pieceFree) {
                        this.grid.getCurrentPiece().setPosition(this.grid.getCurrentPiece().getPosition().getDownPosition());
                        this.grid.fireUpdatedGrid(grid.getColorTab(true));
                    }
                }
                this.grid.fixPiece();
                getInfo().updateScore(grid.destroyLines());
                updateSpeed();
                this.nextPiece();
                pieceFree = true;
            }
        }
    }

    public void nextPiece() {
        this.grid.setCurrentPiece(this.getInfo().getHeldPiece());
        this.getNextPieces().add(createRandomPiece());
        this.getInfo().setHeldPiece(this.getNextPieces().pop());
    }

    public void pause() {
        if (_gameState) {
            _gameState = false;
        } else {
            synchronized (this) {
                _gameState = true;
                notify();
            }
        }
    }
    public void updateSpeed(){
        if(getTempo()>100){
        this.setTempo(BASIC_TEMPO-100);}else{
            this.setTempo((int)((float)getTempo()/2f));
        }
    }
    
    @Override
    public void run() {
        this.initGame();
        this.gameLoop();
    }
}
