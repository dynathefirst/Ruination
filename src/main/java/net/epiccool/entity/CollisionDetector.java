package net.epiccool.entity;

import net.epiccool.main.Window;
import net.epiccool.tile.Tiles;

public class CollisionDetector {
    Window w;

    public CollisionDetector(Window w) {
        this.w = w;
    }

    public void checkCollision(Entity e) {
        int eLefWrlX = e.wX + e.hitbox.x;
        int eRigWrlX = e.wX + e.hitbox.x + e.hitbox.width;
        int eTopWrlY = e.wY + e.hitbox.y;
        int eBotWrlY = e.wY + e.hitbox.y + e.hitbox.height;

        int eLefVertX = eLefWrlX / w.ts;
        int eRigVertX = eRigWrlX / w.ts;
        int eTopX = eTopWrlY / w.ts;
        int eBotX = eBotWrlY / w.ts;

        int num1, num2;

        switch (e.facing) {

            case "up":
                eTopX = (eTopWrlY - e.speed) / w.ts;
                break;

            case "left":
                break;

            case "right":
                break;

            case "down":
                break;
        }
    }
}
