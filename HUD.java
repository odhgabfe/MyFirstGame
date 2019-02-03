package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

    public static int HEALTH = 100;

    public void tick() {
        
        HEALTH = Game.clamp(HEALTH, 0, HEALTH); //constraints
    }

    public void render(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fill3DRect(20, 20, 200, 20, true);
        //@20,20 w/ 200 width 20 height, RAISED = embossed = true

        g.setColor(Color.red);
        g.fill3DRect(20, 20, HEALTH * 2, 20, true);
        //this fills another rectangle with actual health status

    }
}
