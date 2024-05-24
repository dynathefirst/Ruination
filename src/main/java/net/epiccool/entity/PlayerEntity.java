package net.epiccool.entity;

import net.epiccool.input.InputHandler;
import net.epiccool.main.Window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class PlayerEntity extends Entity {
    Window w;
    InputHandler i;

    public final int sX;
    public final int sY;

    public PlayerEntity(Window w, InputHandler i) {
        this.w = w;
        this.i = i;

        sX = w.sw / 2 - (w.ts / 2);
        sY = w.sl / 2 - (w.ts / 2);

        hitbox = new Rectangle(8, 16, 32, 32);

        setAttributes();
        getPlayerTexture();
    }

    public void setAttributes() {
        wX = (w.ts * 9);
        wY = (w.ts * 8);
        speed = 5;
        facing = "down";
    }

    public void update() {
        if (i.up || i.down || i.left || i.right) {
            if (i.up) {
                facing = "up";
                wY -= speed;
            }

            if (i.down) {
                facing = "down";
                wY += speed;
            }

            if (i.left) {
                facing = "left";
                wX -= speed;
            }

            if (i.right) {
                facing = "right";
                wX += speed;
            }

            canCollide = false;
            w.c.checkCollision(this);

            counter++;
            if (counter > 12) {
                if (num == 1) {
                    num = 2;
                } else if (num == 2) {
                    num = 1;
                }
                counter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage img = null;

        switch (facing) {
            case "down":
                if (num == 1) {
                    img = d1;
                } else if (num == 2) {
                    img = d2;
                }/* else {
                    img = d;
                }*/
                break;
            case "left":
                if (num == 1) {
                    img = l1;
                } else if (num == 2) {
                    img = l2;
                }/* else {
                    img = d;
                }*/
                break;
            case "right":
                if (num == 1) {
                    img = r1;
                } else if (num == 2) {
                    img = r2;
                }/* else {
                    img = d;
                }*/
                break;
            case "up":
                if (num == 1) {
                    img = u1;
                } else if (num == 2) {
                    img = u2;
                }/* else {
                    img = d;
                }*/
                break;
        }
        g2.drawRect(hitbox.x, hitbox.y, hitbox.width, hitbox.height);
        g2.drawImage(img, sX, sY, w.ts, w.ts, null);
    }

    public void getPlayerTexture() {
        try {
            //d = ImageIO.read(getClass().getClassLoader().getResourceAsStream("sprites/entity/player/default_player.png"));
            d1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("sprites/entity/player/player_down_1.png"));
            d2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("sprites/entity/player/player_down_2.png"));
            l1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("sprites/entity/player/player_left_1.png"));
            l2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("sprites/entity/player/player_left_2.png"));
            r1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("sprites/entity/player/player_right_1.png"));
            r2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("sprites/entity/player/player_right_2.png"));
            u1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("sprites/entity/player/player_up_1.png"));
            u2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("sprites/entity/player/player_up_2.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
