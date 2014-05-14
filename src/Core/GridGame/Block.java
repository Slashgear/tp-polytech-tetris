
package Core.GridGame;

import java.awt.Color;

/**
 * Generic Block of a 2D Grid Game
 * @author Adrien
 * @version 1.0
 */
public class Block {
    /**
     * Color of the Block
     */
    private Color _color;

    /**
     * Getter of _color
     * @return Color of the Block
     */
    public Color getColor() {
        return _color;
    }
    /**
     * Setter of Color
     * @param _color 
     */
    public Block(Color _color){
        this._color = _color;
    }
    /**
     * ToString Function of a block, it display on Output the RGB color of the Block
     * @return String
     */
    @Override
    public String toString() {
        return "Block{" + "_color=" + _color + '}';
    }
    
}
