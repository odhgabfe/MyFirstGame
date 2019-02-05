package com.tutorial.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {

    public static int HEALTH = 100;
    private int greenValue = 255;

    private int score = 0;
    private int level = 1;

    public void tick() {

        HEALTH = Game.clamp(HEALTH, 0, HEALTH); //constraints

        greenValue = HEALTH * 2; //adjust to health bar
        greenValue = Game.clamp(greenValue, 0, 255);
        score++;
    }

    public void render(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fill3DRect(20, 20, 200, 20, true);
        //@20,20 w/ 200 width 20 height, RAISED = embossed = true

        g.setColor(new Color(120, greenValue, 0)); //RGB 
        g.fill3DRect(20, 20, HEALTH * 2, 20, true);
        //this fills another rectangle with actual health status

        //score and level display
        g.drawString("Score: " + score, 20, 64);
        g.drawString("Level: " + level, 20, 80);

    }
    
    public void score(int score){
        this.score = score;
    }
    
    public int getScore(){
        return score;
    }
    
    public int getLevel(){
        return level;
    }
    
    public void setLevel(int level){
        this.level = level;
    }
}
