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

    public Color[][] getColorTab(boolean withPiece) {
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
        boolean line_complete = true;
        int nb_lines = 0;
        for (int i = 0; i < NB_ROW; ++i) {
            for (int j = 0; j < NB_COL; ++j) {
                if(this.get(i,j).getColor() == Color.white) {
                    line_complete = false;
                }
            }
            if(line_complete) {
                nb_lines++;
                //Faire fonction de suppression et de décalage de blocks
                line_complete = true;
            }
        }
        return nb_lines;
    }

}
