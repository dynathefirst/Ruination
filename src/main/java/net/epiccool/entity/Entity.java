package net.epiccool.entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public int wX, wY;
    public int speed;

    public BufferedImage d, d1, d2, l1, l2, r1, r2, u1, u2;
    public String facing;

    public int counter = 0;
    public int num = 1;

    public Rectangle hitbox;
    public boolean canCollide = false;
}
