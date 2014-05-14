package Core.GridGame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Model of a 2D Grid Game
 * @author Antoine CARON
 * @version 1.0
 */
public abstract class GridGameCore extends Thread {

    /**
     * ArrayList of all the Next Piece 
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
    
    public GridGameInfo getInfo() {
        return _info;
    }

    public void setInfo(GridGameInfo _info) {
        this._info = _info;
    }

    public void setAvailablePieces(ArrayList<Piece> _availablePieces) {
        this._availablePieces = _availablePieces;
    }


    public ArrayList<Piece> getAvailablePieces() {
        return _availablePieces;
    }
    

    public Stack<Piece> getNextPieces() {
        return _nextPieces;
    }

    

    public double getTempo() {
        return _tempo;
    }


    public void setTempo(double _tempo) {
        this._tempo = _tempo;
    }


    /**
     * Constructor of a Grid Game
     * @param _info
     * @param _tempo 
     */
    public GridGameCore(GridGameInfo _info, double _tempo) {
        this._info=_info;
        this._tempo = _tempo;
        this._nextPieces=new Stack<Piece>();
    }

}
