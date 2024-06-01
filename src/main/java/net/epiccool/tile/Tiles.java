package net.epiccool.tile;

import net.epiccool.main.Window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Tiles {
    Window w;
    Tile[] tile;
    public int mapNum[][];

    public Tiles(Window w) {
        this.w = w;
        tile = new Tile[5];
        mapNum = new int[w.mwc][w.mwr];
        getTexture();
        load("maps/world_001.txt");
    }

    public void getTexture() {
        try {
            tile[0] = new Tile();
            tile[0].img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/soil.png"));

            tile[1] = new Tile();
            tile[1].img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/planks.png"));
            tile[1].canCollide = true;

            tile[2] = new Tile();
            tile[2].img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/door.png"));

            tile[3] = new Tile();
            tile[3].img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/shingles.png"));
            tile[3].canCollide = true;

            tile[4] = new Tile();
            tile[4].img = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/docks.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load(String path) {
        InputStream i = getClass().getClassLoader().getResourceAsStream(path);
        BufferedReader b = new BufferedReader(new InputStreamReader(i));

        int vRow = 0;
        int row = 0;

        while (vRow < w.mwc && row < w.mwr) {
            try {
                String l = b.readLine();

                while (vRow < w.mwc) {
                    String nums[] = l.split(" ");

                    int num = Integer.parseInt(nums[vRow]);
                    mapNum[row][vRow] = num;
                    vRow++;
                }

                if (vRow == w.mwc) {
                    vRow = 0;
                    row++;
                }
                b.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public void draw(Graphics2D g2) {
        int wc = 0;
        int wr = 0;

        while (wc < w.mwc && wr < w.mwr) {
            int num = mapNum[wc][wr];
            int wX = (wc * w.ts);
            int wY = (wr * w.ts);
            int sX = (wX - w.player.wX + w.player.sX);
            int sY = (wY - w.player.wY + w.player.sY);

            g2.drawImage(tile[num].img, sX, sY, w.ts, w.ts, null);
            wc++;

            if (wc == w.mwc) {
                wc = 0;
                wr++;
            }
        }
    }
}
