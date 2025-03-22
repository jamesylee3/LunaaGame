package object;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Door extends SuperObject{

    public Door() {
        name = "door";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/objects/door.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
