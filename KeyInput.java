package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        //System.out.println(key);
        
        for (int i=0; i<handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.Player){
                //key events for Player1 
                if (key == KeyEvent.VK_W){ //UP
                    tempObject.setY(tempObject.getY()-5);
                }
                if (key == KeyEvent.VK_S){ //down
                    tempObject.setY(tempObject.getY()+5);
                }
                if (key == KeyEvent.VK_A){ //left
                    tempObject.setX(tempObject.getX()-5);
                }
                if (key == KeyEvent.VK_D){ //right
                    tempObject.setX(tempObject.getX()+5);
                }
            }
            
           
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
    }

}
