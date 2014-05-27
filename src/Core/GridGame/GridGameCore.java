package Core.GridGame;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Model of a 2D Grid Game
 *
 * @author Antoine CARON
 * @version 1.0
 */
public abstract class GridGameCore<E extends Grid> implements Runnable {

    /**
     * Grid of the game
     */
    protected E grid;

    /**
     * ArrayList of all the Next Pieces
     */
    private Stack<Piece> _nextPieces;
    /**
     * Available Pieces of this game
     */
    private ArrayList<Piece> _availablePieces;

    /**
     * Temporisation of the Game Loop
     */
    private double _tempo;
    /**
     * Information about the Game
     */
    private GridGameInfo _info;

    /**
     * Getter of Grid Game Info
     *
     * @return GridGameInfo
     */
    public GridGameInfo getInfo() {
        return _info;
    }

    /**
     * Sette of Grid Game Info
     *
     * @param _info GridGameInfo
     */
    public void setInfo(GridGameInfo _info) {
        this._info = _info;
    }

    /**
     * Setter of available pieces
     *
     * @param _availablePieces ArrayList of Piece
     */
    public void setAvailablePieces(ArrayList<Piece> _availablePieces) {
        this._availablePieces = _availablePieces;
    }

    /**
     * Getter of available pieces
     *
     * @return ArrayList of Piece
     */
    public ArrayList<Piece> getAvailablePieces() {
        return _availablePieces;
    }

    /**
     * Getter of next pieces
     *
     * @return Stack of Pieces
     */
    public Stack<Piece> getNextPieces() {
        return _nextPieces;
    }

    /**
     * Getter of the temporisation
     *
     * @return double
     */
    public double getTempo() {
        return _tempo;
    }

    /**
     * Setter of the temporisation
     *
     * @param _tempo double
     */
    public void setTempo(double _tempo) {
        this._tempo = _tempo;
    }

    /**
     * Constructor of a Grid Game
     *
     * @param _info
     * @param _tempo
     */
    public GridGameCore(GridGameInfo _info, double _tempo, E grid) {
        this._info = _info;
        this._tempo = _tempo;
        this._nextPieces = new Stack<Piece>();
        this.grid = grid;
    }

}
