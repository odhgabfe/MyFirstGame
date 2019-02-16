package com.tutorial.main;

import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private int scoreKeep = 0;
    private Random r = new Random();

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick() {
        scoreKeep++; //increments with score variable

        if (scoreKeep >= 250) {
            scoreKeep = 0; //reset every 250 points to level up + spawn an enemy
            hud.setLevel(hud.getLevel() + 1);

            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 100), 
                    r.nextInt(Game.HEIGHT - 100),
                    ID.BasicEnemy, handler));
            
            if (hud.getLevel() == 3){
                 handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 100), 
                    r.nextInt(Game.HEIGHT - 100),
                    ID.FastEnemy, handler));
            }
            
            if (hud.getLevel() == 5){
                 handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 100), 
                    r.nextInt(Game.HEIGHT - 100),
                    ID.SmartEnemy, handler));
            }

        }
    }
}
