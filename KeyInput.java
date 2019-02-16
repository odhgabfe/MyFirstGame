package com.tutorial.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    private boolean[] keyDown = new boolean[4];

    public KeyInput(Handler handler) {
        this.handler = handler;

        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        //System.out.println(key);

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                //key events for Player1 
                
                if (key == KeyEvent.VK_W) { //UP
                    tempObject.setVelY(-5);
                    keyDown[0] = true;
                }
                if (key == KeyEvent.VK_S) { //down
                    tempObject.setVelY(5);
                    keyDown[1] = true;

                }
                if (key == KeyEvent.VK_A) { //left
                    tempObject.setVelX(-5);
                    keyDown[2] = true;

                }
                if (key == KeyEvent.VK_D) { //right
                    tempObject.setVelX(5);
                    keyDown[3] = true;

                }
            }

        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_W) {
                    keyDown[0] = false;
                }
                if (key == KeyEvent.VK_S) {
                    keyDown[1] = false;
                }
                if (key == KeyEvent.VK_A) {
                    keyDown[2] = false;
                }
                if (key == KeyEvent.VK_D) {
                    keyDown[3] = false;
                }

                //vertical movement
                if (!keyDown[0] && !keyDown[1]) {
                    tempObject.setVelY(0);
                }

                //vertical movement
                if (!keyDown[2] && !keyDown[3]) {
                    tempObject.setVelX(0);
                }
            }
        }
    }

}
