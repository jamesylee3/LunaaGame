package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Fish extends SuperObject{

    public Fish() {
        name = "Fish";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/fish.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
