package Core.TetrisGame;

import Core.GridGame.GridGameCore;
import Core.GridGame.Utilitary;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Core class of Tetris game
 *
 * @author Antoine
 */
public class TetrisCore extends GridGameCore<TetrisGrid> {

    /**
     * Number of next piece to load in memory
     */
    public static final int NB_NEXTPIECE = 3;

    /**
     * Temporisation at initialization of the game
     */
    public static final int BASIC_TEMPO = 500;

    /**
     * Boolean of the game state. True if the game is running. False if it is
     * paused.
     */
    private boolean _gameState;

    /**
     * Get the state of the game
     *
     * @return True if the game is running. False if it is paused
     */
    public boolean isGameState() {
        return _gameState;
    }

    /**
     * Setter of the game state
     *
     * @param _gameState boolean
     */
    public void setGameState(boolean _gameState) {
        this._gameState = _gameState;
    }

    /**
     * Getter of the grid
     *
     * @return grid, TetrisGrid
     */
    public TetrisGrid getGrid() {
        return grid;
    }

    /**
     * Constructor of TetrisCore. Initialize the TetrisInfo as the game is
     * started. Create all the available pieces for the game.
     */
    public TetrisCore() {
        super(new TetrisInfo(0), BASIC_TEMPO, new TetrisGrid());
        TetrisPieceFactory factory = new TetrisPieceFactory();
        this.setAvailablePieces(factory.createAvailablePieces());
        _gameState = true;
    }

    /**
     * Initializing the game. Setting the next pieces. Updating the UI.
     */
    public void initGame() {
        for (int i = 0; i < NB_NEXTPIECE; i++) {
            this.getNextPieces().add(createRandomPiece());
        }
        this.grid.setCurrentPiece(createRandomPiece());
        this.getNextPieces().add(createRandomPiece());
        this.getInfo().setHeldPiece(this.getNextPieces().pop());
        this.grid.fireUpdatedGrid(this.grid.getColorTab());
    }

    /**
     * Create a random Tetris piece
     *
     * @return Tetris piece
     */
    public TetrisPiece createRandomPiece() {
        TetrisPiece p = (TetrisPiece) this.getAvailablePieces().get(Utilitary.generateRandomNumber(0, this.getAvailablePieces().size() - 1));
        return new TetrisPiece(p.getShapes(), p.getColor());
    }

    /**
     * Check if the spawn area at the top of the grid is empty.
     *
     * @return True if spawn is free. Else, false.
     */
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

    /**
     * Game loop
     */
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
                            synchronized (this) {
                                wait();
                            }
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

    /**
     * Set the next piece. Create a new piece to stack for the incoming pieces.
     */
    public void nextPiece() {
        this.grid.setCurrentPiece(this.getInfo().getHeldPiece());
        this.getNextPieces().add(createRandomPiece());
        this.getInfo().setHeldPiece(this.getNextPieces().pop());
    }

    /**
     * Pause the game
     */
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

    /**
     * Update the speed by increasing it.
     */
    public void updateSpeed() {
        if (getTempo() > 100) {
            this.setTempo(BASIC_TEMPO - 100);
        } else {
            this.setTempo((int) ((float) getTempo() / 2f));
        }
    }

    @Override
    public void run() {
        this.initGame();
        this.gameLoop();
    }
}
