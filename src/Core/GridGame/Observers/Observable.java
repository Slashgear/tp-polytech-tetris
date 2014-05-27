package Core.GridGame.Observers;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 * Observable Type for Data Model in a Grid Game
 *
 * @author Antoine
 * @version 1.0
 */
public class Observable {

    /**
     * Observers of The Grid
     */
    private List<GridObserver> observers;

    /**
     * Observers of informations about the Game
     */
    private List<ScoreBoardObserver> _sb_observer;

    /**
     * Constructor of the Observable Type
     */
    public Observable() {
        observers = new LinkedList<GridObserver>();
        _sb_observer = new LinkedList<ScoreBoardObserver>();
    }

    /**
     * Function which add an observer to the Grid Observer
     *
     * @param observer a GridObserver
     */
    public void addGridObserver(GridObserver observer) {
        observers.add(observer);
    }

    /**
     * Function which remove an observer from the Grid
     *
     * @param observer
     */
    public void removeGridObserver(GridObserver observer) {
        observers.remove(observer);
    }

    /**
     * Fucntion which clear the Observers of the GridObserver
     */
    public void removeGridObservers() {
        observers.clear();
    }

    /**
     * Function which add an observer from the ScoreBoardObserver
     *
     * @param observer, a ScoreBoardObserver
     */
    public void addScoreBoardObserver(ScoreBoardObserver observer) {
        _sb_observer.add(observer);
    }

    /**
     * Function which remove an observer from the ScoreBoardObserver
     *
     * @param observer, a ScoreBoardObserver
     */
    public void removeScoreBoardObserver(ScoreBoardObserver observer) {
        _sb_observer.remove(observer);
    }

    /**
     * Fucntion which clear the Observers of the ScoreBoardObserver
     */
    public void removeScoreBoardObservers() {
        _sb_observer.clear();
    }

    /**
     * Fire the new Information about the Grid
     *
     * @param tab, Color[][]
     */
    synchronized public void fireUpdatedGrid(Color[][] tab) {
        for (GridObserver o : observers) {
            o.update(tab);
        }
    }

    /**
     * Fire the new Information about the NextPiece
     *
     * @param tab, Color[][]
     */
    public void fireUpdateNext(Color[][] tab) {
        for (ScoreBoardObserver o : _sb_observer) {
            o.updateNext(tab);
        }
    }

    /**
     * Fire the new Information about the score
     *
     * @param score, int
     */
    public void fireUpdateScore(int score) {
        for (ScoreBoardObserver o : _sb_observer) {
            o.updateScore(score);
        }
    }

    /**
     * Fire that the game is over
     */
    public void fireGameOver() {
        for (GridObserver o : observers) {
            o.onGameOver();

        }
    }

    /**
     * Fire the new information about the level
     * @param level 
     */
    public void fireUpdatelevel(int level) {
        for (ScoreBoardObserver o : _sb_observer) {
            o.updateLevel(level);
        }
    }
}
