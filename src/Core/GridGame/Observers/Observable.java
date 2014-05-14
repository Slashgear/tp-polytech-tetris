/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Core.GridGame.Observers;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Antoine
 */
public class Observable {
    private List<GridObserver> observers;
    private List<ScoreBoardObserver> _sb_observer;

    public Observable() {
        observers=new LinkedList<GridObserver>();
        _sb_observer=new LinkedList<ScoreBoardObserver>();
    }
    
    public void addGridObserver(GridObserver observer) {
        observers.add(observer);
    }

    public void removeGridObserver(GridObserver observer) {
        observers.remove(observer);
    }

    public void removeGridObservers() {
        observers.clear();
    }
    
    public void addScoreBoardObserver(ScoreBoardObserver observer) {
        _sb_observer.add(observer);
    }

    public void removeScoreBoardObserver(ScoreBoardObserver observer) {
        _sb_observer.remove(observer);
    }

    public void removeScoreBoardObservers() {
        _sb_observer.clear();
    }
    
    public void fireUpdatedGrid(Color[][] tab){
        for(GridObserver o:observers){
            o.update(tab);
        }
    }
    public void fireUpdateNext(Color[][] tab){
        for(ScoreBoardObserver o:_sb_observer){
            o.updateNext(tab);
        }
    }
}
