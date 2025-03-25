package main;

import object.Fish;
import object.Key;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class UI {

    GamePanel gp;
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
        g2.setFont(comic_40);
        g2.setColor(Color.white);
        g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
        g2.drawString("= " + gp.player.hasKey, 70, 60);

        g2.setFont(comic_40);
        g2.setColor(Color.white);
        g2.drawImage(fishImage, 20, 165 / 2, gp.tileSize, gp.tileSize, null);
        g2.drawString("= " + gp.player.hasFish, 70, 120);

        // Play Time
        playTime += (double) 1 / 60;
        g2.setFont(g2.getFont().deriveFont(30F));
        g2.drawString("Time:" + dFormat.format(playTime), 600,55);

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
}
