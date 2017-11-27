import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends Sprite {
    private static int PLANE_WIDTH = 30;
    private static int PLANE_HEIGHT = 30;
    private static int speed = 10;

    public Plane() {
        super("Rocket-ship-Clip-Art.png", PLANE_WIDTH, PLANE_HEIGHT);
        setX(70);
        setY(40);
    }

    public void updateImage(Graphics g) {
        super.updateImage(g);
    }

    public void drive(int direction) {
        if (direction == KeyEvent.VK_RIGHT) {
            setX(getX() + speed);
            setX(getX() + speed);
        } else if (direction == KeyEvent.VK_LEFT) {
            setX(getX() - speed);
            setX(getX() - speed);
        } else if (direction == KeyEvent.VK_UP) {
            setY(getY() - speed);
            setY(getY() - speed);
        } else if (direction == KeyEvent.VK_DOWN) {
            setY(getY() + speed);
            setY(getY() + speed);
        }
    }
}
