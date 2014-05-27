/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Controleur.Controleur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 *
 * @author Antoine
 */
public class MainFrame extends JFrame {

    private TetrisMenu _menu;
    private TetrisView[] _views;

    public TetrisMenu getMenu() {
        return _menu;
    }

    public TetrisView[] getViews() {
        return _views;
    }

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

    public void launch(int nb_joueur) {
        JPanel pane=new JPanel(new FlowLayout());
        _views = new TetrisView[nb_joueur];
        for (int i = 0; i < nb_joueur; i++) {
           _views[i]=new TetrisView();
            pane.add(_views[i]);
            
        }
        add(pane,BorderLayout.CENTER);
        this.pack();
    }
    
    public void resetScreen(){
        for(TetrisView v:_views){
            this.remove(v);
        }
    }
}
