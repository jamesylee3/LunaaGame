package enemy;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class Snake extends Entity {

    public Snake(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/enemy/snake_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/enemy/snake_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/enemy/snake_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/enemy/snake_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/enemy/snake_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/enemy/snake_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/enemy/snake_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/enemy/snake_right_2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAction() {
        actionCounter++;
        // Direction change 
        if (actionCounter == 30) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75 && i <= 100) {
                direction = "right";
            }
            actionCounter = 0;
        }
    }
}
