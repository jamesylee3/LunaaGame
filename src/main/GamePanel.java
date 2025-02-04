package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 16; // tile is 16 pixels
    final int scale = 3; // used to make our game fit the screen better

    final int tileSize = originalTileSize * scale; // tiles are 48x48
    final int maxScreenCol = 16; // horizontal
    final int maxScreenRow = 12; // vertical

    final int screenWidth = tileSize * maxScreenCol; // 768
    final int screenHeight = tileSize * maxScreenRow; // 576

    Thread gameThread; // allows game to "run" (repeating process)

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while(gameThread != null) {
            System.out.println("Running");

            update();
            repaint();
        }
    }

    public void update() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
