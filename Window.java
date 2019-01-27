
package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;


public class Window extends Canvas {
    
    private static final long serialVersionUID = -240840600533728354L;
    
    public Window(int width, int height, String title, Game game){
        //constructor
        JFrame frame = new JFrame(title);
        
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        frame.add(game); //make game object to send here
        frame.setVisible(true);
        
        game.start(); //code Game class with a start function later

    }
    
}
