package UI;

import java.util.ArrayList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * MenuBar of the Game
 *
 * @author Antoine
 */
public class TetrisMenu extends JMenuBar {

    /**
     * ArrayList of item of the menu
     */
    private ArrayList<JMenuItem> _it;

    /**
     * Getter of the items
     *
     * @return Arraylist of the items
     */
    public ArrayList<JMenuItem> getIt() {
        return _it;
    }

    /**
     * Constructor that add all the item of the menu item
     */
    public TetrisMenu() {
        super();
        _it = new ArrayList<JMenuItem>();
        JMenu file = new JMenu("Fichier");
        _it.add(file.add(new JMenuItem("Lancer partie 1 joueur")));

        _it.add(file.add(new JMenuItem("Lancer partie 2 joueurs")));

        _it.add(file.add(new JMenuItem("Pause")));

        _it.add(file.add(new JMenuItem("Quitter")));

        this.add(file);
    }
}
