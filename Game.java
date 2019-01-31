package com.tutorial.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1550691097823471818L;

    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12 * 9; //FIXED THE WINDOW THING

    private Thread thread;
    public boolean running = false;

    private Handler handler;
    private Random r;

    public Game() {
        //constructor
        handler = new Handler(); //handler called
        r = new Random();
        this.addKeyListener(new KeyInput(handler)); //listens to key input

        new Window(WIDTH, HEIGHT, "GAME WINDOW!!", this); //window created

        handler.addObject(new Player(100, 100, ID.Player)); //player object created
        //handler.addObject(new Player(200, 200, ID.Player2)); //player2
        for (int i = 0; i < 10; i++) {
            handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy)); //enemy object created
        }
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;

        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime(); //current time
            delta += (now - lastTime) / ns; //change by this delta
            lastTime = now; //move time slider

            while (delta >= 1) {
                tick();
                delta--;
            } // while we have a decent delta the screen ticks

            if (running) {
                render(); //render graphics
            }
            frames++; //update frame count (FPS)

            //end if
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames); //remove comment later
                frames = 0; //AH I MISSED THIS I THINK
                //RESET
            }//end if

        }//end while
        //stop();
    } // from Runnable // end run method

    private void tick() {
        handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.darkGray);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static int clamp(int range, int min, int max) {
        if (range>= max) {
            return range= max; //set upper bound on var
        } else if (range<= min) {
            return range= min; //set lower bound on var
        } else {
            return range; //if it is within bounds return as is.
        }
    }

    public static void main(String[] args) {
        new Game();
    }

}
