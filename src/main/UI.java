package main;

import object.Fish;
import object.Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font comic_40;
    BufferedImage keyImage;
    BufferedImage fishImage;
    public boolean messageOn = false;
    public String message = "";
    int messageTime = 0;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.0");

    public UI(GamePanel gp) {
        this.gp = gp;

        comic_40 = new Font("Comic Sans MS", Font.PLAIN, 40);
        Key key = new Key();
        keyImage = key.image;

        comic_40 = new Font("Comic Sans MS", Font.PLAIN, 40);
        Fish fish = new Fish();
        fishImage = fish.image;
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        // Game State

        // Title State
        if (gp.gameState == gp.titleState) {
            // Title Background
            g2.setColor(new Color(174, 198,  207));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
            // Title Name
            g2.setFont(g2.getFont().deriveFont(Font.ITALIC,60F));
            String text = "Lunaa's Fishy Adventure";
            int x = 65;
            int y = 120;
            // Title Shadow
            g2.setColor(new Color(72,60,50));
            g2.drawString(text, x+3, y+3);
            // Title Color
            g2.setColor(new Color(239,223,187));
            g2.drawString(text, x, y);
            // Lunna Image
            x = 460;
            y = y += gp.tileSize * 2;
            g2.drawImage(gp.player.left2, x, y, gp.tileSize * 2, gp.tileSize * 2, null);
            // Fish Image #1
            x = 300;
            y = 180;
            g2.drawImage(fishImage, x, y, gp.tileSize * 2, gp.tileSize * 2, null);
            // Fish Image #2
            x = 240;
            y = 240;
            g2.drawImage(fishImage, x, y, gp.tileSize * 2, gp.tileSize * 2, null);
            // Fish Image #3
            x = 170;
            y = 160;
            g2.drawImage(fishImage, x, y, gp.tileSize * 2, gp.tileSize * 2, null);

            // Menu
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
            g2.setColor(new Color(72,60,50));
            g2.drawString("Start Game", 262, 392);
            g2.setColor(new Color(239,223,187));
            g2.drawString("Start Game", 260,390);

            g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
            g2.setColor(new Color(72,60,50));
            g2.drawString("Quit", 342, 452);
            g2.setColor(new Color(239,223,187));
            g2.drawString("Quit", 340,450);


        }

        // Play State
        if (gp.gameState == gp.playState) {
            // Key Graphic
            g2.setFont(comic_40);
            g2.setColor(Color.white);
            g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
            g2.drawString("= " + gp.player.hasKey, 70, 60);

            // Fish Graphic
            g2.setFont(comic_40);
            g2.setColor(Color.white);
            g2.drawImage(fishImage, 20, 165 / 2, gp.tileSize, gp.tileSize, null);
            g2.drawString("= " + gp.player.hasFish, 70, 120);

            // Play Time
            if (gp.gameState == gp.pauseState) {
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString("Time:" + dFormat.format(playTime), 600, 55);
            } else if (gp.gameState == gp.playState) {
                playTime += (double) 1 / 60;
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString("Time:" + dFormat.format(playTime), 600, 55);
            }

            // UI Message
            if (messageOn == true) {
                g2.setFont(g2.getFont().deriveFont(20F));
                g2.drawString(message, 300, 100);
                messageTime++;

                if (messageTime > 180) {
                    messageTime = 0;
                    messageOn = false;
                }
            }
        }

        // Pause State
        if (gp.gameState == gp.pauseState) {
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(80F));
            g2.drawString("PAUSED", 225, 300);
        }
    }
}
