
import Core.GridGame.Observers.Observable;
import Core.TetrisGame.TetrisCore;
import Core.TetrisGame.TetrisPieceFactory;
import UI.MainFrame;
import java.awt.Color;
import java.awt.event.KeyEvent;

/**
 * class for debugging Project
 *
 * @author Antoine
 */
public class TetrisTest {

    private Thread _game;
    private TetrisCore _tetrisCore;
    private MainFrame _tetrisScreen;

    public TetrisTest() {
        _tetrisCore = new TetrisCore();
        _tetrisScreen = new MainFrame();
        _game = new Thread(_tetrisCore);
        _tetrisCore.getGrid().addGridObserver(_tetrisScreen);
        _tetrisCore.getInfo().addScoreBoardObserver(_tetrisScreen.getScoreBoard());
        _tetrisScreen.setFocusable(true);
        _tetrisScreen.requestFocusInWindow();
        _tetrisScreen.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                Thread t = new Thread("Jambon beurre") {
                    {
                        start();
                    }

                    @Override
                    public void run() {
                        switch (e.getKeyCode()) {
                            case KeyEvent.VK_DOWN:
                                _tetrisCore.getGrid().moveDown();
                                break;
                            case KeyEvent.VK_LEFT:
                                _tetrisCore.getGrid().moveLeft();
                                break;
                            case KeyEvent.VK_RIGHT:
                                _tetrisCore.getGrid().moveRight();
                                break;
                            case KeyEvent.VK_W:
                                _tetrisCore.getGrid().rotateLeft();
                                break;
                            case KeyEvent.VK_X:
                                _tetrisCore.getGrid().rotateRight();
                                break;
                        }

                    }

                };
            }
        });
    }

    public static void main(String[] args) {
        TetrisTest test = new TetrisTest();
        test._tetrisScreen.setVisible(true);
        test._game.start();
    }
}
