/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
//import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author user
 */
public class Player extends GameObject {

    Random r = new Random();
    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        //velX = 1; //remove comment later
        //velY = 1; //remove comment later 
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        handler.addObject(new Trail(x, y, ID.Trail, Color.white, 32, 32, 0.08f, handler));

        x = Game.clamp(x, 5, Game.WIDTH - 40); //OFFSET +5, -40 BECAUSE OF WEIRD BEHAVIOUR
        y = Game.clamp(y, 5, Game.HEIGHT - 60); //SAME OFFSER

        collision();
    }

    public void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.BasicEnemy || tempObject.getId() == ID.FastEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH -= 1;

                }
            }

        }
    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.WHITE);
        g.fillRect(x, y, 32, 32);

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }

}
