/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import Core.TetrisGame.TetrisCore;
import UI.MainFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Antoine
 */
public class ControleurGame  {
    private Thread _game;
    private TetrisCore _tetrisCore;


    public Thread getGame() {
        return _game;
    }

    public TetrisCore getTetrisCore() {
        return _tetrisCore;
    }
    
    public ControleurGame() {
        _tetrisCore=new TetrisCore();
        _game=new Thread(_tetrisCore);
    }
}
