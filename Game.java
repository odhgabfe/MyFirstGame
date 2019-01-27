
package com.tutorial.main;

import java.awt.Canvas;


 public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1550691097823471818L;
    
    public static final int WIDTH = 240;
    public static final int HEIGHT = WIDTH / 12 * 9; //FIXED THE WINDOW THING
    public Game(){
        //constructor
        
        new Window(WIDTH, HEIGHT, "GAME WINDOW!!", this);
        
    }
    
    public synchronized void start(){
        
    }
    
    public void run(){
        
        
    } // from Runnable
    
    public static void main(String[] args){
        new Game();
    }
    
}
