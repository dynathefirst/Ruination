package net.epiccool.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {
    public boolean up, down, left, right;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            up = true;
        }

        if (key == KeyEvent.VK_S) {
            down = true;
        }

        if (key == KeyEvent.VK_A) {
            left = true;
        }

        if (key == KeyEvent.VK_D) {
            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            up = false;
        } else if (key == KeyEvent.VK_S) {
            down = false;
        } else if (key == KeyEvent.VK_A) {
            left = false;
        } else if (key == KeyEvent.VK_D) {
            right = false;
        }
    }
}
