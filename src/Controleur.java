
import Core.TetrisGame.TetrisCore;
import UI.MainFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * class for debugging Project
 *
 * @author Antoine
 */
public class Controleur implements KeyListener {

    private Thread _game;
    private TetrisCore _tetrisCore;
    private MainFrame _tetrisScreen;

    public Controleur() {
        _tetrisCore = new TetrisCore();
        _tetrisScreen = new MainFrame();
        _game = new Thread(_tetrisCore);
        _tetrisCore.getGrid().addGridObserver(_tetrisScreen.getTetrisGrid());
        _tetrisCore.getInfo().addScoreBoardObserver(_tetrisScreen.getScoreBoard());
        _tetrisScreen.setFocusable(true);
        _tetrisScreen.requestFocusInWindow();
        _tetrisScreen.addKeyListener(this);
    }

    public static void main(String[] args) {
        Controleur test = new Controleur();
        test._tetrisScreen.setVisible(true);
        test._game.start();
    }
    
    @Override
    public void keyPressed(final KeyEvent e) {  
        Thread t = new Thread("Processus Clavier") {
            {
                start();
            }
            @Override
            public void run() {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_DOWN:
                        if(_tetrisCore.isGameState()){
                        _tetrisCore.getGrid().moveDown();}
                        break;
                    case KeyEvent.VK_LEFT:
                        if(_tetrisCore.isGameState()){
                        _tetrisCore.getGrid().moveLeft();}
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(_tetrisCore.isGameState()){
                        _tetrisCore.getGrid().moveRight();}
                        break;
                    case KeyEvent.VK_W:
                        if(_tetrisCore.isGameState()){
                        _tetrisCore.getGrid().rotateLeft();}
                        break;
                    case KeyEvent.VK_X:
                        if(_tetrisCore.isGameState()){
                        _tetrisCore.getGrid().rotateRight();}
                        break;
                
                    case KeyEvent.VK_ENTER:
                        _tetrisCore.pause();
                        break;
                }

            }

        };
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
