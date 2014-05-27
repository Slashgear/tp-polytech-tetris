package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Display of the main frame
 *
 * @author Antoine
 */
public class MainFrame extends JFrame {

    /**
     * Menu of the Tetris
     */
    private TetrisMenu _menu;

    /**
     * Views for Tetris
     */
    private TetrisView[] _views;

    /**
     * Getter of the TetrisMenu
     *
     * @return TetrisMenu
     */
    public TetrisMenu getMenu() {
        return _menu;
    }

    /**
     * Getter of the array of TetrisViews
     *
     * @return Array of TetrisViews
     */
    public TetrisView[] getViews() {
        return _views;
    }

    /**
     * Constructor of the MainFrame
     */
    public MainFrame() {
        super();
        setSize(900, 1000);
        setBackground(Color.DARK_GRAY);
        setResizable(false);
        _menu = new TetrisMenu();

        build();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
    }

    /**
     * Building the Frame
     */
    public void build() {
        setBackground(Color.DARK_GRAY);
        setTitle("Tetris The Game");
        this.add(_menu, BorderLayout.NORTH);
    }

    /**
     * Launcher of the game. Initializing all of the components
     * @param nb_joueur 
     */
    public void launch(int nb_joueur) {
        JPanel pane = new JPanel(new FlowLayout());
        _views = new TetrisView[nb_joueur];
        for (int i = 0; i < nb_joueur; i++) {
            _views[i] = new TetrisView();
            pane.add(_views[i]);

        }
        add(pane, BorderLayout.CENTER);
        this.pack();
    }

    /**
     * Reseting the screen by deleting all the views
     */
    public void resetScreen() {
        for (TetrisView v : _views) {
            this.remove(v);
        }
    }
}
