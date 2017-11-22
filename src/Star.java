import java.awt.*;
import java.security.SecureRandom;
import java.util.Random;

public class Star extends Sprite {
    private static int STAR_HEIGHT = 20;
    private static int STAR_WIDTH = 20;
    private int xLocation;
    private int yLocation;

    public Star() {
        super("Gold_Star.png", STAR_WIDTH, STAR_HEIGHT);
        Random rand = new SecureRandom();
        xLocation = rand.nextInt(1000);
        yLocation = rand.nextInt(700);
        setX(xLocation);
        setY(yLocation);
    }

    public void updateImage(Graphics g) {
        super.updateImage(g);
    }


}
