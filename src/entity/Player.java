package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    GamePanel gp;
    KeyHandler keyH;

    public final int screenX;
    public final int screenY;

    public int hasKey = 0;
    public int hasFish = 0;

    public Player(GamePanel gp, KeyHandler keyH) {
        super(gp);
        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle(8, 16, 24, 26); // player collision
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 25; //starting point x
        worldY = gp.tileSize * 25; // starting point y
        speed = 4;
        direction = "down";
        maxHealth = 100;
        health = maxHealth;
        hasFish = 0;
        hasKey = 0;
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/lunaa_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/lunaa_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/lunaa_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/lunaa_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/lunaa_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/lunaa_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/lunaa_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/lunaa_right_2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed) {
            if (keyH.upPressed) {
                direction = "up";
            }
            else if (keyH.downPressed) {
                direction = "down";
            }
            else if (keyH.leftPressed) {
                direction = "left";
            }
            else if (keyH.rightPressed) {
                direction = "right";
            }

            // Check tile collision
            collisionOn = false;
            gp.cCheck.checkTile(this);


            // Check object collision
            int objIndex = gp.cCheck.checkObject(this, true);
            pickUpObject(objIndex);

            // Check Enemy Collision
            int enemyIndex = gp.cCheck.checkEntity(this,gp.enemy);
            interactEnemy(enemyIndex);

            // IF collision = false, player can move
            if (collisionOn == false) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }
            spriteCounter++;
            if (spriteCounter > 15) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }
        if (gp.player.health <= 0) {
            gp.gameState = gp.gameOverState;
        }
        if (gp.player.hasFish == 5) {
            gp.gameState = gp.gameCompleteState;
        }
    }

    public void pickUpObject(int i) {
        if (i != 999) {
            String objectName = gp.obj[i].name;
            switch(objectName) {
                case "Key":
                    hasKey++;
                    gp.obj[i] = null;
                    gp.ui.showMessage("Key Obtained");
                    break;
                case "Door":
                    if (hasKey > 0) {
                        gp.obj[i] = null;
                        hasKey--;
                        gp.ui.showMessage("Door unlocked using Key");
                    }
                    else {
                        gp.ui.showMessage("A Key is needed to unlock the Door");
                    }
                    break;
                case "Fish":
                    gp.obj[i] = null;
                    hasFish++;
                    gp.ui.showMessage("Fish Obtained");
                    break;
                case "Potion":
                    gp.player.health += 30;
                    if (gp.player.health > maxHealth) {
                        gp.player.health = 100;
                    }
                    gp.obj[i] = null;
                    gp.ui.showMessage("+30 HP");
                    break;
            }
        }
    }

    public void interactEnemy(int i) {
        if (i != 999) {
            System.out.println("Hitting enemy");
            health -= 1;
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
