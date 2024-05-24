package net.epiccool.main;

import net.epiccool.entity.CollisionDetector;
import net.epiccool.entity.PlayerEntity;
import net.epiccool.input.InputHandler;
import net.epiccool.tile.Tiles;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel implements Runnable {
    final int ots = 16;
    final int s = 3;
    public final int ts = (ots * s);
    public final int msw = 16;
    public final int msl = 12;
    public final int sw = (ts * msw);
    public final int sl = (ts * msl);
    
    public final int mwc = 20;
    public final int mwr = 20;
    public final int ww = (ts * mwc);
    public final int wh = (ts * mwr);

    int frames = 60;

    Tiles tiles = new Tiles(this);
    InputHandler i = new InputHandler();
    Thread t;
    public CollisionDetector c = new CollisionDetector(this);
    public PlayerEntity player = new PlayerEntity(this, i);

    public Window() {
        this.setPreferredSize(new Dimension(sw, sl));
        this.setBackground(Color.GREEN);
        this.setDoubleBuffered(true);
        this.addKeyListener(i);
        this.setFocusable(true);
    }

    public void start() {
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        double interval = 1000000000 / frames;
        double delta = 0;
        long time = System.nanoTime();
        long currentTime;
        long timer = 0;
        int count = 0;

        while(t != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - time) / interval;
            timer += (currentTime - time);
            time = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                count++;
            }

            if (timer >= 1000000000) {
                System.out.println("FPS: " + count);
                count = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        tiles.draw(g2);
        player.draw(g2);
        g2.dispose();
    }
}
