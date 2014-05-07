/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * Frame which is displaying the Tetris Game
 * @author Antoine
 */
public class MainFrame extends JFrame{
    /**
     * Contruct the Main Frame of the Game
     */
    public MainFrame() {
        super();
        setSize(300,600);
        setResizable(false);
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
    public void build(){
        
        //adding the components
        JComponent tetrisGrid=new JPanel(new GridLayout(20,10));
        //adding the Listeners
        
        //SetParameters
        setTitle("Tetris The Game");
        
        
        Border blackline = BorderFactory.createLineBorder(Color.black,1);
        tetrisGrid.setBorder(blackline);
        for(int i=0;i<200;i++){
            JComponent tetrisBox=new Box();
            tetrisGrid.add(tetrisBox);
        }
        
        this.add(tetrisGrid);
    }
}
