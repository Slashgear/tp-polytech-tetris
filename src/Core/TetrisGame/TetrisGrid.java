package Core.TetrisGame;

import Core.GridGame.Block;
import Core.GridGame.Grid;
import Core.GridGame.Position;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Antoine
 */
public class TetrisGrid extends Grid {

    public static final int NB_ROW = 20;
    public static final int NB_COL = 10;

    public TetrisGrid() {
        super(NB_ROW, NB_COL);
    }

    @Override
    public void setBlock(int row, int col, Block block) {
        super.setBlock(row, col, block);
    }

    @Override
    public void spawnPiece() {
        this.getCurrentPiece().setPosition(0, 3);
        fireUpdatedGrid(getColorTab(true));
    }

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

    @Override
    public boolean isDownable() {
        return newPositionValide(this.getCurrentPiece().getPosition().getDownPosition(), getCurrentPiece().getCurrentRotation());
    }

    @Override
    public boolean isRightRotable() {
        return newPositionValide(getCurrentPiece().getPosition(), getCurrentPiece().getRightRotation());
    }

    @Override
    public boolean isLeftRotable() {
        return newPositionValide(getCurrentPiece().getPosition(), getCurrentPiece().getLeftRotation());
    }

    public boolean canMoveRight() {
        return newPositionValide(getCurrentPiece().getPosition().getRightPosition(), getCurrentPiece().getCurrentRotation());
    }

    public boolean canMoveLeft() {
        return newPositionValide(getCurrentPiece().getPosition().getLeftPosition(), getCurrentPiece().getCurrentRotation());
    }

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

    public boolean isLigneComplete(int index) {
        for (int j = 0; j < NB_COL; j++) {
            if (getBlocks(index, j).getColor() == Color.white) {
                return false;
            }
        }
        //System.out.println("Ligne Complète");
        return true;
    }

    public boolean isLigneEmpty(int index) {
        for (int j = 0; j < NB_COL; j++) {
            if (getBlocks(index, j).getColor() != Color.white) {
                return false;
            }
        }
        return true;
    }

    public void moveLine(int index, int move) {
        for (int i = 0; i < NB_COL; i++) {
            if (move > 0 && getBlocks(index, i).getColor()!=Color.white) {
                setBlock(index + move, i, getBlocks(index, i));
               
            }
        }
        resetLine(index);
    }

    public void resetLine(int index) {
        Block nullBlock = new Block(Color.white);
        for (int i = 0; i < NB_COL; i++) {
            setBlock(index, i, nullBlock);
        }
        fireUpdatedGrid(getColorTab(true));
    }

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

    public void moveRight() {
        TetrisPiece p = (TetrisPiece) getCurrentPiece();
        if (p != null && canMoveRight()) {
            p.setPosition(p.getPosition().getRightPosition());
        }
    }

    public void moveLeft() {
        TetrisPiece p = (TetrisPiece) getCurrentPiece();
        if (p != null && canMoveLeft()) {
            p.setPosition(p.getPosition().getLeftPosition());
        }
    }

    public void moveDown() {
        TetrisPiece p = (TetrisPiece) getCurrentPiece();
        if (p != null && isDownable()) {
            p.setPosition(p.getPosition().getDownPosition());
        }
    }

    public void rotateRight() {
        TetrisPiece p = (TetrisPiece) getCurrentPiece();
        if (p != null && isRightRotable()) {
            p.rotatePiece();
        }
    }

    public void rotateLeft() {
        TetrisPiece p = (TetrisPiece) getCurrentPiece();
        if (p != null && isRightRotable()) {
            p.rotatePiece();
        }
    }
}
