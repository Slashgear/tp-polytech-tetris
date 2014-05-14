package Core.TetrisGame;

import Core.GridGame.GridGameInfo;
import Core.GridGame.Piece;
import java.awt.Color;

/**
 *
 * @author Antoine
 */
public class TetrisInfo extends GridGameInfo {

    public TetrisInfo(int _score) {
        super(_score);
    }

    @Override
    public void setHeldPiece(Piece _heldPiece) {
        super.setHeldPiece(_heldPiece);
        fireUpdateNext(getHeldPieceColorTab());
    }

    private Color[][] getHeldPieceColorTab() {
        Color[][] tab = new Color[TetrisShape.NB_ROW][TetrisShape.NB_COL];
        for (int i = 0; i < TetrisShape.NB_ROW; i++) {
            for (int j = 0; j < TetrisShape.NB_COL; j++) {
                if (this.getHeldPiece().getShape(0).getShape(i, j) == 1) {
                    tab[i][j] = this.getHeldPiece().getColor();
                }

            }
        }
        return tab;
    }
}
