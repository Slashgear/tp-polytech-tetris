/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 * Display of a part of the grid of the game
 * @author Antoine
 */
public class Box extends JPanel{

    public Box() {
        super();
        setBackground(Color.WHITE);
        setMaximumSize(new Dimension(20,20));
    }
}
