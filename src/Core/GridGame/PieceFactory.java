package Core.GridGame;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Factory of the Game Colors and the different Piece available
 * @author Adrien
 * @version 1.0
 */
public interface PieceFactory {
    /**
     * Create the ArrayList available pieces for the game 
     * @return ArrayList<Piece> available Pieces
     */
    public ArrayList<Piece> createAvailablePieces();
    /**
     * Generate available colors of a Game
     * @return ArrayList<Color> available Colors
     */
    public ArrayList<Color> createAvailableColors();
}
