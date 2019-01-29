/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author user
 */
public class Player extends GameObject {

    public Player(int x, int y, ID id) {
        super(x, y, id);
        
        //velX = 1; //remove comment later
        //velY = 1; //remove comment later 
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        if(id == ID.Player){
        g.setColor(Color.ORANGE);
        } else {g.setColor(Color.red);}
        
        g.fillRect(x, y, 32, 32);
    }

}
