package Controleur;

import Core.TetrisGame.TetrisCore;
import Core.TetrisGame.TetrisGrid;
import UI.MainFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.MenuListener;

/**
 * class for debugging Project
 *
 * @author Antoine
 */
public class Controleur implements KeyListener, ActionListener {

    private MainFrame _tetrisScreen;
    private ControleurGame[] _players;

    public MainFrame getTetrisScreen() {
        return _tetrisScreen;
    }

    public ControleurGame[] getPlayers() {
        return _players;
    }

    public Controleur() {
        _tetrisScreen = new MainFrame();
        addListners();
        _tetrisScreen.setFocusable(true);
        _tetrisScreen.requestFocusInWindow();
        _tetrisScreen.addKeyListener(this);
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        Thread t = new Thread("Processus Clavier") {
            {
                start();
            }

            @Override
            public void run() {
                doAction(e.getKeyCode());
            }
        };
    }

    public void doAction(int keyCode) {
        if (_players != null) {
            if (_players[0].getTetrisCore().isGameState()) {
                switch (keyCode) {
                    case KeyEvent.VK_S:
                        _players[0].getTetrisCore().getGrid().moveDown();
                        break;
                    case KeyEvent.VK_Q:
                        _players[0].getTetrisCore().getGrid().moveLeft();
                        break;
                    case KeyEvent.VK_D:
                        _players[0].getTetrisCore().getGrid().moveRight();
                        break;
                    case KeyEvent.VK_R:
                        _players[0].getTetrisCore().getGrid().rotateLeft();
                        break;
                    case KeyEvent.VK_T:
                        _players[0].getTetrisCore().getGrid().rotateRight();
                        break;
                }
                if (_players.length == 2) {
                    switch (keyCode) {
                        case KeyEvent.VK_DOWN:
                            _players[1].getTetrisCore().getGrid().moveDown();
                            break;
                        case KeyEvent.VK_LEFT:
                            _players[1].getTetrisCore().getGrid().moveLeft();
                            break;
                        case KeyEvent.VK_RIGHT:
                            _players[1].getTetrisCore().getGrid().moveRight();
                            break;
                        case KeyEvent.VK_2:
                            _players[1].getTetrisCore().getGrid().rotateLeft();
                            break;
                        case KeyEvent.VK_3:
                            _players[1].getTetrisCore().getGrid().rotateRight();
                            break;
                    }
                }

            }
            if(keyCode==KeyEvent.VK_ENTER){
                for (ControleurGame _player : _players) {
                    _player.getTetrisCore().pause();
                }
            }
        }
    }

    public void createGame(int number) {
        _tetrisScreen.launch(number);
        _players = new ControleurGame[number];
        for (int i = 0; i < number; i++) {
            _players[i] = new ControleurGame();
            _players[i].getTetrisCore().getGrid().addGridObserver(_tetrisScreen.getViews()[i].getTetrisGrid());
            _players[i].getTetrisCore().getInfo().addScoreBoardObserver(_tetrisScreen.getViews()[i].getScoreBoard());
            _players[i].getGame().start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem it = (JMenuItem) e.getSource();
        if (it.getText().equals("Quitter")) {
            System.exit(0);
        } else {
            if (it.getText().equals("Pause") && _players != null) {
                for (int i = 0; i < _players.length; i++) {
                    _players[i].getTetrisCore().pause();
                }
            } else {
                if (it.getText().equals("Lancer partie 1 joueur")) {
                    if (_players == null) {
                        createGame(1);
                    } else {
                        // shutDownGame();
                        //createGame(1);
                    }

                } else {
                    if (it.getText().equals("Lancer partie 2 joueurs")) {
                        if (_players == null) {
                            createGame(2);
                        } else {
                            // shutDownGame();
                            //createGame(2);
                        }
                    }
                }
            }
        }
    }

    public void addListners() {
        for (JMenuItem i : _tetrisScreen.getMenu().getIt()) {
            i.addActionListener(this);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void shutDownGame() {
        _tetrisScreen.resetScreen();

        for (int i = 0; i < _players.length; i++) {
            _players[i].getGame().interrupt();

        }
    }
}
