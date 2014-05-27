
package Core.GridGame.Observers;

import java.awt.Color;

/**
 *
 * @author Antoine
 */
public interface ScoreBoardObserver {
    public void updateNext(Color[][] tab);
    public void updateScore(int score);
    public void updateLevel(int level);
    
}
