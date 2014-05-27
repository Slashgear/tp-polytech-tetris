
package Core.GridGame.Observers;

import java.awt.Color;

/**
 * Observer of the Grid, it allow to trhow information about the Grid Modele to the View
 * @author Antoine
 */
public interface GridObserver {
    /**
     * Update the View of the Grid
     * @param tab The color Tab corresponding to the Grid
     */
   public void update(Color[][] tab);
   /**
    * On Game Over
    */
   public void onGameOver();
}
