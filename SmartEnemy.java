package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {

    private Handler handler;
    private GameObject player;

    public SmartEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 3;
        velY = 3;

        for (int i = 0; i < handler.object.size(); i++) {
            if (handler.object.get(i).getId() == ID.Player) {
                player = handler.object.get(i);//assigned THE Player to player
            }
        }
    }

    public void tick() {
        x += velX;
        y += velY;

        float diffX = x - player.getX() - 8;
        float diffY = y - player.getY() - 8;
        
        float distance = (float) Math.sqrt(diffX*diffX - diffY*diffY);
                //distance formula to seek player distance out
        
        velX = (int) ((-1.0/distance)*diffX)*3;
        velY = (int) ((-1.0/distance)*diffY)*3;

        if (y <= 0 || y >= Game.HEIGHT - 40) { //-40 for weird offset 
            velY *= -1; //flip y direction
        }
        if (x <= 0 || x >= Game.WIDTH - 20) {
            velX *= -1; //flip y direction
        }

        handler.addObject(new Trail(x, y, ID.Trail, Color.MAGENTA, 25, 25, 0.04f, handler));
    }

    public void render(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fill3DRect(x, y, 25, 25, true);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 25, 25);
    }

}
