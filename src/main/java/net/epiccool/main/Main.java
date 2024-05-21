package net.epiccool.main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setTitle("Ruination - 20240521 [error build]");

        Window w = new Window();
        f.add(w);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        w.start();
    }
}