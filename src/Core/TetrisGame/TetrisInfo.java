package Core.TetrisGame;

import Core.GridGame.GridGameInfo;
import Core.GridGame.Piece;
import java.awt.Color;

/**
 *
 * @author Antoine
 */
public class TetrisInfo extends GridGameInfo {

    private static final int SCORE_FOR_1 = 40;
    private static final int SCORE_FOR_2 = 100;
    private static final int SCORE_FOR_3 = 300;
    private static final int SCORE_FOR_4 = 1200;
    private int _nb_lines;
    private int _level;

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

    @Override
    public void updateScore(int nblignes) {
        switch (nblignes) {
            case 1:
                _score += SCORE_FOR_1;
                break;
            case 2:
                _score += SCORE_FOR_2;
                break;
            case 3:
                _score += SCORE_FOR_3;
                break;
            case 4:
                _score += SCORE_FOR_4;
                break;
        }
        fireUpdateScore(_score);
    }
   
}
