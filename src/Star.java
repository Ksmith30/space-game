import java.awt.*;
import java.security.SecureRandom;
import java.util.Random;

public class Star extends Sprite {
    private static int STAR_HEIGHT = 20;
    private static int STAR_WIDTH = 20;
    private int xRatio;
    private int yRatio;

    public Star() {
        super("Gold_Star.png", STAR_WIDTH, STAR_HEIGHT);
        Random rand = new SecureRandom();
        int xLocation = rand.nextInt(1000);
        int yLocation = rand.nextInt(700);
        setX(xLocation);
        setY(yLocation);
        xRatio = rand.nextInt(10) - 5;
        yRatio = rand.nextInt(10) - 5;
    }

    public void updateImage(Graphics g) {
        super.updateImage(g);
    }

    public void updateState(int width, int height) {
    }

    public void drive() {
        double z = Math.sqrt((xRatio * xRatio) + (yRatio * yRatio));
        int x = getX();
        int y = getY();
        x += (int) ((10 / z) * xRatio);
        y += (int) ((10 / z) * yRatio);
        setX(x);
        setY(y);
    }


}
