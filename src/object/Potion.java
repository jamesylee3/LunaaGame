package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Potion extends SuperObject {

    public Potion() {
        name = "Potion";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/potion.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
