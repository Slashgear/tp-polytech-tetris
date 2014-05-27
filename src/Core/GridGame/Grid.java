package Core.GridGame;

import Core.GridGame.Observers.Observable;
import java.awt.Color;
import java.util.Arrays;

/**
 * Grid of Block in a 2D Grid Game
 *
 * @author Adrien
 * @version 1.0
 */
public abstract class Grid extends Observable {

    /**
     * Array of Blocks
     */
    private Block[][] _blocks;

    /**
     * Current Piece on the Grid
     */
    private Piece _currentPiece;

    /**
     * Getter of the block at the case of indexes x,y
     *
     * @param x index of the row
     * @param y index of the column
     * @return Block at (x,y)
     */
    public Block get(int x, int y) {
        return _blocks[x][y];
    }

    /**
     * Getter of current piece
     *
     * @return Piece
     */
    public Piece getCurrentPiece() {
        return _currentPiece;
    }

    public void setCurrentPiece(Piece _currentPiece) {
        this._currentPiece = _currentPiece;
    }

    /**
     * Getter of a block
     *
     * @param row row of the block choosen
     * @param col column of the block choosen
     * @return Block, the Block choosen
     */
    public Block getBlocks(int row, int col) {
        return _blocks[row][col];
    }

    /**
     * Setter of a Block
     *
     * @param row row of the block choosen
     * @param col column of the block choosen
     * @param block the block seted
     */
    public void setBlock(int row, int col, Block block) {
        _blocks[row][col] = block;
    }

    public void setBlock(int row, int col, Color color) {
        _blocks[row][col] = new Block(color);
    }

    /**
     * Constructor of a Grid
     *
     * @param nb_row number of rows
     * @param nb_col number of columns
     */
    public Grid(int nb_row, int nb_col) {
        super();
        this._blocks = new Block[nb_row][nb_col];
        for (Block[] _block : _blocks) {
            for (int j = 0; j < _blocks[j].length; j++) {
                _block[j] = new Block(Color.white);
            }
        }
    }

    /**
     * Initialize the Grid by setting all the Blocks with white Color
     */
    public void initialiseGrid() {
        for (int i = 0; i < _blocks.length; i++) {
            for (int j = 0; j < _blocks[j].length; j++) {
                setBlock(i, j, new Block(Color.white));
            }
        }
    }

    /**
     * Function which gets the color tab corresponding to the Array of Blocks
     *
     * @return Color[][]
     */
    synchronized public Color[][] getColorTab() {
        Color[][] tab = new Color[_blocks.length][_blocks[0].length];
        for (int i = 0; i < _blocks.length; i++) {
            for (int j = 0; j < _blocks[0].length; j++) {
                tab[i][j] = this.getBlocks(i, j).getColor();
            }
        }
        return tab;
    }

    public abstract void spawnPiece();

    public abstract boolean newPositionValide(Position nextPosition, int rotation);

    public abstract boolean isRightRotable();

    public abstract boolean isDownable();

    public abstract boolean isLeftRotable();

    public abstract void fixPiece();

    /**
     * ToString Function of the Grid
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Grid{" + "_blocks=" + Arrays.deepToString(_blocks) + '}';
    }

}
