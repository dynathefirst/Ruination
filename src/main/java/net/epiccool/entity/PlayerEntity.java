package net.epiccool.entity;

import net.epiccool.input.InputHandler;
import net.epiccool.main.Window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class PlayerEntity extends Entity {
    Window w;
    InputHandler i;

    public PlayerEntity(Window w, InputHandler i) {
        this.w = w;
        this.i = i;

        setAttributes();
        getPlayerTexture();
    }

    public void setAttributes() {
        x = 100;
        y = 100;
        speed = 4;
        facing = "down";
    }

    public void update() {
        if (i.up) {
            facing = "up";
            y -= speed;
        }

        if (i.down) {
            facing = "down";
            y += speed;
        }

        if (i.left) {
            facing = "left";
            x -= speed;
        }

        if (i.right) {
            facing = "right";
            x += speed;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage img = null;

        switch (facing) {
            case "down":
                img = d1;
                break;
            case "left":
                img = l1;
                break;
            case "right":
                img = r1;
                break;
            case "up":
                img = u1;
                break;
        }

        g2.drawImage(img, x, y, w.ts, w.ts, null);
    }

    public void getPlayerTexture() {
        try {
            d1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/player_down_1"));
            d2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/player_down_2"));
            l1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/player_left_1"));
            l2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/player_left_2"));
            r1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/player_right_1"));
            r2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/player_right_2"));
            u1 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/player_up_1"));
            u2 = ImageIO.read(getClass().getResourceAsStream("/sprites/player/player_up_2"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
