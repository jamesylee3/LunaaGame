package main;

import enemy.Snake;
import object.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.text.DecimalFormat;

public class UI {

    GamePanel gp;
    Graphics2D g2;
    Font comic_40;
    BufferedImage keyImage;
    BufferedImage fishImage;
    BufferedImage potionImage;
    BufferedImage lunaaFace;
    BufferedImage hpFive, hpFour, hpThree, hpTwo, hpOne, hpZero;
    public boolean messageOn = false;
    public String message = "";
    int messageTime = 0;
    public int commandNum = 0;

    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.0");

    public UI(GamePanel gp) {
        this.gp = gp;

        Potion potion = new Potion();
        potionImage = potion.image;

        comic_40 = new Font("Comic Sans MS", Font.PLAIN, 40);
        Key key = new Key();
        keyImage = key.image;

        comic_40 = new Font("Comic Sans MS", Font.PLAIN, 40);
        Fish fish = new Fish();
        fishImage = fish.image;

        SuperObject health = new Health(gp);
        hpFive = health.image;
        hpFour = health.image2;
        hpThree = health.image3;
        hpTwo = health.image4;
        hpOne = health.image5;
        hpZero = health.image6;
        lunaaFace = health.image7;
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
            if (commandNum == 0) {
                g2.setColor(new Color(72,60,50));
                g2.drawString(">", 225, 390);
            }

            g2.setColor(new Color(72,60,50));
            g2.drawString("Instructions", 252, 450);
            g2.setColor(new Color(239,223,187));
            g2.drawString("Instructions", 250,450);
            if (commandNum == 1) {
                g2.setColor(new Color(72,60,50));
                g2.drawString(">", 215, 450);
            }

            g2.setFont(g2.getFont().deriveFont(Font.BOLD,48F));
            g2.setColor(new Color(72,60,50));
            g2.drawString("Quit", 342, 510);
            g2.setColor(new Color(239,223,187));
            g2.drawString("Quit", 340,510);
            if (commandNum == 2) {
                g2.setColor(new Color(72,60,50));
                g2.drawString(">", 305, 510);
            }
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

            // PLayer Health
            g2.setColor(Color.red);
            g2.drawString("HP:" + gp.player.health, 80, 520);
            g2.drawImage(lunaaFace, 3, 500, gp.tileSize * 2, gp.tileSize * 2, null);
            if (gp.player.health <= gp.player.maxHealth && gp.player.health >= 81) {
                g2.drawImage(hpFive, 75, 495, gp.tileSize * 5, gp.tileSize * 3, null);
            } else if (gp.player.health <= 80 && gp.player.health >= 61) {
                g2.drawImage(hpFour, 75, 495, gp.tileSize * 5, gp.tileSize * 3, null);
            } else if (gp.player.health <= 60 && gp.player.health >= 41) {
                g2.drawImage(hpThree, 75, 495, gp.tileSize * 5, gp.tileSize * 3, null);
            } else if (gp.player.health <= 40 && gp.player.health >= 21) {
                g2.drawImage(hpTwo, 75, 495, gp.tileSize * 5, gp.tileSize * 3, null);
            } else if (gp.player.health <= 20 && gp.player.health >= 1) {
                g2.drawImage(hpOne, 75, 495, gp.tileSize * 5, gp.tileSize * 3, null);
            }

            // UI Message
            if (messageOn == true) {
                g2.setColor(Color.white);
                g2.setFont(g2.getFont().deriveFont(20F));
                g2.drawString(message, 15, 200);
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

        // Game Over State
        if (gp.gameState == gp.gameOverState) {
            // Background
            g2.setColor(new Color(80,0,0,120));
            g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
            // Game Over Text
            g2.setColor(Color.black);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,80F));
            g2.drawString("GAME OVER", 140-4, 250-4); // Shadow
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,80F));
            g2.drawString("GAME OVER", 140, 250); // Main
            // Restart Game
            g2.setFont(g2.getFont().deriveFont(50f));
            g2.setColor(Color.black);
            g2.drawString("Restart", 300-4,350-4);
            g2.setColor(Color.WHITE);
            g2.drawString("Restart", 300,350);
            if (commandNum == 0) {
                g2.drawString(">", 260,350);
            }
            // Main Menu
            g2.setFont(g2.getFont().deriveFont(50f));
            g2.setColor(Color.black);
            g2.drawString("Main Menu", 260-4,420-4);
            g2.setColor(Color.WHITE);
            g2.drawString("Main Menu", 260,420);
            if (commandNum == 1) {
                g2.drawString(">", 220,420);
            }
        }

        // Game Complete State
        if (gp.gameState == gp.gameCompleteState) {
            // Background
            g2.setColor(new Color(0,80,0,120));
            g2.fillRect(0,0,gp.screenWidth,gp.screenHeight);
            // You Won Text
            g2.setColor(Color.black);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,100F));
            g2.drawString("YOU WON!", 120-4, 200-4); // Shadow
            g2.setColor(Color.yellow);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD,100F));
            g2.drawString("YOU WON!", 120, 200); // Main
            // Main Menu
            g2.setFont(g2.getFont().deriveFont(50f));
            g2.setColor(Color.black);
            g2.drawString("Main Menu", 260-3,350-3);
            g2.setColor(Color.WHITE);
            g2.drawString("Main Menu", 260,350);
            if (commandNum == 0) {
                g2.drawString(">", 220,350);
            }
            // Quit
            g2.setFont(g2.getFont().deriveFont(50f));
            g2.setColor(Color.black);
            g2.drawString("Quit", 325-3,420-3);
            g2.setColor(Color.WHITE);
            g2.drawString("Quit", 325,420);
            if (commandNum == 1) {
                g2.drawString(">", 285,420);
            }
            // Time Text
            g2.setColor(Color.white);
            g2.setFont(g2.getFont().deriveFont(Font.ITALIC,35F));
            g2.drawString("YOUR TIME WAS:" + dFormat.format(playTime), 190,260);
        }
        // Instruct State
        if (gp.gameState == gp.instructState) {
            // Background
            g2.setColor(new Color(174, 198,  207));
            g2.fillRect(0, 0, gp.screenWidth, gp.screenHeight);
            // Instruction Title
            g2.setFont(g2.getFont().deriveFont(Font.ITALIC,60F));
            // How to Play Shadow
            g2.setColor(new Color(72,60,50));
            g2.drawString("How to Play", 58, 93);
            // How to Play
            g2.setColor(new Color(239,223,187));
            g2.drawString("How to Play", 55, 90);
            // Description
            g2.setFont(g2.getFont().deriveFont(18F));
            String instructOne = "Welcome to Lunaa's Fishy Adventure! In this game you will play as Lunaa, the adventurous";
            String instructTwo = "cat. Your objective is to collect all five fish hidden across the island. But be careful there";
            String instructThree = "are dangers that you must avoid in order to survive!";
            String instructFour = "1. Collect the Keys - In order to reach the fish, you must first find the hidden keys to unlock";
            String instructFive = "the doors where the fish are kept.";
            String instructSix = "2. Avoid Hazards - Touching snakes or walking on lava will deal a great deal of damage so";
            String instructSeven = "be sure to avoid them at all costs.";
            String instructEight = "3. Healing - Look out for canned food and use them if your health is getting low.";
            String instructNine = "4. Collect Fish - Once Lunaa gathers all 5 fish, you win the game!";
            String directions = "5. Directions - UP: W / Down: S / Left: A / Right: D";

            g2.setColor(new Color(72,60,50));
            g2.drawString(directions, 20,480);
            g2.drawString(instructOne, 20,150);
            g2.drawString(instructTwo, 20, 170);
            g2.drawString(instructThree, 20, 190);
            g2.drawString(instructFour, 20, 230);
            g2.drawString(instructFive, 20, 250);
            g2.drawImage(keyImage, 20, 255, gp.tileSize - 10, gp.tileSize - 10, null);
            g2.drawString(instructSix, 20, 310);
            g2.drawString(instructSeven, 20, 330);
            g2.drawString(instructEight, 20, 360);
            g2.drawImage(potionImage, 22, 360, gp.tileSize + 2, gp.tileSize + 2, null);
            g2.drawString(instructNine, 20, 420);
            g2.drawImage(fishImage, 22, 415, gp.tileSize, gp.tileSize, null);
            // Back to Menu
            g2.setFont(g2.getFont().deriveFont(50f));
            g2.setColor(new Color(72,60,50));
            g2.drawString("Back", 320 + 2,540 + 2);
            g2.setColor(new Color(239,223,187));
            g2.drawString("Back", 320,540);
            g2.setColor(new Color(72,60,50));
            if (commandNum == 3) {
                g2.drawString(">", 280, 540);
            }
        }
    }
}
