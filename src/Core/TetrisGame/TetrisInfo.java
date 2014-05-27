package Core.TetrisGame;

import Core.GridGame.GridGameInfo;
import Core.GridGame.Piece;
import java.awt.Color;

/**
 * Informations about a Tetris Game
 *
 * @author Antoine
 */
public class TetrisInfo extends GridGameInfo {

    //Score augmentation for the levels
    /**
     * Level 1
     */
    private static final int SCORE_FOR_1 = 40;

    /**
     * Level 2
     */
    private static final int SCORE_FOR_2 = 100;

    /**
     * Level 3
     */
    private static final int SCORE_FOR_3 = 300;

    /**
     * Level 4
     */
    private static final int SCORE_FOR_4 = 1200;

    /**
     * Level scale
     */
    public static final int LEVEL_SCALE = 5000;

    /**
     * Number of lines destroyed
     */
    private int _nb_lines;

    /**
     * Current level
     */
    private int _level;

    /**
     * Getter of current level
     *
     * @return int
     */
    public int getLevel() {
        return _level;
    }

    /**
     * Constructor of TetrisInfo
     *
     * @param _score, initial score
     */
    public TetrisInfo(int _score) {
        super(_score);
        this.fireUpdateScore(_score);
        fireUpdatelevel(_level);
        _level = 0;

    }

    /**
     * Setter of the next piece
     *
     * @param _heldPiece Piece
     */
    @Override
    public void setHeldPiece(Piece _heldPiece) {
        super.setHeldPiece(_heldPiece);
        fireUpdateNext(getHeldPieceColorTab());
    }

    /**
     * Get the matrix of color of the next piece for a display purpose
     *
     * @return Matrix of Color
     */
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

    /**
     * Update the score
     *
     * @param nblignes, number of rows destroyed
     */
    @Override
    public void updateScore(int nblignes) {
        switch (nblignes) {
            case 1:
                _score += SCORE_FOR_1 + (int) (SCORE_FOR_1 * ((float) _level / 3f));
                break;
            case 2:
                _score += SCORE_FOR_2 + (int) (SCORE_FOR_2 * ((float) _level / 3f));
                break;
            case 3:
                _score += SCORE_FOR_3 + (int) (SCORE_FOR_3 * ((float) _level / 3f));
                break;
            case 4:
                _score += SCORE_FOR_4 + (int) (SCORE_FOR_4 * ((float) _level / 3f));
                break;
        }
        fireUpdateScore(_score);
        updateLevel();
    }

    /**
     * Update level
     */
    public void updateLevel() {
        if (_score / LEVEL_SCALE > _level) {
            _level = _score / LEVEL_SCALE;
            fireUpdatelevel(_level);
        }
    }

}
