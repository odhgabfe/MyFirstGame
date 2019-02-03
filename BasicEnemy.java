package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {

    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);
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
    }

    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fill3DRect(x, y, 16, 16, true);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

}
