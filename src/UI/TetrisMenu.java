/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controleur.Controleur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
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

    private ArrayList<JMenuItem> _it;

    public ArrayList<JMenuItem> getIt() {
        return _it;
    }

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
