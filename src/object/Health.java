package object;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Health extends SuperObject{
    GamePanel gp;

    public Health(GamePanel gp) {

        this.gp = gp;

        name = "Health";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/HP5.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/objects/HP4.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/objects/HP3.png"));
            image4 = ImageIO.read(getClass().getResourceAsStream("/objects/HP2.png"));
            image5 = ImageIO.read(getClass().getResourceAsStream("/objects/HP1.png"));
            image6 = ImageIO.read(getClass().getResourceAsStream("/objects/HP0.png"));
            image7 = ImageIO.read(getClass().getResourceAsStream("/objects/lunaaFace.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

