/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

/**
 * MenuBar of the Game
 * @author Antoine
 */
public class TetrisMenu extends JMenuBar {

    public TetrisMenu() {
        super();
        JMenu file= new JMenu("Fichier");
        JMenu pause= new JMenu("Pause");
        this.add(file);
        this.add(pause);
    }
    
}
