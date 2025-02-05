package main;

import javax.swing.*;
import java.awt.*;
import java.security.Key;

public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 16; // tile is 16 pixels
    final int scale = 3; // used to make our game fit the screen better

    final int tileSize = originalTileSize * scale; // tiles are 48x48
    final int maxScreenCol = 16; // horizontal
    final int maxScreenRow = 12; // vertical

    final int screenWidth = tileSize * maxScreenCol; // 768
    final int screenHeight = tileSize * maxScreenRow; // 576

    final int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread; // allows game to "run" (repeating process)

    // Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while(gameThread != null) {
            
            update();
            repaint();
        }
    }

    public void update() {
        if (keyH.upPressed) {
            playerY -= playerSpeed;
        }
        else if (keyH.downPressed) {
            playerY += playerSpeed;
        }
        else if (keyH.leftPressed) {
            playerX -= playerSpeed;
        }
        else if (keyH.rightPressed) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.white);
        g2.fillRect(playerX,playerY,tileSize,tileSize); // create rectangle
        g2.dispose(); // performs object cleanup
    }
}
