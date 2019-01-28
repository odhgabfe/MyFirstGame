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
        //setX(100);
        velX = 1;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillRect(x, y, 32, 32);
    }

}
