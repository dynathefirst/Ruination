package net.epiccool.main;

import net.epiccool.entity.PlayerEntity;
import net.epiccool.input.InputHandler;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel implements Runnable {
    final int ots = 16;
    final int s = 3;
    public final int ts = (ots * s);
    final int msw = 16;
    final int msl = 12;
    final int sw = (ts * msw);
    final int sl = (ts * msl );
    int frames = 60;

    InputHandler i = new InputHandler();
    Thread t;
    PlayerEntity player = new PlayerEntity(this, i);

    int pX = 100;
    int pY = 100;
    int pS = 4;

    public Window() {
        this.setPreferredSize(new Dimension(sw, sl));
        this.setBackground(Color.YELLOW);
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
        player.draw(g2);
        g2.dispose();
    }
}
