package Core.GridGame.Observers;

import java.awt.Color;

/**
 * Observer of the Score Board. It allows throwing informations about the score
 * board model to the View.
 *
 * @author Antoine
 */
public interface ScoreBoardObserver {

    /**
     * Update next piece
     *
     * @param tab, containing the shape in color of the piece
     */
    public void updateNext(Color[][] tab);

    /**
     * Update score
     *
     * @param score
     */
    public void updateScore(int score);

    /**
     * Update level
     *
     * @param level
     */
    public void updateLevel(int level);

}
