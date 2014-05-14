package Core.TetrisGame;

import Core.GridGame.Block;
import Core.GridGame.Grid;
import Core.GridGame.Piece;
import Core.GridGame.Position;
import java.awt.Color;

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
        this.getCurrentPiece().setPosition(3, 0);
        fireUpdatedGrid(getColorTab(true));
    }

    @Override
    public boolean newPositionValide(Position nextPosition, int rotation) {
        TetrisShape shape = (TetrisShape) getCurrentPiece().getShape(rotation);

        for (int i = 0; i < TetrisShape.NB_ROW; i++) {
            for (int j = 0; j < TetrisShape.NB_COL; j++) {
                if (shape.getShape(i, j) != 0
                        && nextPosition.getX() + i >= NB_ROW
                        && nextPosition.getY() + j >= NB_COL
                        && this.get(nextPosition.getX() + i, nextPosition.getY() + j).getColor() != Color.white) {
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

    @Override
    public void fixPiece() {
        TetrisShape shape = (TetrisShape) getCurrentPiece().getShape(getCurrentPiece().getCurrentRotation());
        Color c = this.getCurrentPiece().getColor();
        for (int i = 0; i < TetrisShape.NB_ROW; i++) {
            for (int j = 0; j < TetrisShape.NB_COL; j++) {
                if (shape.getShape(i, j) == 1) {
                    this.setBlock(i, j, new Block(c));
                }
            }
        }
        fireUpdatedGrid(this.getColorTab());
    }

    public Color[][] getColorTab(boolean withPiece) {
        if (!withPiece) {
            return super.getColorTab();
        } else {
            Color[][] tab = super.getColorTab();
            TetrisShape shape = (TetrisShape) getCurrentPiece().getShape(getCurrentPiece().getCurrentRotation());
            Color c = this.getCurrentPiece().getColor();
            for (int i = 0; i < TetrisShape.NB_ROW; i++) {
                for (int j = 0; j < TetrisShape.NB_COL; j++) {
                    if (shape.getShape(i, j) == 1) {
                        tab[getCurrentPiece().getPosition().getX() + i][getCurrentPiece().getPosition().getY() + j] = c;
                    }
                }
            }
            return tab;
        }
    }

}
