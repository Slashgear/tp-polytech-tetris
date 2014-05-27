package Core.TetrisGame;

import Core.GridGame.Block;
import Core.GridGame.Grid;
import Core.GridGame.Position;
import java.awt.Color;
import java.util.ArrayList;

/**
 * Grid of a Tetris game
 *
 * @author Antoine
 */
public class TetrisGrid extends Grid {

    /**
     * Number of rows of the grid
     */
    public static final int NB_ROW = 20;

    /**
     * Number of the lines of the grid
     */
    public static final int NB_COL = 10;

    /**
     * Constructor of the tetris grid (NB_ROW by NB_COL)
     */
    public TetrisGrid() {
        super(NB_ROW, NB_COL);
    }

    /**
     * Setter of a Block
     *
     * @param row row of the block choosen
     * @param col column of the block choosen
     * @param block the block seted
     */
    @Override
    public void setBlock(int row, int col, Block block) {
        super.setBlock(row, col, block);
    }

    /**
     * Spawn a piece at the top at the grid and update the grid
     */
    @Override
    public void spawnPiece() {
        this.getCurrentPiece().setPosition(0, 3);
        fireUpdatedGrid(getColorTab(true));
    }

    /**
     * Check that the parameter of the next position of the piece is a valid
     * position. It means that the piece can be on that position.
     *
     * @param nextPosition, Position where the piece will be put
     * @param rotation , index on the list of shapes of the piece
     * @return True if the position is valid. False if not.
     */
    @Override
    public boolean newPositionValide(Position nextPosition, int rotation) {
        TetrisShape shape = (TetrisShape) getCurrentPiece().getShape(rotation);

        for (int i = 0; i < TetrisShape.NB_ROW; i++) {
            for (int j = 0; j < TetrisShape.NB_COL; j++) {
                if (shape.getShape(i, j) != 0
                        && (nextPosition.getX() + i >= NB_ROW
                        || nextPosition.getY() + j >= NB_COL
                        || nextPosition.getX() + i < 0
                        || nextPosition.getY() + j < 0
                        || this.get(nextPosition.getX() + i, nextPosition.getY() + j).getColor() != Color.white)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Check if the piece can me moved by one row down.
     *
     * @return True if it can be moved. False if not
     */
    @Override
    public boolean isDownable() {
        return newPositionValide(this.getCurrentPiece().getPosition().getDownPosition(), getCurrentPiece().getCurrentRotation());
    }

    /**
     * Check if the piece can be rotated to the right
     *
     * @return True if it can be rotated. False if not
     */
    @Override
    public boolean isRightRotable() {
        return newPositionValide(getCurrentPiece().getPosition(), getCurrentPiece().getRightRotation());
    }

    /**
     * Check if the piece can be rotated to the left
     *
     * @return True if it can be rotated. Else, false.
     */
    @Override
    public boolean isLeftRotable() {
        return newPositionValide(getCurrentPiece().getPosition(), getCurrentPiece().getLeftRotation());
    }

    /**
     * Check if the piece can be moved to the right by one column
     *
     * @return True if it can be moved. Else, false.
     */
    public boolean canMoveRight() {
        return newPositionValide(getCurrentPiece().getPosition().getRightPosition(), getCurrentPiece().getCurrentRotation());
    }

    /**
     * Chech if the piece can be moved to the left by one column
     *
     * @return True if it can be moved. Else, false.
     */
    public boolean canMoveLeft() {
        return newPositionValide(getCurrentPiece().getPosition().getLeftPosition(), getCurrentPiece().getCurrentRotation());
    }

    /**
     * Method that place the shape of the piece in the Tetris grid. It sets the
     * color of the piece in it.
     */
    @Override
    public void fixPiece() {
        TetrisShape shape = (TetrisShape) getCurrentPiece().getShape(getCurrentPiece().getCurrentRotation());
        Color c = this.getCurrentPiece().getColor();
        Position p = getCurrentPiece().getPosition();
        for (int i = 0; i < TetrisShape.NB_ROW; i++) {
            for (int j = 0; j < TetrisShape.NB_COL; j++) {
                if (shape.getShape(i, j) == 1) {
                    this.setBlock(p.getX() + i, p.getY() + j, new Block(c));
                }
            }
        }
        fireUpdatedGrid(this.getColorTab());
    }

    /**
     * Get the a matrix of colors from the grid of the game. The boolean
     * withPiece allows (if true) to get this tab with the piece put in there.
     *
     * @param withPiece, true with the piece included, false with the peice if
     * not included
     * @return
     */
    synchronized public Color[][] getColorTab(boolean withPiece) {
        if (!withPiece) {
            return super.getColorTab();
        } else {
            Color[][] tab = super.getColorTab();
            TetrisShape shape = (TetrisShape) getCurrentPiece().getShape(getCurrentPiece().getCurrentRotation());
            Color c = this.getCurrentPiece().getColor();
            Position p = getCurrentPiece().getPosition();
            for (int i = 0; i < TetrisShape.NB_ROW; i++) {
                for (int j = 0; j < TetrisShape.NB_COL; j++) {
                    if (p.getX() + i < TetrisGrid.NB_ROW && p.getY() + j < TetrisGrid.NB_COL && shape.getShape(i, j) == 1) {
                        tab[p.getX() + i][p.getY() + j] = c;
                    }
                }
            }
            return tab;
        }
    }

    /**
     * Destroy complete lines. Return the number of rows destroyed.
     *
     * @return number of rows destroyed
     */
    public int destroyLines() {
        ArrayList<Integer> move_for_lines = new ArrayList<Integer>();
        int nb_move = 0;
        int nb_lines = 0;
        for (int i = NB_ROW - 1; i >= 0; i--) {
            if (isLigneComplete(i)) {
                move_for_lines.add(-1);
                nb_move++;
                nb_lines++;
            } else {
                if (!isLigneEmpty(i)) {
                    move_for_lines.add(nb_move);
                } else {
                    break;
                }
            }
        }
        if (nb_lines > 0) {
            updateGrid(move_for_lines);
        }
        return nb_lines;
    }

    /**
     * Check if the row which index in param, is complete
     *
     * @param index of the row
     * @return True if the row is full. Else false.
     */
    public boolean isLigneComplete(int index) {
        for (int j = 0; j < NB_COL; j++) {
            if (getBlocks(index, j).getColor() == Color.white) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if the row which index in param, is empty
     *
     * @param index of the row
     * @return True if it is empty. Else false.
     */
    public boolean isLigneEmpty(int index) {
        for (int j = 0; j < NB_COL; j++) {
            if (getBlocks(index, j).getColor() != Color.white) {
                return false;
            }
        }
        return true;
    }

    /**
     * Move all the block of a row by a number of rows
     *
     * @param index of the row
     * @param move, number of lines to move
     */
    public void moveLine(int index, int move) {
        for (int i = 0; i < NB_COL; i++) {
            if (move > 0 && getBlocks(index, i).getColor() != Color.white) {
                setBlock(index + move, i, getBlocks(index, i));

            }
        }
        resetLine(index);
    }

    /**
     * Erase the color of all the block of a row
     *
     * @param index of the row
     */
    public void resetLine(int index) {
        Block nullBlock = new Block(Color.white);
        for (int i = 0; i < NB_COL; i++) {
            setBlock(index, i, nullBlock);
        }
        fireUpdatedGrid(getColorTab(true));
    }

    /**
     * Update the grid by moving rows and reseting other rows
     *
     * @param moves list of move for each rows of the grid
     */
    public void updateGrid(ArrayList<Integer> moves) {
        for (int i = 0; i < moves.size(); i++) {
            if (moves.get(i) > 0) {
                moveLine(NB_ROW - (i + 1), moves.get(i));
            } else {
                if (moves.get(i) == -1) {
                    resetLine(NB_ROW - (i + 1));
                }
            }
        }
    }

    /**
     * Make the current piece to move right
     */
    public void moveRight() {
        TetrisPiece p = (TetrisPiece) getCurrentPiece();
        if (p != null && canMoveRight()) {
            p.setPosition(p.getPosition().getRightPosition());
        }
    }

    /**
     * Make the current piece to move left
     */
    public void moveLeft() {
        TetrisPiece p = (TetrisPiece) getCurrentPiece();
        if (p != null && canMoveLeft()) {
            p.setPosition(p.getPosition().getLeftPosition());
        }
    }

    /**
     * Make the current piece to move down faster
     */
    public void moveDown() {
        TetrisPiece p = (TetrisPiece) getCurrentPiece();
        if (p != null && isDownable()) {
            p.setPosition(p.getPosition().getDownPosition());
        }
    }

    /**
     * Rotate the piece anti-clockwise
     */
    public void rotateRight() {
        TetrisPiece p = (TetrisPiece) getCurrentPiece();
        if (p != null && isRightRotable()) {
            p.rotateRightPiece();
        }
    }

    /**
     * Rotate the piece clockwise
     */
    public void rotateLeft() {
        TetrisPiece p = (TetrisPiece) getCurrentPiece();
        if (p != null && isRightRotable()) {
            p.rotateLeftPiece();
        }
    }
}
