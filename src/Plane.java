import java.awt.*;

public class Plane extends Sprite {
    private static int PLANE_WIDTH = 30;
    private static int PLANE_HEIGHT = 30;

    public Plane() {
        super("Rocket-ship-Clip-Art.png", PLANE_WIDTH, PLANE_HEIGHT);
        setX(70);
        setY(40);
    }

    public void updateImage(Graphics g) {
        super.updateImage(g);
    }
}
