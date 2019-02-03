package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {

    private Handler handler;

    public BasicEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 3;
        velY = 3;
    }

    public void tick() {
        x += velX;
        y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 40) { //-40 for weird offset 
            velY *= -1; //flip y direction
        }
        if (x <= 0 || x >= Game.WIDTH - 20) {
            velX *= -1; //flip y direction
        }

        handler.addObject(new Trail(x, y, ID.Trail, Color.GREEN, 16, 16, 0.04f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fill3DRect(x, y, 16, 16, true);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

}
